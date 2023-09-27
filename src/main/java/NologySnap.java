import Card.Card;
import Interfaces.Game;
import Interfaces.PrintRules;
import Nology.NologyPrinter;

import java.util.*;

public class NologySnap extends CardGame implements Game {

    private final PrintRules printRules = new NologyPrinter();

    private boolean computerWin;

    private Scanner scanner;

    protected NologySnap(String name) {
        super(name);
    }

    @Override
    public void run() {

        scanner = new Scanner(System.in);
        System.out.println("\n                           $$\\                                      $$$$$$\\                                $$\\ \n" +
                "                           $$ |                                    $$  __$$\\                               $$ |\n" +
                "       $$$$$$$\\   $$$$$$\\  $$ | $$$$$$\\   $$$$$$\\  $$\\   $$\\       $$ /  \\__|$$$$$$$\\   $$$$$$\\   $$$$$$\\  $$ |\n" +
                "       $$  __$$\\ $$  __$$\\ $$ |$$  __$$\\ $$  __$$\\ $$ |  $$ |      \\$$$$$$\\  $$  __$$\\  \\____$$\\ $$  __$$\\ $$ |\n" +
                "       $$ |  $$ |$$ /  $$ |$$ |$$ /  $$ |$$ /  $$ |$$ |  $$ |       \\____$$\\ $$ |  $$ | $$$$$$$ |$$ /  $$ |\\__|\n" +
                "       $$ |  $$ |$$ |  $$ |$$ |$$ |  $$ |$$ |  $$ |$$ |  $$ |      $$\\   $$ |$$ |  $$ |$$  __$$ |$$ |  $$ |    \n" +
                "       $$ |  $$ |\\$$$$$$  |$$ |\\$$$$$$  |\\$$$$$$$ |\\$$$$$$$ |      \\$$$$$$  |$$ |  $$ |\\$$$$$$$ |$$$$$$$  |$$\\ \n" +
                "$$$$$$\\\\__|  \\__| \\______/ \\__| \\______/  \\____$$ | \\____$$ |       \\______/ \\__|  \\__| \\_______|$$  ____/ \\__|\n" +
                "\\______|                                 $$\\   $$ |$$\\   $$ |                                    $$ |          \n" +
                "                                         \\$$$$$$  |\\$$$$$$  |                                    $$ |          \n" +
                "                                          \\______/  \\______/                                     \\__|\n");

        while (true) {

            System.out.println("Please enter a command to continue: \n");
            commands();
            String command = scanner.nextLine();

            command = command.toLowerCase().trim();

            switch (Objects.requireNonNull(command)) {
                case "back":
                    System.out.println("Returning to title..");
                    return;
                case "rules":
                    instructions();
                    break;
                case "play":
                    multiPlayer();
                    break;
                default:
                    System.out.println("Please enter a valid command");
                    break;
            }
        }
    }

    @Override
    public void play(boolean multiPlayer) {

        System.out.println("** OK let's play a game of Nology Snap **");

        getDeckOfCards();
        computerWin = false;

        List<Card> table = new ArrayList<>();

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            Card currentCard;
            int cardCount = 0;

            @Override
            public void run() {

                if (cardCount < 52) {

                    currentCard = dealCard();
                    table.add(currentCard);
                    System.out.println(currentCard);
                    cardCount++;

                } else {

                    System.out.println("FLIP THE DECK!");
                    cardCount = 0;
                    getDeckOfCards();
                    table.clear();

                }

                if (!multiPlayer){

                    if (table.size() > 2 && (table.get(table.size() - 3).getCardValue() == table.get(table.size() - 2).getCardValue())) {

                        System.out.println("\b\b");
                        System.out.println("Computer SNAPS it up!");
                        computerWin = true;
                        timer.cancel();

                    }
                }

            }
        }, 1000, 1000);

        while (true) {

            String playerInteraction = scanner.nextLine();

            if (playerInteraction.isEmpty()) {

                if (computerWin){
                    replay(multiPlayer);
                    return;
                }

                if (table.isEmpty()) {
                    continue;
                }
                if (table.get(table.size() - 2).getCardValue() == table.get(table.size() - 1).getCardValue()) {

                    if (!multiPlayer) {
                        System.out.println("Woweeeee \u001B[31m SNAPPER \u001B[0m you win!");

                    } else {

                        if (table.size() % 2 != 0) {

                            System.out.println("Player 2 \u001B[31m WHACKS \u001B[0m down a SNAP and wins!");

                        } else {

                            System.out.println("Player 1 \u001B[31m WHACKS \u001B[0m down a SNAP and wins!");

                        }
                    }

                } else {
                    System.out.println("Nice try,\u001B[31m Bucko!\u001B[0m You \u001B[31mLooooose!\u001B[0m\n");
                }

                timer.cancel();
                replay(multiPlayer);
                return;
            }
        }
    }

    private void instructions() {
        printRules.print();
    }

    private void commands() {
        System.out.println("\u001B[34m play \t\tPlay a game of Nology Snap\u001B[0m");
        System.out.println("\u001B[32m rules \t\tRead me the rules of _nology Snap\u001B[0m");
        System.out.println("\u001B[31m back \t\tGet me out of here please I am scared\u001B[0m");
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

    private void replay(boolean multiplayer) {
        while (true) {
            System.out.println("Replay? Y / N");
            String command = scanner.nextLine();
            switch (command.toLowerCase().trim()) {
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
