package bot.ilda.infra.adapters.jpa.output;

import bot.ilda.application.ports.output.CityManagementOutputPort;
import bot.ilda.domain.model.City;
import bot.ilda.domain.vo.Id;
import bot.ilda.domain.vo.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CityManagementOutAdapter implements CityManagementOutputPort {

//    @Autowired
//    CityRepository cityRepository;

    @Override
    public Optional<City> retrieveCity(Id id) {
        City city = new City(Id.withoutId(),"vzm", State.RJ);
        return Optional.of(city);
    }

    @Override
    public Optional<City> removeCity(Id id) {
        City city = new City(Id.withoutId(),"deletedCity", State.RJ);
        return Optional.of(city);
    }

    @Override
    public City saveCity(City city) {
        City citi = new City(Id.withoutId(),"savingCity", State.RJ);
        return citi;
    }
}