package bot.ilda.domain.factory;

import bot.ilda.domain.model.City;
import bot.ilda.domain.vo.Id;
import bot.ilda.domain.vo.State;

public class CityFactory {
    public static City createCity(String name, State state) {
        return new City(Id.withoutId(), name, state);
    }

    public static City createCity(String uuid, String name, String state) {
        return new City(Id.withId(uuid), name, State.valueOf(state));
    }
}
