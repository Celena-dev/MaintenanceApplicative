package com.mycalendar;

import com.mycalendar.attributs.*;
import com.mycalendar.event.*;

import java.util.List;
import java.util.Objects;

/**
 * Classe représentant le gestionnaire de calendrier
 */
public class CalendarManager {
    private final Events events;

    /**
     * Constructeur de la classe CalendarManager
     */
    public CalendarManager() {
        this.events = new Events();
    }

    /**
     * Méthode qui ajoute un événement
     * @param event l'événement à ajouter
     */
    public void ajouterEvent(Event event) {
        Objects.requireNonNull(event, "L'événement ne peut pas être nul");
        events.addEvent(event);
    }

    /**
     * Méthode qui retourne la liste des événements dans une période donnée
     * @return la liste des événements
     */
    public List<Event> eventsDansPeriode(Date debut, Date fin) {
        return events.getEvents().stream()
                .filter(e -> e.estDansPeriode(debut, fin))
                .toList();
    }

    /**
     * Méthode qui affiche les événements
     */
    public void afficherEvenements() {
        for (Event e : events.getEvents()) {
            System.out.println(e.description());
        }
    }

    /**
     * Méthode qui retourne vrai si les deux événements se chevauchent
     * @param e1 le premier événement
     * @param e2 le deuxième événement
     * @return vrai si les deux événements se chevauchent
     */
    public boolean conflit(Event e1, Event e2) {
        return e1.conflitAvec(e2);
    }
}