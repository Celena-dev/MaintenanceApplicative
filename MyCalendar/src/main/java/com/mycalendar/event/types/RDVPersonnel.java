package com.mycalendar.event.types;

import com.mycalendar.Event;
import com.mycalendar.event.*;

public class RDVPersonnel extends Event {

    public RDVPersonnel(Titre titre, Proprietaire proprietaire, DateDebut dateDebut, DureeMinute dureeMinute) {
        super(titre, proprietaire, dateDebut, dureeMinute);
    }

    @Override
    public String description() {
        return  "RDV : " + titre + " à " + dateDebut.toString();
    }

}
