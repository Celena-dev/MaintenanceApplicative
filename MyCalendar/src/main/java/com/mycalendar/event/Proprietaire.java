package com.mycalendar.event;


import java.util.Objects;

public record Proprietaire(String value) {

    public Proprietaire {
        Objects.requireNonNull(value, "Le propriétaire ne peut pas être nul");

        if (value.isBlank()) {
            throw new IllegalArgumentException("Le propriétaire ne peut pas être vide");
        }
    }
}

