public class Main {
    public static void main(String[] args) {
        CardGame snap = new CardGame("Snap");
        System.out.println(snap.getDeckOfCards());
        snap.shuffleDeck();
        System.out.println("***********************************");
        System.out.println(snap.getDeckOfCards());
        Card singleCard = snap.dealCard();
        System.out.println(singleCard);

    }
}
