package lecodiai;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import lecodiai.data.Data;
import lecodiai.engine.Engine;
import lecodiai.specification.DataService;
import lecodiai.specification.EngineService;
import lecodiai.specification.ViewerService;
import lecodiai.view.Viewer;

public class Main extends Application {
	private static EngineService 	engineService;
	private static DataService		dataService;
	private static ViewerService	viewerService;
	
	public static void main(String[] args) {
		engineService 	= new Engine();
		dataService 	= new Data();
		viewerService	= new Viewer();
		((Engine)engineService).bindDataService(dataService);
		((Viewer)viewerService).bindReadService(dataService);
		
		dataService.init();
		engineService.init();
		
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		viewerService.init(stage);
		viewerService.getStage().getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode()== KeyCode.R) {
					dataService.init();
					engineService.removeEntities();
					engineService.init();
					viewerService.restart();
				}
			}
		});
		
	}
}
