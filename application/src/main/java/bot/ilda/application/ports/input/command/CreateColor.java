package bot.ilda.application.ports.input.command;

import bot.ilda.adapters.async.Command;
import bot.ilda.application.ports.output.command.ColorResponse;
import lombok.Getter;

@Getter
public class CreateColor implements Command<ColorResponse> {

    private final String name;

    public CreateColor(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CreateColor{" +
                "name='" + name + '\'' +
                '}';
    }
}
