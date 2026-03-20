package bot.ilda.application.ports.middleware;

import bot.ilda.infra.adapters.async.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;

@Component
public class AsyncLoggingMiddleware implements Command.Middleware {

    private static final Logger logger = LoggerFactory.getLogger(AsyncLoggingMiddleware.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
        String timestamp = LocalDateTime.now().format(formatter);
        String commandName = command.getClass().getSimpleName();
        String commandDetails = command.toString();
        
        // Log request start asynchronously
        logAsync("REQUEST_START", timestamp, commandName, commandDetails, null);
        
        long startTime = System.currentTimeMillis();
        
        try {
            // Execute the command
            R result = next.invoke();
            
            // Log successful completion asynchronously
            long duration = System.currentTimeMillis() - startTime;
            logAsync("REQUEST_SUCCESS", timestamp, commandName, commandDetails, duration);
            
            return result;
            
        } catch (Exception e) {
            // Log error asynchronously
            long duration = System.currentTimeMillis() - startTime;
            logErrorAsync("REQUEST_ERROR", timestamp, commandName, commandDetails, duration, e);
            
            // Re-throw the exception
            throw e;
        }
    }

    @Async("asyncExecutor")
    public void logAsync(String event, String timestamp, String commandName, String commandDetails, Long duration) {
        CompletableFuture.runAsync(() -> {
            if (duration != null) {
                logger.info("[{}] {} - Command: {} - Details: {} - Duration: {}ms", 
                    event, timestamp, commandName, commandDetails, duration);
            } else {
                logger.info("[{}] {} - Command: {} - Details: {}", 
                    event, timestamp, commandName, commandDetails);
            }
        });
    }

    @Async("asyncExecutor")
    public void logErrorAsync(String event, String timestamp, String commandName, String commandDetails, Long duration, Exception error) {
        CompletableFuture.runAsync(() -> {
            logger.error("[{}] {} - Command: {} - Details: {} - Duration: {}ms - Error: {}", 
                event, timestamp, commandName, commandDetails, duration, error.getMessage(), error);
        });
    }
}