package bot.ilda.adapters.async;

import java.util.stream.Stream;

@FunctionalInterface
public interface CommandHandlers {

  Stream<Command.Handler> supply();
}
