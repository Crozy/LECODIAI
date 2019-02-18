package lecodiai.specification;

import javafx.scene.Scene;
import javafx.stage.Stage;

public interface ViewerService {
	
	public void init(Stage stage);
	public Stage getStage();
	public void restart();

}
