package bot.ilda.application.usecases;

import bot.ilda.application.ports.input.command.CreateColor;
import bot.ilda.domain.model.Color;

public interface ColorManagementUseCase {
    Color insert(CreateColor createColor);
}
