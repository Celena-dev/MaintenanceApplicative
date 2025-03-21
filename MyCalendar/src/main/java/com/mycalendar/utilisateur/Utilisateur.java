package com.mycalendar.utilisateur;

import com.mycalendar.menu.Logo;

import java.util.Scanner;

/**
 * Classe utilisateurs qui permet de créer des objets utilisateurs
 */
public class Utilisateur {
    private String nom;
    private String mdp;

    /**
     * Constructeur de la classe utilisateurs
     *
     * @param nom de l'utilisateur
     * @param mdp de l'utilisateur
     */
    public Utilisateur(String nom, String mdp) {
        if (nom == null || nom.isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'utilisateur ne peut pas être vide");
        }
        if (mdp == null || mdp.isEmpty()) {
            throw new IllegalArgumentException("Le mot de passe de l'utilisateur ne peut pas être vide");
        }

        if (Utilisateurs.nomDejaExistant(nom)) {
            throw new IllegalArgumentException("Le nom d'utilisateur est déjà pris");
        }

        this.nom = nom;
        this.mdp = mdp;
        Utilisateurs.ajouterUtilisateur(this);

    }

    /**
     * Getter de l'attribut nom
     *
     * @return nom de l'utilisateur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de l'attribut mdp
     *
     * @return mdp de l'utilisateur
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Setter de l'attribut mdp
     *
     * @param mdp nouveau mot de passe
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    /**
     * Methode qui vérifie si le mot de passe est identique à celui de l'utilisateur
     *
     * @param m mot de passe à vérifier
     * @return true si les mots de passe sont identiques, false sinon
     */
    public boolean identique(String m) {
        return mdp.equals(m);
    }

    /**
     * Methode qui permet de se connecter
     * @param utilisateur utilisateur qui se connecte
     * @param scanner scanner pour lire les entrées
     * @return true si l'utilisateur est connecté, false sinon
     */
    public static void seConnecter(String utilisateur, Scanner scanner) {
        System.out.print("Nom d'utilisateur: ");
        utilisateur = scanner.nextLine();

        if (Utilisateurs.nomDejaExistant(utilisateur) && utilisateur != null && !utilisateur.isEmpty()) {
            System.out.print("Mot de passe: ");
            String motDePasse = scanner.nextLine();


            for (Utilisateur u : Utilisateurs.getUtilisateurs()) {
                if (u.identique(motDePasse)) {
                    System.out.println("Bienvenue " + utilisateur);
                }
            }
        }else{
            System.out.println("Nom d'utilisateur inconnu...");
            connection(utilisateur, scanner);
        }
    }

    /**
     * Méthode pour créer un compte
     * @param utilisateur utilisateur qui veut créer un compte
     * @param scanner scanner pour lire les entrées
     */
    public static void creerCompte(String utilisateur, Scanner scanner) {
        System.out.print("Nom d'utilisateur: ");
        utilisateur = scanner.nextLine();

        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();

        System.out.print("Répéter mot de passe: ");
        if (scanner.nextLine().equals(motDePasse)) {
            Utilisateurs.ajouterUtilisateur(new Utilisateur(utilisateur, motDePasse));
            System.out.println("Bienvenue " + utilisateur);
        } else {
            System.out.println("Les mots de passes ne correspondent pas...");
            connection(utilisateur, scanner);
        }
    }
    /**
     * Methode qui permet de se connecter
     *
     * @param utilisateur utilisateur qui se connecte
     */
    public static void connection(String utilisateur, Scanner scanner) {
        if (utilisateur == null) {
            System.out.println(Logo.generateLogo());
            System.out.println("1 - Se connecter");
            System.out.println("2 - Créer un compte");
            System.out.println("Choix : ");


            switch (scanner.nextLine()) {
                case "1":
                    seConnecter(utilisateur, scanner);
                    break;

                case "2":
                    creerCompte(utilisateur, scanner);
                    break;
            }
        }
    }
}