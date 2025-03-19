package com.mycalendar.attributs;

import java.util.Objects;

/**
 * Classe représentant le lieu de l'événement
 * @param value le lieu de l'événement
 */
public record Lieu(String value) {

    /**
     * Constructeur de la classe Lieu
     * @param value le lieu de l'événement
     */
    public Lieu {
        Objects.requireNonNull(value, "Le lieu ne peut pas être nul");

        if (value.isBlank()) {
            throw new IllegalArgumentException("Le lieu ne peut pas être vide");
        }
    }
}