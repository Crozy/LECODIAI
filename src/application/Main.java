package application;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class Main extends Application {
	  public Button button1;
	    public Button button2;
	    public ChangeListener<Number> listener;
	    public static Stage homeStage;

	@Override
	public void start(Stage primaryStage) {
		 button1 = new Button();
	        button1.setText("Home 1");
	        button1.setTranslateX(100);
	        button1.setTranslateY(25);
	        button1.setPrefSize(100, 50);
	         
	        button2 = new Button();
	        button2.setText("Home 2");
	        button2.setTranslateX(100);
	        button2.setTranslateY(100);
	        button2.setPrefSize(100,50);
	         
	        button1.setOnAction(new EventHandler<ActionEvent>() {
	       	 
		         @Override
		         public void handle(ActionEvent event) {
		 
		        	 try {
		        		 
		        		 FXMLLoader loader = new FXMLLoader(getClass().getResource("MyScene1.fxml"));  
		        		 Parent root = (Parent) loader.load();  
		        		 MyControlleur controller = (MyControlleur) loader.getController();  
		        		 Scene scene = new Scene(root);  
		        		 Stage stage = new Stage();  
		        		 stage.setScene(scene);  
		        		 stage.setTitle("My Window");  
		        		 stage.show();  

		     			

		     		} catch (Exception e) {
		     			e.printStackTrace();
		     			System.out.println("Error : " + e);
		     		}
		        
		         }
		      });
	        
	        button2.setOnAction(new EventHandler<ActionEvent>() {
		       	 
		         @Override
		         public void handle(ActionEvent event) {
		 
	        	 	try {
		        		 
		        		 FXMLLoader loader = new FXMLLoader(getClass().getResource("MyScene.fxml"));  
		        		 Parent root = (Parent) loader.load();  
		        		 MyControlleur controller = (MyControlleur) loader.getController();  
		        		 Scene scene = new Scene(root);  
		        		 Stage stage = new Stage();  
		        		 stage.setScene(scene);  
		        		 stage.setTitle("My Window");  
		        		 stage.show();  

		     			

		     		} catch (Exception e) {
		     			e.printStackTrace();
		     			System.out.println("Error : " + e);
		     		}
		         }
		      });
	        
	        Group root = new Group();
	        root.getChildren().addAll(button1,button2);
	 
	        Scene scene = new Scene(root, 300, 250);
	 
	        primaryStage.setTitle("Simulateur robot aspirateur");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	         
	        initEvents();
	         
	        primaryStage.widthProperty().addListener(listener);
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void initEvents() {
		 
        listener = new ChangeListener<Number>() {


			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                button1.setPrefSize(button2.getPrefWidth(), button2.getPrefHeight());
				
			}
 
        };
 
    }
}
