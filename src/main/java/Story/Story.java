package Story;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Story {

    private ArrayList<String> story;
    private Scanner scan;

    public Story(String filePath){
        try {
            scan = new Scanner(new File(filePath));
            story = new ArrayList<>();
        } catch (FileNotFoundException e){
            System.out.println("File not found " + e.getMessage());
        }
    }

    public void convertStoryFile(){
        while (scan.hasNext()){
            story.add(scan.nextLine());
        }
    }

    public void readStory(){
        Timer timer = new Timer();
        Iterator<String> iterator = story.iterator();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (iterator.hasNext()){
                    String line = iterator.next();
                    System.out.println(line);
                } else {
                    timer.cancel();
                }
            }
        }, 1000, 1000);

    }




}
