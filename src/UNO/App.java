package UNO;

import java.io.PrintStream;
import java.util.Scanner;

import static UNO.GameMethods.*;
import static UNO.GameMethods.resetColorToDefault;

public class App {
    private final Scanner input;
    private final PrintStream output;
    private boolean exit;
    private boolean roundOver;

    public boolean isRoundOver() {
        return roundOver;
    }

    public void setRoundOver(boolean roundOver) {
        this.roundOver = roundOver;
    }

    GameMethods gameMethods = new GameMethods();

    public App(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    //die Gameloop
    public void Run() {

        initialize(); //prepares the game
        printState(); // prints the card on top of the discard Pile

        while (!exit) {
            gameMethods.shuffleCardsWhenCardDeckIsEmpty();
            readUserInput();
            updateState();
            printState();
            if (roundOver) {
                gameMethods.countPoints();
                if (gameMethods.PlayerWantsToExitTheGame()) {
                    setExit(true);
                    break;
                }
                gameMethods.GameWinner();
                gameMethods.shuffleCardsWhenCardDeckIsEmpty();
                gameMethods.prepareNextRound();
                printState();
                setRoundOver(false);
            }
        }
    }


    private void initialize() {
        gameMethods.prepareGame();
    }

    private void readUserInput() {
        gameMethods.playerPlaysCard();
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    private void updateState() {
        if (getCurrentPlayer().getPlayedCard() != null) { // if the current player made a "move"
            gameMethods.chosenCardValidityCheck(); // her "move" will be checked
            acceptPlayersInput(); // if her "move" is valid, it will be taken out of her hand and placed on to the discard pile.
            gameMethods.sayUno(); // checks if the player has only one card left and has to say "Uno"
            if (gameMethods.winnerOftheRound()) {
                setRoundOver(true);
            }
        } else {
            setBlocked(false); //in case the currentPlayer could not make a move, block is set to default so next player can play.
        }

        resetColorToDefault(); // this method will reset the chosen color to NULL when the COLORCHANGE/PLUS4 card is no longer on top of the discard deck.
        gameMethods.nextTurn(); // decide which player is going to play next
    }


    private void printState() {
        gameMethods.printTopCardOfDiscardPile();

    }

}