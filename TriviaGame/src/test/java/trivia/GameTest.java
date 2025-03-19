package trivia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void testAddPlayer() {
        assertTrue(game.add("Alice"));
        assertTrue(game.add("Bob"));
        assertFalse(game.add("Alice")); // Nom en double interdit
    }

    @Test
    void testMaximumPlayers() {
        game.add("Alice");
        game.add("Bob");
        game.add("Charlie");
        game.add("David");
        game.add("Eve");
        game.add("Frank");
        assertFalse(game.add("Grace")); // Trop de joueurs
    }

    @Test
    void testCanStartGame() {
        game.add("Alice");
        assertFalse(game.canStart()); // Moins de 2 joueurs
        game.add("Bob");
        assertTrue(game.canStart()); // Au moins 2 joueurs
    }

    @Test
    void testGameCannotStartWithNewPlayersJoining() {
        game.add("Alice");
        game.add("Bob");
        assertTrue(game.canStart());
        assertFalse(game.add("Charlie")); // Ajout interdit après le début
    }

    @Test
    void testPlayerMovement() {
        game.add("Alice");
        game.add("Bob");
        game.roll(4);
        assertEquals(5, game.currentPlayer().getPlace());
    }

    @Test
    void testCorrectAnswerIncreasesScore() {
        game.add("Alice");
        game.add("Bob");
        game.roll(2);
        game.handleCorrectAnswer();
        assertEquals(1, game.getPlayer("Alice").getPurse());
    }

    @Test
    void testWrongAnswerSendsToPenaltyBox() {
        game.add("Alice");
        game.add("Bob");
        game.roll(2);
        game.wrongAnswer();
        assertTrue(game.getPlayer("Alice").isInPenaltyBox());
    }

    // 🔹 Ajout des tests sur le joueur en pénalité

    @Test
    void testPlayerGetsOutOfPenaltyBoxWhenRollingOdd() {
        game.add("Alice");
        game.add("Bob");
        game.getPlayer("Alice").setInPenaltyBox(true);

        game.roll(3); // Nombre impair → doit rester en prison

        assertTrue(game.getPlayer("Alice").isInPenaltyBox());
    }

    @Test
    void testPlayerStaysInPenaltyBoxWhenRollingEven() {
        game.add("Alice");
        game.add("Bob");
        game.getPlayer("Alice").setInPenaltyBox(true);

        game.roll(4); // Nombre pair → doit sortir de prison

        assertTrue(game.handleCorrectAnswer());
    }

    @Test
    void testNullPlayer() {
        assertNull(game.getPlayer("Alice"));
    }


    @Test
    void testSecondChance() {
        // Ajout des joueurs
        game.add("Alice");
        game.add("Bob");

        // Le joueur Alice fait une première mauvaise réponse et reçoit une seconde chance
        game.roll(2);
        game.wrongAnswer();
        assertTrue(game.getPlayer("Alice").hasSecondChance(), "Alice should have a second chance.");

        // Alice fait une seconde mauvaise réponse, donc elle doit être envoyée en prison
        game.wrongAnswer();

        // Vérifier que Alice est en prison après la deuxième mauvaise réponse
        assertTrue(game.getPlayer("Alice").isInPenaltyBox(), "Alice should be in the penalty box after two incorrect answers.");
    }
}