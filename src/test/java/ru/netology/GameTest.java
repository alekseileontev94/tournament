package ru.netology;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void secondPlayerIsNotRegistered() {
        Game game = new Game();

        Player player1 = new Player(1, "Simpl", 99);

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Simpl", "Dimpl");
        });
    }

    @Test
    public void firstPlayerIsNotRegistered() {
        Game game = new Game();

        Player player2 = new Player(2, "Dimpl", 99);

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Simpl", "Dimpl");
        });
    }

    @Test
    public void notRegistered() {  // никто не зарегистрирован
        Game game = new Game();

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Simpl", "Dimpl");
        });
    }

    @Test
    public void firstPlayerWins() {
        Game game = new Game();

        Player player1 = new Player(1, "Simpl", 99);
        Player player2 = new Player(2, "Dimpl", 65);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Simpl", "Dimpl");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWins() {
        Game game = new Game();

        Player player1 = new Player(1, "Simpl", 65);
        Player player2 = new Player(2, "Dimpl", 99);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Simpl", "Dimpl");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void drawBetweenThePlayers() {
        Game game = new Game();

        Player player1 = new Player(1, "Simpl", 70);
        Player player2 = new Player(2, "Dimpl", 70);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Simpl", "Dimpl");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerGetId() {
        Player player = new Player(1, "Player 1", 10);

        int expected = 1;
        int actual = player.getId();

        Assertions.assertEquals(expected, actual);
    }
}