package com.mycalendar.event;

import java.util.List;
import java.util.Objects;

public record Participants(List<String> values) {
    public Participants {
        Objects.requireNonNull(values, "La liste des participants ne peut pas être nulle");

        if (values.isEmpty()) {
            throw new IllegalArgumentException("La liste des participants ne peut pas être vide");
        }
    }

}
