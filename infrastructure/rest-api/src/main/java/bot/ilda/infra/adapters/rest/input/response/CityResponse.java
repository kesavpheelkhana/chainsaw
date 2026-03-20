package bot.ilda.infra.adapters.rest.input.response;

import java.util.UUID;

public record CityResponse(UUID id, String name, String state) {
}
