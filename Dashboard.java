import java.util.Scanner;

public class Dashboard {
    UI ui = new UI();
    private Scanner scn = new Scanner(System.in);

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

        }
    }


}