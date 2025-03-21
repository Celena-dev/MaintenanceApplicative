package com.mycalendar.event.types;

import com.mycalendar.event.Event;
import com.mycalendar.attributs.*;

/**
 * Classe représentant un RDV personnel
 */
public class RDVPersonnel extends Event {

    /**
     * Constructeur de la classe RDVPersonnel
     * @param titre le titre de l'événement
     * @param proprietaire le propriétaire de l'événement
     * @param date la date de l'événement
     * @param dureeMinute la durée de l'événement
     */
    public RDVPersonnel(Titre titre, Proprietaire proprietaire, Date date, DureeMinute dureeMinute) {
        super(titre, proprietaire, date, dureeMinute, Type.RDV_PERSONNEL);
    }

    /**
     * Retourne la description de l'événement
     * @return la description de l'événement
     */
    @Override
    public String description() {
        return  "RDV : " + titre.value() + " à " + date.value().toString();
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
