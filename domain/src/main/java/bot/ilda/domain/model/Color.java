package bot.ilda.domain.model;

import lombok.Getter;
import lombok.Setter;
import java.time.OffsetDateTime;

@Setter
@Getter
public class Color {

    private Integer id;
    private String name;
    private OffsetDateTime createdDate;
    private OffsetDateTime updatedDate;

}
