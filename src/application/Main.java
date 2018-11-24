package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
	@Override

	public void start (Stage primaryStage) {

		// Make the window a set size...
		primaryStage.setResizable(false);

		// Create menu vbox and set the background image
		VBox menuVBox = new VBox(30);
		menuVBox.setBackground(new Background(new BackgroundImage(new Image("file:images/home.png"), null, null, null,
				new BackgroundSize(45, 45, true, true, true, true))));

		// Create start button
		Button startButton = new Button();
		startButton.setText("Lancer le simulateur");

		// Create help button
		Button helpButton = new Button();
		helpButton.setText("Aide");

		// Create alert popup and bind it to the help button if user needs help- using a lambda handler
		Alert helpAlert = new Alert(AlertType.INFORMATION, "Besoin d'aide ? bla blabla");
		helpButton.setOnAction(e -> helpAlert.showAndWait());

		// Create exit button and set it to close the program when clicked, using a lambda handler
		Button endButton = new Button("Quitter");
		endButton.setOnAction(e -> Platform.exit());

		// Add all nodes to the vbox pane and center it all
		// Must be in order from top to bottom
		menuVBox.getChildren().addAll(startButton, helpButton, endButton);
		menuVBox.setAlignment(Pos.CENTER);

		// New scene, place pane in it
		Scene scene = new Scene(menuVBox, 630, 750);

		// Place scene in stage
		primaryStage.setTitle("-Simulateur de Robot Aspirateur - LECODIAI -");
		primaryStage.setScene(scene);
		primaryStage.show();

		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				StackPane root = new StackPane();

				//New ImageView For Background
				ImageView iv = new ImageView();
				Image image = new Image("File:src/images/home.png"); //Terrain horizontal

				iv.setImage(image);
				iv.setPreserveRatio(true);
				iv.setFitWidth(919);

				root.getChildren().add(iv);

				Scene secondScene = new Scene(root,919,750);

				primaryStage.setScene(secondScene);
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
