package com.mycalendar.attributs;

import java.util.List;
import java.util.Objects;

/**
 * Classe représentant les participants de l'événement
 * @param values la liste des participants
 */
public record Participants(List<String> values) {
    /**
     * Constructeur de la classe Participants
     * @param values la liste des participants
     */
    public Participants {
        Objects.requireNonNull(values, "La liste des participants ne peut pas être nulle");

        if (values.isEmpty()) {
            throw new IllegalArgumentException("La liste des participants ne peut pas être vide");
        }
    }

}
