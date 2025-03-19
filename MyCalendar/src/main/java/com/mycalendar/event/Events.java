package com.mycalendar.event;

import com.mycalendar.event.types.Type;
import com.mycalendar.attributs.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui represente une liste d'evenements
 */
public class Events {
    public List<Event> events;

    /**
     * Constructeur de la classe Events
     */
    public Events() {
        this.events = new ArrayList<>();
    }

    /**
     * Methode qui ajoute un evenement a la liste des evenements
     * @param event l'evenement a ajouter
     */
    public void addEvent(Event event) {
        events.add(event);
    }

    /**
     * Methode qui retourne la liste des evenements
     * @return la liste des evenements
     */
    public List<Event> getEvents() {
        return events;
    }

}
