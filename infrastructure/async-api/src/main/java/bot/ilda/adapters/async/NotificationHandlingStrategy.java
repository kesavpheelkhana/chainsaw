package bot.ilda.adapters.async;

import java.util.List;

public interface NotificationHandlingStrategy {

  void handle(List<Runnable> runnableNotifications);
}
