package com.mycalendar.menu;

import com.mycalendar.CalendarManager;
import com.mycalendar.Main;
import com.mycalendar.attributs.Date;
import com.mycalendar.event.Event;
import com.mycalendar.utilisateur.Utilisateurs;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GestionnaireEven {
    /**
     * Gestionnaire d'événements
     * @param utilisateur l'utilisateur
     * @param scanner le scanner
     */
    public static void gestionnaireEven(String utilisateur, Scanner scanner) {
        System.out.println("\n=== Menu de visualisation d'Événements ===");
        System.out.println("1 - Afficher TOUS les événements");
        System.out.println("2 - Afficher les événements d'un MOIS précis");
        System.out.println("3 - Afficher les événements d'une SEMAINE précise");
        System.out.println("4 - Afficher les événements d'un JOUR précis");
        System.out.println("5 - Retour");
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
    public static void afficher(String utilisateur,Scanner scanner) {
        Main.getCalendar().afficherEvenements();
        gestionnaireEven(utilisateur, scanner);
    }

    /**
     * Affiche les événements du moins donné
     *
     * @param scanner le mois
     */
    public static void afficherMois(String utilisateurs, Scanner scanner) {
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeMois = Integer.parseInt(scanner.nextLine());

        System.out.print("Entrez le mois (1-12) : ");
        int mois = Integer.parseInt(scanner.nextLine());


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
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeSemaine = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le numéro de semaine (1-52) : ");
        int semaine = Integer.parseInt(scanner.nextLine());


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
     * @param utilisateur l'utilisateur
     * @param scanner le scanner
     */
    public static void afficherJour(String utilisateur, Scanner scanner){
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeJour = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int moisJour = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le jour (1-31) : ");
        int jour = Integer.parseInt(scanner.nextLine());


        LocalDateTime debutJour = LocalDateTime.of(anneeJour, moisJour, jour, 0, 0);
        LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);


        afficherListe(Main.getCalendar().eventsDansPeriode(debutJour, finJour));
        gestionnaireEven(utilisateur, scanner);
    }

    /**
     * Affiche les événement
     * @param evenements la liste des événements
     */
    public static void afficherListe (List<Event> evenements) {
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
