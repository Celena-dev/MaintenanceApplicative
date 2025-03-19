package com.mycalendar.event.types;

import com.mycalendar.Event;
import com.mycalendar.event.*;

public class Reunion extends Event {
    private Lieu lieu;
    private Participants participants;

    public Reunion(Titre titre, Proprietaire proprietaire, DateDebut dateDebut, DureeMinute dureeMinute, Lieu lieu, Participants participants) {
        super(titre, proprietaire, dateDebut, dureeMinute);
        this.lieu = lieu;
        this.participants = participants;
    }

    @Override
    public String description() {
        return  "Réunion : " + titre + " à " + lieu + " avec " + participants;
    }

}
