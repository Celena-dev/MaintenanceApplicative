package com.mycalendar.event.types;

import com.mycalendar.Event;
import com.mycalendar.event.*;

public class Periodique extends Event {
    private Frequence frequence;

    public Periodique(Titre titre, Proprietaire proprietaire, DateDebut dateDebut, DureeMinute dureeMinute, Frequence frequence) {
        super(titre, proprietaire, dateDebut, dureeMinute);
        this.frequence = frequence;
    }

    @Override
    public String description() {
        return "Evénement périodique : " + titre + " à " + dateDebut.toString() + " avec une fréquence de " + frequence.value() + " jours";
    }
}
