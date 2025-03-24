package com.mycalendar;
import com.mycalendar.menu.*;
import com.mycalendar.utilisateur.Utilisateur;

import java.util.*;


public class Main {
    private static final CalendarManager calendar = new CalendarManager();

    public static CalendarManager getCalendar(){
        return calendar;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String utilisateur = null;

        Logo.generateLogo();

        Utilisateur.connection(utilisateur, scanner);


    }

}


