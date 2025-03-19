package com.mycalendar;
import com.mycalendar.event.*;

public abstract class Event {
    protected Titre titre;
    protected Proprietaire proprietaire;
    protected DateDebut dateDebut;
    protected DureeMinute dureeMinute;

    public Event(Titre titre, Proprietaire proprietaire, DateDebut dateDebut, DureeMinute dureeMinute) {
        this.titre = titre;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinute = dureeMinute;
    }

    public abstract String description();
}
