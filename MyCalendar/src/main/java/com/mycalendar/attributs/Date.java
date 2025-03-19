package com.mycalendar.attributs;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Classe représentant la date de l'événement
 * @param value la date de l'événement
 */
public record Date(LocalDateTime value) {

    /**
     * Constructeur de la classe Date
     * @param value la date de l'événement
     */
    public Date {
        Objects.requireNonNull(value, "La date de l'événement ne peut pas être nulle");
    }
}