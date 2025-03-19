package com.mycalendar.attributs;

/**
 * Classe représentant la durée en minutes de l'événement
 * @param value la durée en minutes de l'événement
 */
public record DureeMinute (int value) {

    /**
     * Constructeur de la classe DureeMinute
     * @param value la durée en minutes de l'événement
     */
    public DureeMinute {
        if (value <= 0) {
            throw new IllegalArgumentException("La durée doit être positive");
        }
    }
}