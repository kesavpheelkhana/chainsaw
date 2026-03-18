package bot.ilda.domain.model;

import bot.ilda.domain.vo.Id;
import bot.ilda.domain.vo.State;

public class City {
    private final Id id;
    private final String name;
    private final State state;

    public City(Id id, String name, State state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public Id getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }
}