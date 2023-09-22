import java.util.Objects;
import java.util.Scanner;

public class NologySnap extends CardGame {

    protected NologySnap(String name) {
        super(name);
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("******** Welcome to Snap ********\n");
        while (true) {

            System.out.println("Please enter a command to continue: \n");
            commands();
            String command = scanner.nextLine();

            if (command == null || "".equalsIgnoreCase(command)) {
                System.out.println("Please enter a valid command");
            } else {
                command = command.toLowerCase().trim();
            }
            switch (Objects.requireNonNull(command)) {
                case "exit":
                    System.out.println("smell you later.");
                    return;
                case "rules":
                    instructions();
                    break;
                case "play":
                    play();
                    break;
                default:
                    System.out.println("Please enter a valid command");
                    break;
            }

        }

    }

    private void play(){
        System.out.println("** Ok let's play a game of Nology Snap **");
        Scanner humanScanner = new Scanner(System.in);
        while (true) {

        }
    }

    private void instructions() {
        System.out.println("** The Pack **");
        System.out.println("The standard 52-card pack is used.");
        System.out.println("** The Object **");
        System.out.println("The goal is to win.. obviously");
        System.out.println("** The Play **");
        System.out.println("The first player to \u001B[31mSMASH\u001B[0m that space bar when two card symbols match, wins.");
    }

    private void commands() {
        System.out.println("\u001B[34m play \t\tPlay a game of Nology Snap\u001B[0m");
        System.out.println("\u001B[32m rules \t\tRead me the rules of Nology Snap\u001B[0m");
        System.out.println("\u001B[31m exit \t\tGet me out of here please I am scared\u001B[0m");
    }
}
