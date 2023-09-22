import java.util.Scanner;

public class Snap extends CardGame {

    private Scanner scanner;

    public Snap(String name) {
        super(name);
    }

    public void play() {
        scanner = new Scanner(System.in);
        while (true) {

            System.out.println("******** Welcome to Snap ********");
            System.out.println("Please enter a command to continue: ");
            String command = scanner.nextLine();

            if (command == null || "".equalsIgnoreCase(command)) {
                System.out.println("Please enter a valid command");
            }

        }

    }

    private void instructions() {
        System.out.println("** The Pack **");
        System.out.println("The standard 52-card pack is used.");
        System.out.println("** The Object **");
        System.out.println("The goal is to win all of the cards");
        System.out.println("** The Play **");
        System.out.println("Each player is dealt cards until the deck is empty");
    }


}
