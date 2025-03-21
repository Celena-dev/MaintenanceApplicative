package com.mycalendar.event.types;

import com.mycalendar.attributs.*;
import com.mycalendar.event.Event;

/**
 * Classe représentant un événement périodique
 */
public class Periodique extends Event {
    private Frequence frequence;

    /**
     * Constructeur de la classe Periodique
     * @param titre le titre de l'événement
     * @param proprietaire le propriétaire de l'événement
     * @param date la date de l'événement
     * @param dureeMinute la durée de l'événement
     * @param frequence la fréquence de l'événement
     */
    public Periodique(Titre titre, Proprietaire proprietaire, Date date, DureeMinute dureeMinute, Frequence frequence) {
        super(titre, proprietaire, date, dureeMinute, Type.PERIODIQUE);
        this.frequence = frequence;
    }

    /**
     * Retourne la fréquence de l'événement
     * @return la fréquence de l'événement
     */
    @Override
    public String description() {
        return "Evénement périodique : " + titre.value() + " à " + date.value().toString() + " avec une fréquence de " + frequence.value() + " jours";
    }

    /**
     * Methode qui permet de vérifier si deux événements se chevauchent
     * @param debut le debut de l'événement
     * @param fin la fin de l'événement
     */
    @Override
    public boolean estDansPeriode(Date debut, Date fin) {
        if (date.value().isAfter(fin.value())) return false;

        if (date.value().isBefore(debut.value())) {
            long joursDepuisDebut = java.time.Duration.between(date.value(), debut.value()).toDays();
            return joursDepuisDebut % frequence.value() == 0;
        }

        return true;
    }

    /**
     * Methode qui permet de vérifier si deux événements se chevauchent
     * @param autre l'autre événement
     * @return false
     */
    @Override
    public boolean conflitAvec(Event autre) {
        return false;
    }




}
