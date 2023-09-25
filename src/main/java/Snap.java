import Card.*;

import java.util.Scanner;

public class Snap extends CardGame {

    private Scanner scanner;
    private final PrintRules printRules = new SnapPrinter();

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
        printRules.print();
    }


}
