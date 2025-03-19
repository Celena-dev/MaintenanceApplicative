package com.mycalendar.event;

import java.util.Objects;

public record Lieu(String value) {

    public Lieu {
        Objects.requireNonNull(value, "Le lieu ne peut pas être nul");

        if (value.isBlank()) {
            throw new IllegalArgumentException("Le lieu ne peut pas être vide");
        }
    }
}