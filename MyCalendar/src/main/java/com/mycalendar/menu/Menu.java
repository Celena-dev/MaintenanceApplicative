package com.mycalendar.menu;

import com.mycalendar.Main;
import com.mycalendar.attributs.*;
import com.mycalendar.event.types.ConferenceVideo;
import com.mycalendar.event.types.Periodique;
import com.mycalendar.event.types.RDVPersonnel;
import com.mycalendar.event.types.Reunion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    /**
     * Methode qui affiche le menu principal
     *
     * @param scanner     le scanner
     * @param utilisateur l'utilisateur connecte
     */
    public static void menu(String utilisateur, Scanner scanner) {
        if (utilisateur != null) {

            System.out.println("\nBonjour, " + utilisateur);
            System.out.println("=== Menu Gestionnaire d'Événements ===");
            System.out.println("1 - Voir les événements");
            System.out.println("2 - Ajouter un rendez-vous perso");
            System.out.println("3 - Ajouter une réunion");
            System.out.println("4 - Ajouter un évènement périodique");
            System.out.println("5 - Ajouter une conférence vidéo");
            System.out.println("6 - Se déconnecter");
            System.out.print("Votre choix : ");


            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    GestionnaireEven.gestionnaireEven(utilisateur, scanner);
                    break;
                case "2":
                    ajouterRendezVous(utilisateur, scanner);
                    break;
                case "3":
                    ajouterReunion(utilisateur, scanner);
                    break;
                case "4":
                    ajouterEvenementPeriodique(utilisateur, scanner);
                    break;
                case "5":
                    ajouterEvenementConference(utilisateur, scanner);
                    break;
                case "6":
                    System.out.println("Au revoir !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide");
                    menu(utilisateur, scanner);
                    break;
            }
        }
    }

    /**
     * Methode qui ajoute un rendez-vous
     *
     * @param utilisateur l'utilisateur connecte
     * @param scanner     le scanner
     */
    public static void ajouterRendezVous(String utilisateur, Scanner scanner) {
        // Ajout simplifié d'un RDV personnel
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Durée (en minutes) : ");
        int duree = Integer.parseInt(scanner.nextLine());


        Main.getCalendar().ajouterEvent(
                new RDVPersonnel(
                        new Titre(titre),
                        new Proprietaire(utilisateur),
                        new Date(LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute)),
                        new DureeMinute(duree)
                )
        );


        System.out.println("Événement ajouté.");
        menu(utilisateur, scanner);
    }

    /**
     * Methode qui ajoute une réunion
     *
     * @param utilisateur l'utilisateur connecte
     * @param scanner     le scanner
     */
    public static void ajouterReunion(String utilisateur, Scanner scanner) {
        System.out.print("Titre de l'événement : ");
        String titre2 = scanner.nextLine();

        int annee2 = Valide.verifInt(scanner, "Entrez l'année (AAAA) : ", 2025, 2040);
        int moisRdv2 = Valide.verifInt(scanner, "Entrez le mois (1-12) : ", 1, 12);
        int jourRdv2 = Valide.verifInt(scanner, "Entrez le jour (1-31) : ", 1, 31);
        int heure2 = Valide.verifInt(scanner, "Entrez l'heure de début (0-23) : ", 0, 23);
        int minute2 = Valide.verifInt(scanner, "Entrez la minute de debut (0-59) : ", 0, 59);
        int duree2 = Valide.verifInt(scanner, "Durée (en minutes) : ", 0, 1440);

        System.out.println("Lieu :");
        String lieu = scanner.nextLine();

        List<String> ps = new ArrayList<>();
        ps.add(utilisateur);

        System.out.println("Ajouter un participant ? (oui / non)");
        while (scanner.nextLine().equals("oui")) {
            ps.add(scanner.nextLine());
        }


        Main.getCalendar().ajouterEvent(
                new Reunion(
                        new Titre(titre2),
                        new Proprietaire(utilisateur),
                        new Date(LocalDateTime.of(annee2, moisRdv2, jourRdv2, heure2, minute2)),
                        new DureeMinute(duree2),
                        new Lieu(lieu),
                        new Participants(ps)
                )
        );


        System.out.println("Événement ajouté.");
        menu(utilisateur, scanner);
    }


    /**
     * Methode qui ajoute un événement périodique
     *
     * @param utilisateur l'utilisateur connecte
     * @param scanner     le scanner
     */
    public static void ajouterEvenementPeriodique(String utilisateur, Scanner scanner) {
        System.out.print("Titre de l'événement : ");
        String titre3 = scanner.nextLine();

        int annee3 = Valide.verifInt(scanner, "Entrez l'année (AAAA) : ", 2025, 2040);
        int moisRdv3 = Valide.verifInt(scanner, "Entrez le mois (1-12) : ", 1, 12);
        int jourRdv3 = Valide.verifInt(scanner, "Entrez le jour (1-31) : ", 1, 31);
        int heure3 = Valide.verifInt(scanner, "Entrez l'heure de début (0-23) : ", 0, 23);
        int minute3 = Valide.verifInt(scanner, "Entrez la minute de debut (0-59) : ", 0, 59);
        int frequence = Valide.verifInt(scanner, "Frequence (en jours) : (1-31) : ", 1, 31);


        Main.getCalendar().ajouterEvent(
                new Periodique(
                        new Titre(titre3),
                        new Proprietaire(utilisateur),
                        new Date(LocalDateTime.of(annee3, moisRdv3, jourRdv3, heure3, minute3)),
                        new DureeMinute(0),
                        new Frequence(frequence)
                )
        );


        System.out.println("Événement ajouté.");
        menu(utilisateur, scanner);
    }

    /**
     * Methode qui ajoute une réunion
     *
     * @param utilisateur l'utilisateur connecte
     * @param scanner     le scanner
     */
    public static void ajouterEvenementConference(String utilisateur, Scanner scanner) {
        System.out.print("Titre de l'événement : ");
        String titre2 = scanner.nextLine();

        int annee2 = Valide.verifInt(scanner, "Entrez l'année (AAAA) : ", 2025, 2040);
        int moisRdv2 = Valide.verifInt(scanner, "Entrez le mois (1-12) : ", 1, 12);
        int jourRdv2 = Valide.verifInt(scanner, "Entrez le jour (1-31) : ", 1, 31);
        int heure2 = Valide.verifInt(scanner, "Entrez l'heure de début (0-23) : ", 0, 23);
        int minute2 = Valide.verifInt(scanner, "Entrez la minute de debut (0-59) : ", 0, 59);
        int duree2 = Valide.verifInt(scanner, "Durée (en minutes) : ", 0, 1440);
        System.out.println("Lien vidéo :");

        String lien = scanner.nextLine();

        List<String> ps = new ArrayList<>();
        ps.add(utilisateur);

        System.out.println("Ajouter un participant ? (oui / non)");
        while (scanner.nextLine().equals("oui")) {
            ps.add(scanner.nextLine());
        }


        Main.getCalendar().ajouterEvent(
                new ConferenceVideo(
                        new Titre(titre2),
                        new Proprietaire(utilisateur),
                        new Date(LocalDateTime.of(annee2, moisRdv2, jourRdv2, heure2, minute2)),
                        new DureeMinute(duree2),
                        new LienVideo(lien),
                        new Participants(ps)
                )
        );


        System.out.println("Événement ajouté.");
        menu(utilisateur, scanner);
    }
}

