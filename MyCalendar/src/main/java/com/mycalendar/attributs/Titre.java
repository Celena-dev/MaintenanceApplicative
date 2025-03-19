package com.mycalendar.attributs;

import java.util.Objects;

/**
 * Classe représentant le titre de l'événement
 * @param value le titre de l'événement
 */
public record Titre(String value) {

    /**
     * Constructeur de la classe Titre
     * @param value le titre de l'événement
     */
    public Titre {
        Objects.requireNonNull(value, "Le titre ne peut pas être nul");

        if (value.isBlank()) {
            throw new IllegalArgumentException("Le titre ne peut pas être vide");
        }
    }
}

