import Card.Card;
import Interfaces.PrintRules;

import java.util.*;

public class Snap extends CardGame {

    private final PrintRules printRules = new SnapPrinter();
    private Scanner scanner;

    public Snap(String name) {
        super(name);
    }

    public void run() {
        scanner = new Scanner(System.in);
        System.out.println("\n $$$$$$\\                                $$\\ \n" +
                "$$  __$$\\                               $$ |\n" +
                "$$ /  \\__|$$$$$$$\\   $$$$$$\\   $$$$$$\\  $$ |\n" +
                "\\$$$$$$\\  $$  __$$\\  \\____$$\\ $$  __$$\\ $$ |\n" +
                " \\____$$\\ $$ |  $$ | $$$$$$$ |$$ /  $$ |\\__|\n" +
                "$$\\   $$ |$$ |  $$ |$$  __$$ |$$ |  $$ |    \n" +
                "\\$$$$$$  |$$ |  $$ |\\$$$$$$$ |$$$$$$$  |$$\\ \n" +
                " \\______/ \\__|  \\__| \\_______|$$  ____/ \\__|\n" +
                "                              $$ |          \n" +
                "                              $$ |          \n" +
                "                              \\__|\n");
        while (true) {

            System.out.println("Please enter a command to continue: \n");
            commands();
            String command = scanner.nextLine();

            switch (Objects.requireNonNull(command)) {
                case "back":
                    System.out.println("Returning to title..");
                    return;
                case "rules":
                    instructions();
                    break;
                case "play":
                    multiPlayer();
                default:
                    System.out.println("Please enter a valid command");
                    break;
            }

        }

    }

    public void play(boolean multiplayer){

        System.out.println("** OK let's play some classic Snap **");

        List<Card> table = new ArrayList<>();
        List<Card> deck = new ArrayList<>();

        Snap snap = new Snap("Snap");
        snap.getDeckOfCards();

        List<Card> playerOneCards = new ArrayList<>();
        List<Card> playerTwoCards = new ArrayList<>();

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            Card currentCard;
            int cardCount = 0;

            @Override
            public void run() {

                if (cardCount < 52) {

                    currentCard = snap.dealCard();
                    table.add(currentCard);
                    System.out.println(currentCard);
                    cardCount++;

                } else {
                    scoreChecker(playerOneCards, playerTwoCards, multiplayer);
                }
            }
        }, 1000, 1000);

        while (true) {

            String playerInteraction = scanner.nextLine();
            if (playerInteraction.isEmpty()) {

                if (table.isEmpty()){
                    continue;
                }

                if (table.get(table.size() - 2).getCardValue() == table.get(table.size() - 1).getCardValue()) {

                    if (!multiplayer){

                        playerOneCards.addAll(table);
                        table.clear();
                        System.out.println("SNAP - Table cleared!");
                        continue;

                    } else {

                        if (table.size() % 2 != 0) {
                            System.out.println("Player 2 \u001B[31m WHACKS \u001B[0m down a SNAP!");
                            playerTwoCards.addAll(table);
                            table.clear();

                        } else {
                            System.out.println("Player 1 \u001B[31m WHACKS \u001B[0m down a SNAP!");
                            playerOneCards.addAll(table);
                            table.clear();
                        }
                    }
                }
            } else {

                System.out.println("Nice try,\u001B[31m Bucko!\u001B[0m You \u001B[31mLooooose!\u001B[0m\n");

            }
            timer.cancel();
            replay(multiplayer);
            return;
        }


    }
    private void commands() {
        System.out.println("\u001B[34m play \t\tPlay a game of Snap\u001B[0m");
        System.out.println("\u001B[32m rules \t\tRead me the rules of Snap\u001B[0m");
        System.out.println("\u001B[31m back \t\tGet me out of here please I am scared\u001B[0m");
    }
    private void instructions() {
        printRules.print();
    }
    private void multiPlayer() {
        while (true) {
            System.out.println("\u001B[34m 1P \u001B[0m");
            System.out.println("\u001B[32m 2P \u001B[0m");
            String command = scanner.nextLine();
            switch (command.toLowerCase().trim()) {
                case "1p":
                    play(false);
                    return;
                case "2p":
                    play(true);
                    return;
                default:
                    System.out.println("Please enter a valid response");
            }
        }
    }
    private void scoreChecker(List<Card> p1, List<Card> p2, boolean multiplayer){
        System.out.println("Who has the most cards?");
        if (p1.size() > p2.size()){
            System.out.println("Player One. You are the WINNER!");
        } else if (multiplayer){
            System.out.println("Player Two! You are the WINNER!");
        } else if (p1.size() == p2.size()){
            System.out.println("Well I'll be. It's a DRAW!");
        } else {
            System.out.println("Computer always wins.");
        }
        replay(multiplayer);
    }
    private void replay(boolean multiplayer){
        while (true) {

            System.out.println("Replay? Y / N");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command){
                case "y":
                    play(multiplayer);
                    break;
                case "n":
                    System.out.println("See ya!");
                    return;
                default:
                    System.out.println("Enter Y or N");
            }
        }
    }
}
