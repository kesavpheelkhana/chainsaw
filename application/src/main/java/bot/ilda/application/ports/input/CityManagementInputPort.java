package bot.ilda.application.ports.input;


import bot.ilda.application.ports.output.CityManagementOutputPort;
import bot.ilda.application.usecases.CityManagementUseCase;
import bot.ilda.domain.factory.CityFactory;
import bot.ilda.domain.model.City;
import bot.ilda.domain.vo.Id;
import bot.ilda.domain.vo.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CityManagementInputPort implements CityManagementUseCase {

    @Autowired
    CityManagementOutputPort cityManagementOutputPort;


    @Override
    public City createCity(String name, State state) {
        var city = CityFactory.createCity(name,state);
        return cityManagementOutputPort.saveCity(city);
    }

    @Override
    public Optional<City> retrieveCity(Id id) {
        return cityManagementOutputPort.retrieveCity(id);
    }

    @Override
    public Optional<City> removeCity(Id id) {
        return cityManagementOutputPort.removeCity(id);
    }
}
