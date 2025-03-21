package com.mycalendar;


import com.mycalendar.attributs.*;
import com.mycalendar.attributs.Date;
import com.mycalendar.event.types.*;
import com.mycalendar.menu.*;
import com.mycalendar.event.*;
import com.mycalendar.utilisateur.Utilisateur;
import com.mycalendar.utilisateur.Utilisateurs;


import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.*;


public class Main {
    private static CalendarManager calendar = new CalendarManager();

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


