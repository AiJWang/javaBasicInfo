package OptionalStudy;

import java.util.Optional;

public class Man {
    private Optional<Godness> god=Optional.empty();

    public Optional<Godness> getGod() {
        return god;
    }

    public void setGod(Optional<Godness> god) {
        this.god = god;
    }
}
