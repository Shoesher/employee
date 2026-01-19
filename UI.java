public class UI
{
    //Colours
    String GREEN = "\u001B[32m";
    String RED = "\u001B[31m";
    String CYAN = "\u001B[36m";
    String PURPLE = "\u001B[35m";
    String YELLOW = "\u001B[33m";
    String RESET = "\u001B[0m";
    
    public UI(){
        
    }
    
    public void welcome(){
        System.out.println(
            CYAN +
                " __        __     _                                      \n" +
                " \\ \\      / /___ | | ___  ___  _ __ ___   ___     \n" +
                "  \\ \\ /\\ / // _ \\| |/ __|/ _ \\| '_ ` _ \\ / _ \\  \n" +
                "   \\ V  V /|  __/| | (__| (_) | | | | | |  __/     \n" +
                "    \\_/\\_/  \\___||_|\\___|\\___/|_| |_| |_|\\___|   \n" +
                "\n" +
                "        _____                 _                         \n" +
                "       | ____|_ __ ___  _ __ | | ___  _   _  ___  ___   \n" +
                "       |  _| | '_ ` _ \\| '_ \\| |/ _ \\| | | |/ _ \\/ _ \\  \n" +
                "       | |___| | | | | | |_) | | (_) | |_| |  __/  __/  \n" +
                "       |_____|_| |_| |_| .__/|_|\\___/ \\__, |\\___|\\___|  \n" +
                "                       |_|            |___/             " +
            RESET
        );
    }
    
    public void setup(){
        String[] banner = {
            "  ____       _                ____            _ _ _      ",
            " / ___|  ___| |_ _   _ _ __  |  _ \\ _ __ ___  / _(_) | ___ ",
            " \\___ \\ / _ \\ __| | | | '_ \\ | |_) | '__/ _ \\| |_| | |/ _ \\",
            "  ___) |  __/ |_| |_| | |_) ||  __/| | | (_) |  _| | |  __/",
            " |____/ \\___|\\__|\\__,_| .__/ |_|   |_|  \\___/|_| |_|_|\\___|",
            "                      |_|                                   "
        };

        // Print the banner with a bit of spacing
        System.out.println("\n");
        for (String line : banner) {
            // Using cyan color code to match your image
            System.out.println("\u001B[36m" + line + "\u001B[0m");
        }
    }

    public void dashboard(){
        String[] dashboard = {
            "  ____            _     _                              _ ",
            " |  _ \\  __ _ ___| |__ | |__   ___   __ _ _ __ __   __| |",
            " | | | |/ _` / __| '_ \\| '_ \\ / _ \\ / _` | '__/ _` / _` |",
            " | |_| | (_| \\__ \\ | | | |_) | (_) | (_| | | | (_| \\__,_|",
            " |____/ \\__,_|___/_| |_|_.__/ \\___/ \\__,_|_|  \\__,_\\___/ "
        };

        // Adding a newline for breathing room
        System.out.println();

        for (String line : dashboard) {
            // \u001B[36m is the ANSI escape code for Cyan
            System.out.println("\u001B[36m" + line + "\u001B[0m");
        }

        System.out.println();
    }

    public void job(){
        String[] jobs = {
            "       _       _         ",
            "      | | ___ | |__  ___ ",
            "   _  | |/ _ \\| '_ \\/ __|",
            "  | |_| | (_) | |_) \\__ \\",
            "   \\___/ \\___/|_.__/|___/"
        };

        System.out.println();
        for (String line : jobs) {
            System.out.println("\u001B[36m" + line + "\u001B[0m");
        }
        System.out.println();
    }
    
    public void divider(){
        for(int j = 0; j < 2; j++){
            System.out.println("" + YELLOW);
            
            for(int i = 0; i < 160; i++){
                System.out.print("=");
            }
        }
    }

    public void gap(){
        for(int j = 0; j < 2; j++){
            System.out.println("");
        }
    }
}