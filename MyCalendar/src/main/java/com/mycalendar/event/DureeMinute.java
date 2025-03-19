package com.mycalendar.event;

public record DureeMinute (int value) {

    public DureeMinute {
        if (value <= 0) {
            throw new IllegalArgumentException("La durée doit être positive");
        }
    }
}