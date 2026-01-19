public class Main
{
	public static void main(String[] args) {
        UI ui = new UI();
		User user = new User();
        Dashboard dash = new Dashboard(user);

        //Setup 
        ui.welcome();
        ui.divider();
        ui.setup();
		user.getUserInfo();

        //Dashboard
        dash.appManager();

	}
}

