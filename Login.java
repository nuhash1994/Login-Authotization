
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

public class Login extends Application {
	public void start(Stage primaryStage) {
		Alert output = new Alert(AlertType.INFORMATION);
		TextInputDialog userinput = new TextInputDialog();
		int x = 1;
		do {

			Dialog<Pair<String, String>> dialog = new Dialog<>();
			dialog.setTitle("Login");
			dialog.setHeaderText(x + " of 3 attempts" + "\nPlease Enter Your Username and Password");
			// set the image on the dialogbox
			dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));
			// add login button
			ButtonType loginbutton = new ButtonType("Login", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().addAll(loginbutton, ButtonType.CANCEL);
			// create labels
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(20, 150, 10, 10));
			TextField username = new TextField();
			username.setPromptText("Username");
			PasswordField password = new PasswordField();
			password.setPromptText("Password");

			grid.add(new Label("Username:"), 0, 0);
			grid.add(username, 1, 0);
			grid.add(new Label("Password:"), 0, 1);
			grid.add(password, 1, 1);
			dialog.getDialogPane().setContent(grid);
			dialog.setResultConverter(dialogButton -> {

				if (dialogButton == loginbutton) {
					return new Pair<>(username.getText(), password.getText());
				}
				return null;
			});
			dialog.showAndWait();
			String name = username.getText();
			String pass = password.getText();

			if (name.equals("nuhash") && pass.equals("n123")) {
				output.setContentText("welcome " + name);
				output.showAndWait();
				userinput.setContentText("Enter Number of People");
				userinput.showAndWait();
				String input = userinput.getResult();
				int people = Integer.parseInt(input);
				if (people > 10) {
					int groupsize = people / 2;
					output.setContentText(
							"The number of people is " + people + ".\nSo the group size would be " + groupsize);
					output.showAndWait();
				} else if (people <= 10 && people >= 3) {
					int groupsize = people / 3;
					output.setContentText(
							"The number of people is " + people + ".\nSo the group size would be " + groupsize);
					output.showAndWait();
				} else {
					output.setContentText("The number of people has to be at least 3.");
					output.showAndWait();
				}

				userinput.setContentText("Enter number of players");
				userinput.showAndWait();
				String input2 = userinput.getResult();
				int player = Integer.parseInt(input2);
				if (player >= 11 && player <= 55) {
					int teamsize = player / 11;
					output.setContentText(
							"the number of player is " + player + ".\nSo the team size would be " + teamsize + ".");
					output.showAndWait();
				} else {
					int teamsize = 1;
					output.setContentText(
							"the number of player is " + player + ".\nSo the team size would be " + teamsize + ".");
					output.showAndWait();
				}
				break;
			} else {
				output.setContentText("Wrong Username and Password\nPlease try again");
				output.showAndWait();
				x++;
			}
			if(x==4){
				output.setContentText("Your Account Has been Blocked!");
				output.showAndWait();}
		} while (x > 1 && x <= 3);
		
	}
}
