package com.mycalendar.event.types;

import com.mycalendar.attributs.*;
import com.mycalendar.event.Event;

/**
 * Classe représentant une réunion
 */
public class Reunion extends Event {
    private Lieu lieu;
    private Participants participants;

    /**
     * Constructeur de la classe Reunion
     * @param titre le titre de l'événement
     * @param proprietaire le propriétaire de l'événement
     * @param date la date de l'événement
     * @param dureeMinute la durée de l'événement
     * @param lieu le lieu de la réunion
     * @param participants les participants de la réunion
     */
    public Reunion(Titre titre, Proprietaire proprietaire, Date date, DureeMinute dureeMinute, Lieu lieu, Participants participants) {
        super(titre, proprietaire, date, dureeMinute, Type.REUNION);
        this.lieu = lieu;
        this.participants = participants;
    }

    /**
     * Retourne la description de l'événement
     * @return la description de l'événement
     */
    @Override
    public String description() {
        return  "Réunion : " + titre + " à " + lieu + " avec " + participants;
    }

    /**
     * Methode qui permet de vérifier si deux événements se chevauchent
     * @param debut le debut de l'événement
     * @param fin la fin de l'événement
     */
    @Override
    public boolean estDansPeriode(Date debut, Date fin) {
        return !date.value().isBefore(debut.value()) && !date.value().isAfter(fin.value());
    }

    /**
     * Methode qui permet de vérifier si deux événements se chevauchent
     * @param autre l'autre événement
     * @return vrai si les deux événements se chevauchent
     */
    @Override
    public boolean conflitAvec(Event autre) {
        return date.value().isBefore(autre.getDate().value()) && date.value().isAfter(autre.getDate().value());
    }





}
