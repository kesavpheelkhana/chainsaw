package bot.ilda.infra.adapters.async;

import java.util.List;

public interface NotificationHandlingStrategy {

  void handle(List<Runnable> runnableNotifications);
}
