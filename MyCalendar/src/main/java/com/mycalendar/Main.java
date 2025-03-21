package com.mycalendar;


import com.mycalendar.attributs.*;
import com.mycalendar.attributs.Date;
import com.mycalendar.event.types.*;
import com.mycalendar.menu.*;
import com.mycalendar.event.*;


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
        boolean continuer = true;


        String[] utilisateurs = new String[99];
        String[] motsDePasses = new String[99];
        int nbUtilisateurs = 0;


        while (true) {


            if (utilisateur == null) {
                System.out.println(Logo.generateLogo());
                System.out.println("1 - Se connecter");
                System.out.println("2 - Créer un compte");
                System.out.println("Choix : ");


                switch (scanner.nextLine()) {
                    case "1":
                        System.out.print("Nom d'utilisateur: ");
                        utilisateur = scanner.nextLine();


                        if (utilisateur.equals("Roger")) {
                            String motDePasse = scanner.nextLine();
                            if (!motDePasse.equals("Chat")) {
                                utilisateur = null;
                            }
                        } else {
                            if (utilisateur.equals("Pierre")) {
                                String motDePasse = scanner.nextLine();
                                if (!motDePasse.equals("KiRouhl")) {
                                    utilisateur = null;
                                }
                            } else {
                                System.out.print("Mot de passe: ");
                                String motDePasse = scanner.nextLine();


                                for (int i = 0; i < nbUtilisateurs; i = i + 1) {
                                    if (utilisateurs[i].equals(utilisateur) && motsDePasses[i].equals(motDePasse)) {
                                        utilisateur = utilisateurs[i];
                                    }
                                }
                            }
                        }
                        break;


                    case "2":
                        System.out.print("Nom d'utilisateur: ");
                        utilisateur = scanner.nextLine();
                        System.out.print("Mot de passe: ");
                        String motDePasse = scanner.nextLine();
                        System.out.print("Répéter mot de passe: ");
                        if (scanner.nextLine().equals(motDePasse)) {
                            utilisateurs[nbUtilisateurs] = utilisateur;
                            motsDePasses[nbUtilisateurs] = motDePasse;
                            nbUtilisateurs = nbUtilisateurs + 1;
                        } else {
                            System.out.println("Les mots de passes ne correspondent pas...");
                            utilisateur = null;
                        }
                        break;
                }
            }


            while (continuer && utilisateur != null) {
                System.out.println("\nBonjour, " + utilisateur);
                System.out.println("=== Menu Gestionnaire d'Événements ===");
                System.out.println("1 - Voir les événements");
                System.out.println("2 - Ajouter un rendez-vous perso");
                System.out.println("3 - Ajouter une réunion");
                System.out.println("4 - Ajouter un évènement périodique");
                System.out.println("5 - Se déconnecter");
                System.out.print("Votre choix : ");


                String choix = scanner.nextLine();


                switch (choix) {
                    case "1":
                        GestionnaireEven.gestionnaireEven(utilisateur, scanner);
                        break;

                    case "2":
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


                        calendar.ajouterEvent(
                                new RDVPersonnel(
                                        new Titre(titre),
                                        new Proprietaire(utilisateur),
                                        new Date(LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute)),
                                        new DureeMinute(duree)
                                )
                        );


                        System.out.println("Événement ajouté.");
                        break;


                    case "3":
                        // Ajout simplifié d'une réunion
                        System.out.print("Titre de l'événement : ");
                        String titre2 = scanner.nextLine();
                        System.out.print("Année (AAAA) : ");
                        int annee2 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Mois (1-12) : ");
                        int moisRdv2 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Jour (1-31) : ");
                        int jourRdv2 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Heure début (0-23) : ");
                        int heure2 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Minute début (0-59) : ");
                        int minute2 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Durée (en minutes) : ");
                        int duree2 = Integer.parseInt(scanner.nextLine());
                        System.out.println("Lieu :");
                        String lieu = scanner.nextLine();

                        List<String> ps = new ArrayList<>();
                        ps.add(utilisateur);

                        System.out.println("Ajouter un participant ? (oui / non)");
                        while (scanner.nextLine().equals("oui")) {
                            ps.add(scanner.nextLine());
                        }


                        calendar.ajouterEvent(
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
                        break;


                    case "4":
                        // Ajout simplifié d'une réunion
                        System.out.print("Titre de l'événement : ");
                        String titre3 = scanner.nextLine();
                        System.out.print("Année (AAAA) : ");
                        int annee3 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Mois (1-12) : ");
                        int moisRdv3 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Jour (1-31) : ");
                        int jourRdv3 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Heure début (0-23) : ");
                        int heure3 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Minute début (0-59) : ");
                        int minute3 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Frequence (en jours) : ");
                        int frequence = Integer.parseInt(scanner.nextLine());


                        calendar.ajouterEvent(
                                new Periodique(
                                        new Titre(titre3),
                                        new Proprietaire(utilisateur),
                                        new Date(LocalDateTime.of(annee3, moisRdv3, jourRdv3, heure3, minute3)),
                                        new DureeMinute(0),
                                        new Frequence(frequence)
                                )
                        );


                        System.out.println("Événement ajouté.");
                        break;


                    default:
                        System.out.println("Déconnexion ! Voulez-vous continuer ? (O/N)");
                        continuer = scanner.nextLine().trim().equalsIgnoreCase("oui");


                        utilisateur = null;
                }
            }
        }
    }


    private static void afficherListe(List<Event> evenements) {
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


