package bot.ilda.application.ports.output.command;

import bot.ilda.domain.model.Color;
import lombok.AllArgsConstructor;

import java.time.OffsetDateTime;

@AllArgsConstructor
public class ColorResponse {

    private final int id;
    private final String name;
    private final OffsetDateTime createdDate;

    public static ColorResponse from(final Color color) {
        return new ColorResponse(color.getId(), color.getName(), color.getCreatedDate());
    }

    public int getId() {
        return id;
    }
}
