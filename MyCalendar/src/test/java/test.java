import com.mycalendar.utilisateur.Utilisateur;
import com.mycalendar.utilisateur.Utilisateurs;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class test {

    @Test
    public void creerCompte() {
        Utilisateurs.ajouterUtilisateur(new Utilisateur("test", "test"));
        assertEquals(true, Utilisateurs.nomDejaExistant("test"));

        assertThrows(IllegalArgumentException.class, () -> {
            Utilisateurs.ajouterUtilisateur(new Utilisateur("test", "test"));
        });
    }

}
