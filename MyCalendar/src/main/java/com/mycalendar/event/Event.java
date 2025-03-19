package com.mycalendar.event;

import com.mycalendar.attributs.*;
import com.mycalendar.event.types.Type;

public abstract class Event {
    protected Titre titre;
    protected Proprietaire proprietaire;
    protected Date date;
    protected DureeMinute dureeMinute;
    protected Type type;


    public Event(Titre titre, Proprietaire proprietaire, Date date, DureeMinute dureeMinute, Type type) {
        this.titre = titre;
        this.proprietaire = proprietaire;
        this.date = date;
        this.dureeMinute = dureeMinute;
        this.type = type;
    }

    public abstract String description();

    public abstract boolean estDansPeriode(Date debut, Date fin);

    public abstract boolean conflitAvec(Event autre);


    public Date getDate() {
        return date;
    }
}
