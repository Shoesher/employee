import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class User{
    //User Attributes
    String username;
    boolean hasDegree = false;
    String degreeType = "Temp";
    int yearsWorked;
    String[] userSkills = new String[3];
    boolean employed;
    String currentJob;
    int attempts = 3;
    
    //Objects
    private Scanner scn = new Scanner(System.in);
    private UI ui = new UI();
    
    public User(){
        
    }

    public User(boolean isEmployed){
        this.employed = isEmployed;
    }
    
    public void getUserInfo(){
        ui.gap();
        System.out.println("What is your name? :");
        username = scn.nextLine();
        System.out.println("Do you have any degrees/certifications (y/n):");
        String degReply = scn.nextLine();
        if(degReply.toLowerCase().equals("y")){
            hasDegree = true;
            System.out.println("In which field did you obtain this degree/certification :");
            degreeType = scn.nextLine().toLowerCase();
        }
        System.out.println("How many prior years of work expierence do you have? :");
        yearsWorked = Integer.parseInt(scn.nextLine());
        int index = 0;
        while (index < userSkills.length) {
            System.out.println("Please list some of your skills (" + (index + 1) + "/3) :");
            userSkills[index] = scn.nextLine();
            index++;
        }
    }

    public void changeStatus(boolean isEmployed){
        employed = isEmployed;
        if(!isEmployed) {
            currentJob = "None";
            System.out.println("New(1) Notification!");
            addNotifs("Job successfully terminated.");
        }
    }

    public void addNotifs(String message){
        Path filePath = Paths.get("notifications.txt"); 

        try {
            Files.writeString(filePath, message, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void useAttempt(){
        attempts -= 1;
    }
}