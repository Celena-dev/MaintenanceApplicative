package com.mycalendar.menu;

import com.mycalendar.menu.*;
import com.mycalendar.Main;
import com.mycalendar.attributs.Date;
import com.mycalendar.event.Event;


import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GestionnaireEven {
    /**
     * Gestionnaire d'événements
     *
     * @param utilisateur l'utilisateur
     * @param scanner     le scanner
     */
    public static void gestionnaireEven(String utilisateur, Scanner scanner) {
        System.out.println("\n=== Menu de visualisation d'Événements ===");
        System.out.println("1 - Afficher TOUS les événements");
        System.out.println("2 - Afficher les événements d'un MOIS précis");
        System.out.println("3 - Afficher les événements d'une SEMAINE précise");
        System.out.println("4 - Afficher les événements d'un JOUR précis");
        System.out.println("5 - Afficher les événements d'une PERIODE précise");
        System.out.println("6 - Retour");
        System.out.print("Votre choix : ");


        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
                afficher(utilisateur, scanner);
                break;
            case 2:
                afficherMois(utilisateur, scanner);
                break;
            case 3:
                afficherSemaine(utilisateur, scanner);
                break;
            case 4:
                afficherJour(utilisateur, scanner);
                break;
            case 5:
                afficherPeriode(utilisateur, scanner);
                break;
            case 6:
                Menu.menu(utilisateur, scanner);
                break;
            default:
                System.out.println("Choix invalide");
                gestionnaireEven(utilisateur, scanner);
                break;
        }
    }

    /**
     * Affiche tous les événements
     */
    public static void afficher(String utilisateur, Scanner scanner) {
        Main.getCalendar().afficherEvenements();
        gestionnaireEven(utilisateur, scanner);
    }

    /**
     * Affiche les événements du moins donné
     *
     * @param scanner le mois
     */
    public static void afficherMois(String utilisateurs, Scanner scanner) {
        int anneeMois = Valide.verifInt(scanner, "Entrez l'année (AAAA) : ", 2025, 2040);
        int mois = Valide.verifInt(scanner, "Entrez le mois (1-12) : ", 1, 12);

        Date debutMois = new Date(LocalDateTime.of(anneeMois, mois, 1, 0, 0));
        Date finMois = new Date(LocalDateTime.of(debutMois.value().getYear(), debutMois.value().getMonthValue(), debutMois.value().toLocalDate().lengthOfMonth(), 1, 1));


        afficherListe(Main.getCalendar().eventsDansPeriode(debutMois.value(), finMois.value()));

        gestionnaireEven(utilisateurs, scanner);

    }

    /**
     * Affiche les événements de la semaine donnée
     *
     * @param utilisateur l'utilisateur
     * @param scanner     le scanner
     */
    public static void afficherSemaine(String utilisateur, Scanner scanner) {
        int anneeSemaine = Valide.verifInt(scanner, "Entrez l'année (AAAA) : ", 2025, 2040);
        int semaine = Valide.verifInt(scanner, "Entrez le numéro de semaine (1-52) : ", 1, 52);

        LocalDateTime debutSemaine = LocalDateTime.now()
                .withYear(anneeSemaine)
                .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                .withHour(0).withMinute(0);
        LocalDateTime finSemaine = debutSemaine.plusDays(7).minusSeconds(1);

        afficherListe(Main.getCalendar().eventsDansPeriode(debutSemaine, finSemaine));
        gestionnaireEven(utilisateur, scanner);
    }

    /**
     * Affiche les événements du jour donné
     *
     * @param utilisateur l'utilisateur
     * @param scanner     le scanner
     */
    public static void afficherJour(String utilisateur, Scanner scanner) {
        int anneeJour = Valide.verifInt(scanner, "Entrez l'année (AAAA) : ", 2025, 2040);
        int moisJour = Valide.verifInt(scanner, "Entrez le mois (1-12) : ", 1, 12);
        int jour = Valide.verifInt(scanner, "Entrez le jour (1-31) : ", 1, 31);

        LocalDateTime debutJour = LocalDateTime.of(anneeJour, moisJour, jour, 0, 0);
        LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);

        afficherListe(Main.getCalendar().eventsDansPeriode(debutJour, finJour));
        gestionnaireEven(utilisateur, scanner);

    }

    /**
     * Affiche les événements de la période donnée
     *
     * @param utilisateur l'utilisateur
     * @param scanner     le scanner
     */
    public static void afficherPeriode(String utilisateur, Scanner scanner) {
        int anneeDebut = Valide.verifInt(scanner, "Entrez l'année (AAAA) : ", 2025, 2040);
        int moisDebut= Valide.verifInt(scanner, "Entrez le mois (1-12) : ", 1, 12);
        int jourDebut = Valide.verifInt(scanner, "Entrez le jours (1-31) : ", 1, 31);

        int anneeFin = Valide.verifInt(scanner, "Entrez l'année de fin (AAAA) : ", 2025, 2040);
        int moisFin = Valide.verifInt(scanner, "Entrez le mois de fin (1-12) : ", 1, 12);
        int jourFin = Valide.verifInt(scanner, "Entrez le jours de fin (1-31) : ", 1, 31);

        LocalDateTime debut = LocalDateTime.of(anneeDebut, moisDebut, jourDebut, 0, 0);
        LocalDateTime fin = LocalDateTime.of(anneeFin, moisFin, jourFin, 23, 59);

        if (debut.isAfter(fin)) {
            System.out.println("La date de début doit être avant la date de fin.");
            afficherPeriode(utilisateur, scanner);
        }

        afficherListe(Main.getCalendar().eventsDansPeriode(debut, fin));
        gestionnaireEven(utilisateur, scanner);
    }

    /**
     * Affiche les événement
     *
     * @param evenements la liste des événements
     */
    public static void afficherListe(List<Event> evenements) {
        if (evenements.isEmpty()) {
            System.out.println("Aucun événement trouvé pour cette période.");
        } else {
            System.out.println("Événements trouvés : ");
            for (Event e : evenements) {
                System.out.println("- " + e.description());
            }
        }
    }


}
