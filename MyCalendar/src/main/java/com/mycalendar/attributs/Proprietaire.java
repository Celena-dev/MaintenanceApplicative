package com.mycalendar.attributs;

import java.util.Objects;

/**
 * Classe représentant le propriétaire de l'événement
 * @param value le propriétaire de l'événement
 */
public record Proprietaire(String value) {

    /**
     * Constructeur de la classe Proprietaire
     * @param value le propriétaire de l'événement
     */
    public Proprietaire {
        Objects.requireNonNull(value, "Le propriétaire ne peut pas être nul");

        if (value.isBlank()) {
            throw new IllegalArgumentException("Le propriétaire ne peut pas être vide");
        }
    }
}

