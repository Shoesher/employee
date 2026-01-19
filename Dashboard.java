import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Dashboard {
    private UI ui = new UI();
    private User user = new User();
    private Scanner scn = new Scanner(System.in);
    private Jobs job = new Jobs();

    public Dashboard(){
        
    }

    public void appManager(){
        ui.divider();
        ui.dashboard();
        System.out.println("Enter 1. to open your jobs menu");
        System.out.println("Enter 2. to check your notifications");
        System.out.println("Enter 3. to quit current job");
        System.out.println("Enter 4. to exit the program");
        System.out.println("Choose action :");
        int action = Integer.parseInt(scn.nextLine());

        switch(action){
            case 1:
                job.loadJobs();
                break;
            case 2:
                readNotifs();
                appManager();
                break;
            case 3:
                user.changeStatus(false);
                appManager();
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

    public void readNotifs(){
        Path filePath = Paths.get("notifications.txt"); // 

        try {
            String content = Files.readString(filePath);
            System.out.println("File Content:\n" + content);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}