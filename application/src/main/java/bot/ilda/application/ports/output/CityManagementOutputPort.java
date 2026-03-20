package bot.ilda.application.ports.output;

import bot.ilda.domain.model.City;
import bot.ilda.domain.vo.Id;

import java.util.Optional;

public interface CityManagementOutputPort {

    Optional<City> retrieveCity(Id id);

    Optional<City> removeCity(Id id);

    City saveCity(City city);
}
