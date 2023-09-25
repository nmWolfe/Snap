public class SnapPrinter implements PrintRules{
    @Override
    public void print() {
        System.out.println("** The Pack **");
        System.out.println("The standard 52-card pack is used.");
        System.out.println("** The Object **");
        System.out.println("The goal is to win all of the cards");
        System.out.println("** The Play **");
        System.out.println("Each player is dealt cards until the deck is empty");
        System.out.println("The player who calls the snap, gains all the cards currently on the table");
        System.out.println("Whoever has all the cards wins!!!");
    }
}
