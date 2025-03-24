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
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeMois = scanner.nextInt();

        System.out.print("Entrez le mois (1-12) : ");
        int mois = scanner.nextInt();

        if (!anneeValide(anneeMois) || !moisValide(mois)) {
            System.out.println("Date invalide");
            afficherMois(utilisateurs, scanner);
        }
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
        int anneeSemaine = scanner.nextInt();
        System.out.print("Entrez le numéro de semaine (1-52) : ");
        int semaine = scanner.nextInt();

        if (!anneeValide(anneeSemaine) || !semaineValide(semaine)) {
            System.out.println("Date invalide");
            afficherSemaine(utilisateur, scanner);
        }
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
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeJour = scanner.nextInt();
        System.out.print("Entrez le mois (1-12) : ");
        int moisJour = scanner.nextInt();
        System.out.print("Entrez le jour (1-31) : ");
        int jour = scanner.nextInt();

        if (!anneeValide(anneeJour) || !moisValide(moisJour) || !jourValide(jour)) {
            System.out.println("Date invalide");
            afficherJour(utilisateur, scanner);
        }
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
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeDebut = scanner.nextInt();

        System.out.print("Entrez le mois (1-12) : ");
        int moisDebut = scanner.nextInt();

        System.out.print("Entrez le jour de début (1-31) : ");
        int jourDebut = scanner.nextInt();

        if (!anneeValide(anneeDebut) || !moisValide(moisDebut) || !jourValide(jourDebut)) {
            System.out.println("Date invalide");
            afficherPeriode(utilisateur, scanner);
        }

        System.out.print("Entrez l'année de fin (AAAA) : ");
        int anneeFin = scanner.nextInt();

        System.out.print("Entrez le mois de fin (1-12) : ");
        int moisFin = scanner.nextInt();

        System.out.print("Entrez le jour de fin (1-31) : ");
        int jourFin = scanner.nextInt();

        if (!anneeValide(anneeFin) || !moisValide(moisFin) || !jourValide(jourFin)) {
            System.out.println("Date invalide");
            afficherPeriode(utilisateur, scanner);
        }

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

    /**
     * Méthode qui vérifie que l'année est valide
     *
     * @param annee l'année
     * @return vrai si l'année est valide
     */
    public static boolean anneeValide(int annee) {
        return annee >= 2000;
    }

    /**
     * Méthode qui vérifie que le mois est valide
     *
     * @param mois le mois
     * @return vrai si le mois est valide
     */
    public static boolean moisValide(int mois) {
        return mois >= 1 && mois <= 12;
    }

    /**
     * Méthode qui vérifie que le jour est valide
     *
     * @param jour le jour
     * @return vrai si le jour est valide
     */
    public static boolean jourValide(int jour) {
        return jour >= 1 && jour <= 31;
    }

    /**
     * Méthode qui vérifie que le numéro de semaine est valide
     *
     * @param semaine le numéro de semaine
     * @return vrai si le numéro de semaine est valide
     */
    public static boolean semaineValide(int semaine) {
        return semaine >= 1 && semaine <= 52;
    }

}
