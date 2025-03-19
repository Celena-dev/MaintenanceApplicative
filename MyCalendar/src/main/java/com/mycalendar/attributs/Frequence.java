package com.mycalendar.attributs;

/**
 * Représente la fréquence d'un événement périodique.
 * @param value la fréquence de l'événement
 */
public record Frequence(int value) {

    /**
     * Constructeur de la classe Frequence
     * @param value la fréquence de l'événement
     */
    public Frequence {
        if (value <= 0) {
            throw new IllegalArgumentException("La fréquence doit être positive");
        }

    }
}