import java.util.*;

public class NologySnap extends CardGame {

    private boolean isPlaying = false;
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
                    isPlaying = true;
                    play();
                    break;
                default:
                    System.out.println("Please enter a valid command");
                    break;
            }

        }

    }

    private void play() {

        System.out.println("** Ok let's play a game of Nology Snap **");

        Scanner scanner = new Scanner(System.in);

        NologySnap nologySnap = new NologySnap("Snap");

        List<Card> deck = nologySnap.getDeckOfCards();
        List<Card> table = new ArrayList<>();

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            Card currentCard;
            int cardCount = 0;

            @Override
            public void run() {
                if (cardCount < deck.size()) {
                    currentCard = nologySnap.dealCard();
                    table.add(currentCard);
                    System.out.println(currentCard);
                    cardCount++;

                } else {
                    System.out.println("It seems no one has won..");
                    timer.cancel();
                }
            }
        }, 1000, 1000);

        while (isPlaying) {
            String playerInteraction = scanner.nextLine();
            if (!playerInteraction.isEmpty()){
                if (table.get(table.size()-2).getCardValue() == table.get(table.size()-1).getCardValue()){
                    System.out.println("game over you win");
                    timer.cancel();
                    break;
                }
            }
        }
    }

    private void instructions() {
        System.out.println("** The Pack **");
        System.out.println("The standard 52-card pack is used.");
        System.out.println("** The Object **");
        System.out.println("The goal is to win.. obviously");
        System.out.println("** The Play **");
        System.out.println("Cards will be dealt one at a time, into the centre of the table.");
        System.out.println("The first player to \u001B[31mSMASH\u001B[0m that space bar when two card symbols match, wins.");
    }

    private void commands() {
        System.out.println("\u001B[34m play \t\tPlay a game of Nology Snap\u001B[0m");
        System.out.println("\u001B[32m rules \t\tRead me the rules of Nology Snap\u001B[0m");
        System.out.println("\u001B[31m exit \t\tGet me out of here please I am scared\u001B[0m");
    }
}
