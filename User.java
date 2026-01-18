import java.util.Scanner;

public class User{
    //User Attributes
    String username;
    boolean hasDegree;
    String degreeType;
    int yearsWorked;
    String[] userSkills = new String[3];
    boolean employed;
    
    //Objects
    private Scanner scn = new Scanner(System.in);
    UI ui = new UI();
    
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
            System.out.println("In which field did you obtain this degree/certification :");
            degreeType = scn.nextLine();
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

    
}