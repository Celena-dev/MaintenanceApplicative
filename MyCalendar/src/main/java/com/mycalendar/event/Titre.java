package com.mycalendar.event;

import java.util.Objects;

public record Titre(String value) {

    public Titre {
        Objects.requireNonNull(value, "Le titre ne peut pas être nul");

        if (value.isBlank()) {
            throw new IllegalArgumentException("Le titre ne peut pas être vide");
        }
    }
}

