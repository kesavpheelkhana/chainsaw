package bot.ilda.adapters.rest;

import bot.ilda.adapters.async.Pipeline;
import bot.ilda.application.ports.input.command.CreateColor;
import bot.ilda.application.ports.output.command.ColorResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/colors")
@AllArgsConstructor
public class ColorManagementAdapter {

    private final Pipeline pipeline;

    /**
     * Creates a new Color.
     *
     * @param command the command
     * @return the response entity
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ColorResponse> insert(@RequestBody CreateColor command) {
        var data = pipeline.send(command);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(data.getId()).toUri();
        return ResponseEntity.created(uri).body(data);
    }

}
