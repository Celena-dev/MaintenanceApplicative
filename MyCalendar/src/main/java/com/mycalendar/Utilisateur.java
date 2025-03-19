package com.mycalendar;

/**
 * Classe utilisateurs qui permet de créer des objets utilisateurs
 *
 */
public class Utilisateur {
    private String nom;
    private String mdp;

    /**
     * Constructeur de la classe utilisateurs
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

        this.nom = nom;
        this.mdp = mdp;
    }

    /**
     * Getter de l'attribut nom
     * @return nom de l'utilisateur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de l'attribut mdp
     * @return mdp de l'utilisateur
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Setter de l'attribut mdp
     * @param mdp nouveau mot de passe
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    /**
     * Methode equals qui permet de comparer deux utilisateurs
     * @param o utilisateur à comparer
     * @return true si les utilisateurs sont égaux, false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur u = (Utilisateur) o;
        return nom.equals(u.nom);
    }

    /**
     * Methode qui vérifie si le mot de passe est identique à celui de l'utilisateur
     * @param m mot de passe à vérifier
     * @return true si les mots de passe sont identiques, false sinon
     */
    public boolean identique(String m) {
        return mdp.equals(m);
    }
}