package bot.ilda.application.ports.middleware;

import bot.ilda.infra.adapters.async.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Order(3)
//public class TransactionMiddleware implements Command.Middleware {
//
//    private static final Logger logger = LoggerFactory.getLogger(TransactionMiddleware.class);
//
//    @Override
//    @Transactional
//    public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
//        logger.debug("Starting transaction for command: {}", command.getClass().getSimpleName());
//
//        try {
//            // Execute command within transaction
//            R result = next.invoke();
//
//            logger.debug("Transaction completed successfully for command: {}", command.getClass().getSimpleName());
//            return result;
//
//        } catch (Exception e) {
//            logger.error("Transaction failed for command: {} - Error: {}",
//                command.getClass().getSimpleName(), e.getMessage());
//            // Transaction will be rolled back automatically due to @Transactional
//            throw e;
//        }
//    }
//}