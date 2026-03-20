package bot.ilda.adapters.rest;
import bot.ilda.adapters.rest.input.request.CityRequest;
import bot.ilda.adapters.rest.input.response.CityResponse;
import bot.ilda.application.usecases.CityManagementUseCase;
import bot.ilda.domain.vo.Id;
import bot.ilda.domain.vo.State;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class CityManagementInAdapter {

    @Autowired
    CityManagementUseCase cityManagementUseCase;

    @GetMapping
    public ResponseEntity sayHello(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>("Hello "+name,HttpStatus.ACCEPTED);
    }

    @PostMapping
    public CityResponse create(@RequestBody CityRequest cityRequest) {
        var city = cityManagementUseCase.createCity(cityRequest.name(), State.valueOf(cityRequest.state()));
        return new CityResponse(city.getId().getUuid(), city.getName(), city.getState().name());
    }

    @GetMapping("/{id}")
    public CityResponse retrieve(@PathVariable String id) {
        return cityManagementUseCase.retrieveCity(Id.withId(id))
                .map((city) -> new CityResponse(city.getId().getUuid(), city.getName(), city.getState().name()))
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public CityResponse delete(@PathVariable String id) {
        return cityManagementUseCase.removeCity(Id.withId(id))
                .map((city) -> new CityResponse(city.getId().getUuid(), city.getName(), city.getState().name()))
                .orElse(null);
    }

}