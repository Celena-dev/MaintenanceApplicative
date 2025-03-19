package com.mycalendar.event;

public record Frequence(int value) {

    public Frequence {
        if (value <= 0) {
            throw new IllegalArgumentException("La fréquence doit être positive");
        }

    }
}