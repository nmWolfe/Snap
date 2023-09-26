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
                "                              \\__|");
        while (true) {

            System.out.println("Please enter a command to continue: ");
            commands();
            String command = scanner.nextLine();

            switch (Objects.requireNonNull(command)) {
                case "exit":
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

        getDeckOfCards();

        List<Card> table = new ArrayList<>();

        Timer timer = new Timer();


    }
    private void commands() {
        System.out.println("\u001B[34m play \t\tPlay a game of Snap\u001B[0m");
        System.out.println("\u001B[32m rules \t\tRead me the rules of Snap\u001B[0m");
        System.out.println("\u001B[31m exit \t\tGet me out of here please I am scared\u001B[0m");
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

    private void replay(boolean multiplayer){
        while (true) {
            System.out.println("Replay? Y / N");
            String command = scanner.nextLine();
            switch (command.toLowerCase().trim()){
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
