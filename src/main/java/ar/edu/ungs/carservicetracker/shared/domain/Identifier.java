package ar.edu.ungs.carservicetracker.shared.domain;

import java.util.UUID;

public class Identifier {
    private final UUID value;

    public Identifier(String value) {
        this.value = UUID.fromString(value);
    }

    public String value() {
        return value.toString();
    }
}
