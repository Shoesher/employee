public class Main
{
	public static void main(String[] args) {
        UI ui = new UI();
		User user = new User();

        //Setup 
        ui.welcome();
        ui.divider();
        ui.setup();
		user.getUserInfo();

        //Dashboard
        ui.divider();
        ui.dashboard();

	}
}

