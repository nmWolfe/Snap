import Story.Story;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Story story = new Story("/Users/nmp/development/java/Snap/src/main/java/Story/star-wars.txt");
        story.convertStoryFile();
        NologySnap nologySnap = new NologySnap("snap");
        Snap snap = new Snap("Snap");

        System.out.println("\n$$\\      $$\\           $$\\                                                   \n" +
                "$$ | $\\  $$ |          $$ |                                                  \n" +
                "$$ |$$$\\ $$ | $$$$$$\\  $$ | $$$$$$$\\  $$$$$$\\  $$$$$$\\$$$$\\   $$$$$$\\        \n" +
                "$$ $$ $$\\$$ |$$  __$$\\ $$ |$$  _____|$$  __$$\\ $$  _$$  _$$\\ $$  __$$\\       \n" +
                "$$$$  _$$$$ |$$$$$$$$ |$$ |$$ /      $$ /  $$ |$$ / $$ / $$ |$$$$$$$$ |      \n" +
                "$$$  / \\$$$ |$$   ____|$$ |$$ |      $$ |  $$ |$$ | $$ | $$ |$$   ____|      \n" +
                "$$  /   \\$$ |\\$$$$$$$\\ $$ |\\$$$$$$$\\ \\$$$$$$  |$$ | $$ | $$ |\\$$$$$$$\\       \n" +
                "\\__/     \\__| \\_______|\\__| \\_______| \\______/ \\__| \\__| \\__| \\_______|");

        System.out.println("  $$\\                       $$\\     $$\\                 \n" +
                "  $$ |                      $$ |    $$ |                \n" +
                "$$$$$$\\    $$$$$$\\        $$$$$$\\   $$$$$$$\\   $$$$$$\\  \n" +
                "\\_$$  _|  $$  __$$\\       \\_$$  _|  $$  __$$\\ $$  __$$\\ \n" +
                "  $$ |    $$ /  $$ |        $$ |    $$ |  $$ |$$$$$$$$ |\n" +
                "  $$ |$$\\ $$ |  $$ |        $$ |$$\\ $$ |  $$ |$$   ____|\n" +
                "  \\$$$$  |\\$$$$$$  |        \\$$$$  |$$ |  $$ |\\$$$$$$$\\ \n" +
                "   \\____/  \\______/          \\____/ \\__|  \\__| \\_______|");

        System.out.println(" $$$$$$\\   $$$$$$\\  $$\\      $$\\ $$$$$$$$\\       $$$$$$$$\\  $$$$$$\\  $$\\   $$\\ $$$$$$$$\\ \n" +
                "$$  __$$\\ $$  __$$\\ $$$\\    $$$ |$$  _____|      \\____$$  |$$  __$$\\ $$$\\  $$ |$$  _____|\n" +
                "$$ /  \\__|$$ /  $$ |$$$$\\  $$$$ |$$ |                $$  / $$ /  $$ |$$$$\\ $$ |$$ |      \n" +
                "$$ |$$$$\\ $$$$$$$$ |$$\\$$\\$$ $$ |$$$$$\\             $$  /  $$ |  $$ |$$ $$\\$$ |$$$$$\\    \n" +
                "$$ |\\_$$ |$$  __$$ |$$ \\$$$  $$ |$$  __|           $$  /   $$ |  $$ |$$ \\$$$$ |$$  __|   \n" +
                "$$ |  $$ |$$ |  $$ |$$ |\\$  /$$ |$$ |             $$  /    $$ |  $$ |$$ |\\$$$ |$$ |      \n" +
                "\\$$$$$$  |$$ |  $$ |$$ | \\_/ $$ |$$$$$$$$\\       $$$$$$$$\\  $$$$$$  |$$ | \\$$ |$$$$$$$$\\ \n" +
                " \\______/ \\__|  \\__|\\__|     \\__|\\________|      \\________| \\______/ \\__|  \\__|\\________|\n");
        while (true) {


            commands();
            String command = scanner.nextLine();
            command = command.toLowerCase().trim();

            switch (Objects.requireNonNull(command)) {
                case "3":
                    System.out.println("smell you later.");
                    return;
                case "1":
                    nologySnap.run();
                    break;
                case "2":
                    snap.run();
                    break;
                case "starwars":
                    story.readStory();
                    break;
                default:
                    System.out.println("Please enter a valid command");
                    break;
            }
        }
    }

    private static void commands(){
        System.out.println("\u001B[34m1\t\tPlay a game of _nology Snap\u001B[0m");
        System.out.println("\u001B[32m2\t\tPlay a game of regular Snap\u001B[0m");
        System.out.println("\u001B[31m3\t\tExit this whole shabang\u001B[0m");
    }
}
