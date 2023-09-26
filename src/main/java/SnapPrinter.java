import Interfaces.PrintRules;

public class SnapPrinter implements PrintRules {
    @Override
    public void print() {
        System.out.println("\u001B[34m** The Pack **\u001B[0m");
        System.out.println("The standard 52-card pack is used.");
        System.out.println("\u001B[32m** The Object **\u001B[0m");
        System.out.println("The goal is to win all of the cards");
        System.out.println("\u001B[31m** The Play **\u001B[0m");
        System.out.println("Each player is dealt cards until the deck is empty");
        System.out.println("Each player then plays one card from their deck");
        System.out.println("The player who calls the snap, gains all the cards currently on the table");
        System.out.println("Whoever has all the cards wins!!!");
    }
}
