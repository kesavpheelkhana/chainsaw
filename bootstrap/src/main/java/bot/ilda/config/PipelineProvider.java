package bot.ilda.application.ports.comm;

import bot.ilda.application.ports.middleware.AsyncLoggingMiddleware;
import bot.ilda.infra.adapters.async.Command;
import bot.ilda.infra.adapters.async.Notification;
import bot.ilda.infra.adapters.async.Pipeline;

import bot.ilda.infra.adapters.async.Pipelinr;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PipelineProvider {

    @Bean
    public Pipeline getPipeline(
            ObjectProvider<Command.Handler> commandHandlers,
            ObjectProvider<Notification.Handler> notificationHandlers,
            ObjectProvider<Command.Middleware> middlewares,
            AsyncLoggingMiddleware loggingMiddleware) {
        Pipelinr pipelinr = new Pipelinr();
        pipelinr.with(() -> commandHandlers.stream());
        pipelinr.with(() -> notificationHandlers.stream());
        pipelinr.with(() -> java.util.stream.Stream.concat(
                java.util.stream.Stream.of(loggingMiddleware),
                middlewares.orderedStream()
        ));
        return pipelinr;
    }
}
