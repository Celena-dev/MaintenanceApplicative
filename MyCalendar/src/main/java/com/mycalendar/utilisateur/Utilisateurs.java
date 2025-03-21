package com.mycalendar.utilisateur;

import java.util.ArrayList;
import java.util.List;

public class Utilisateurs {
    private static ArrayList<Utilisateur> utilisateurs;

    public Utilisateurs() {
        utilisateurs = new ArrayList<>();
    }

    public static void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
    }

    public static ArrayList<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public static boolean nomDejaExistant(String nom) {
        for (Utilisateur u : utilisateurs) {
            if (u.getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }




}
