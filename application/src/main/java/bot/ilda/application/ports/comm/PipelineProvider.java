package bot.ilda.application.ports.comm;

import bot.ilda.adapters.async.Command.Handler;
import bot.ilda.adapters.async.Command;
import bot.ilda.adapters.async.Notification;
import bot.ilda.adapters.async.Pipeline;
import bot.ilda.adapters.async.Pipelinr;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PipelineProvider {

    @Bean
    public Pipeline getPipeline(
            ObjectProvider<Handler> commandHandlers,
            ObjectProvider<Notification.Handler> notificationHandlers,
            ObjectProvider<Command.Middleware> middlewares) {
        return new Pipelinr()
                .with(() -> commandHandlers.stream())
                .with(() -> notificationHandlers.stream())
                .with(() -> middlewares.orderedStream());
    }
}
