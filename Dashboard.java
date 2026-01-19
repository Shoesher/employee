import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Dashboard {
    private UI ui = new UI();
    private User user;
    private Scanner scn = new Scanner(System.in);
    private Jobs job;

    public Dashboard(User user){
        this.user = user;
        this.job = new Jobs(user);
    }

    public void appManager(){
        boolean running = true;
        while(running) {
            ui.divider();
            ui.dashboard();
            System.out.println("Status: " + (user.employed ? "Employed at " + user.currentJob : "Unemployed"));
            System.out.println("Enter 1. to open your jobs menu");
            System.out.println("Enter 2. to check your notifications");
            System.out.println("Enter 3. to quit current job");
            System.out.println("Enter 4. to exit the program");
            System.out.print("Choose action: ");
            
            String input = scn.nextLine();
            int action = Integer.parseInt(input);

            switch(action){
                case 1:
                    // This now returns here after the job menu is finished
                    job.loadJobs();
                    break;
                case 2:
                    readNotifs();
                    break;
                case 3:
                    user.changeStatus(false);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    running = false;
                    System.exit(0);
                    break;
            }
        }
    }

    public void readNotifs(){
        Path filePath = Paths.get("notifications.txt"); 
        try {
            if (Files.exists(filePath)) {
                String content = Files.readString(filePath);
                System.out.println("\n--- Notifications ---\n" + content);
            } else {
                System.out.println("No notifications found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading notifications: " + e.getMessage());
        }
    }
}