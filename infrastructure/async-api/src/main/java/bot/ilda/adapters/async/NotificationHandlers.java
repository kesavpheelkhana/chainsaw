package bot.ilda.adapters.async;

import java.util.stream.Stream;

@FunctionalInterface
public interface NotificationHandlers {

  Stream<Notification.Handler> supply();
}
