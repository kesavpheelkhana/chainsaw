package bot.ilda.application.ports.output;

import bot.ilda.domain.model.Color;

public interface ColorManagementOutputPort {

    Color save(Color color);
}
