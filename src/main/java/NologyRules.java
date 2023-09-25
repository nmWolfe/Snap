public class NologyRules implements PrintRules {
    @Override
    public void print() {
        System.out.println("\u001B[34m** The Pack **\u001B[0m");
        System.out.println("The standard 52-card pack is used.");
        System.out.println("\u001B[32m** The Object **\u001B[0m");
        System.out.println("The goal is to win.. obviously");
        System.out.println("\u001B[31m** The Play **\u001B[0m");
        System.out.println("Cards will be dealt one at a time, into the centre of the table.");
        System.out.println("The first player to \u001B[31mSMASH\u001B[0m enter when two card values match, wins.");
    }
}
