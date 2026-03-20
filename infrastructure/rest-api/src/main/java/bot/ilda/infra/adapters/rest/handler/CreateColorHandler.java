package bot.ilda.infra.adapters.rest.handler;

import bot.ilda.application.ports.input.command.CreateColor;
import bot.ilda.application.ports.output.command.ColorResponse;
import bot.ilda.domain.model.Color;
import bot.ilda.infra.adapters.async.Command;
import org.springframework.stereotype.Component;

@Component
public class CreateColorHandler implements Command.Handler<CreateColor, ColorResponse> {

    @Override
    public ColorResponse handle(CreateColor command) {

        var color = new Color();
        color.setName(command.getName());
        try{
            System.out.println("saving created color "+color);
            color.setId(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ColorResponse.from(color);
    }
}
