package com.mycalendar.attributs;

import java.util.Objects;

/**
 * Classe représentant le lieu de l'événement
 * @param value le lieu de l'événement
 */
public record LienVideo(String value) {

    /**
     * Constructeur de la classe LienVideo
     * @param value le lien vidéo de l'événement
     */
    public LienVideo {
        Objects.requireNonNull(value, "Le lien video de la réunion ne peut pas être nul");

        if (value.isBlank()) {
            throw new IllegalArgumentException("Le lien vidéo de la réunion ne peut pas être vide");
        }
    }
}