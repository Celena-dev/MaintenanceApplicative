package com.mycalendar.event;

import java.time.LocalDateTime;
import java.util.Objects;

public record DateDebut(LocalDateTime value) {

    public DateDebut {
        Objects.requireNonNull(value, "La date de l'événement ne peut pas être nulle");
    }
}