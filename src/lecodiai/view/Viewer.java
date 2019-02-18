package lecodiai.view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import lecodiai.model.Entity;
import lecodiai.model.Position;
import lecodiai.specification.EngineService;
import lecodiai.specification.ReadService;
import lecodiai.specification.RequireEngineService;
import lecodiai.specification.RequireReadService;
import lecodiai.specification.ViewerService;

public class Viewer implements ViewerService, RequireReadService, RequireEngineService{

	private EngineService engineService;
	private ReadService data;
	private Stage stage;
	private Scene scene ;
	private Group root;
	private Rectangle robot;

	@Override
	public void bindReadService(ReadService service) {
		this.data = service;
	}

	@Override
	public void bindEngineService(EngineService service) {
		this.engineService = service;
	}

	@Override
	public void init(Stage stage) {
		this.stage = stage;
		root = new Group();
		scene = new Scene(root,1024,768);//TODO HARDCODED
		stage.setScene(scene);
		stage.show();
		fillMap(root);
		showRobot(root);
		fillEntities(root);	
	}

	private void showRobot(Group root) {
		Position pos = data.getRobotPosition();
		robot = new Rectangle(pos.getX(), pos.getY(), data.getRobotWidth(), data.getRobotHeight());
		robot.setFill(Color.RED);
		root.getChildren().add(robot);
	}

	private void fillEntities(Group group) {
		for (Entity e : data.getEntities()) {
			Rectangle r = new Rectangle(
					e.getPosition().getX(),
					e.getPosition().getY(),
					e.getWidth(),
					e.getHeight());
			group.getChildren().add(r);
		}
	}

	private void fillMap(Group group) {
		//top
		group.getChildren().add(new Rectangle(data.getMapXMin()-data.getWallSize(), data.getMapYMin(), data.getWallSize(),data.getMapYMax()));
		//left
		group.getChildren().add(new Rectangle(data.getMapXMin(), data.getMapYMin()-data.getWallSize(), data.getMapXMax()-data.getMapXMin(),data.getWallSize()));
		//bottom
		group.getChildren().add(new Rectangle(data.getMapXMin(), data.getMapYMax()+data.getMapYMin(), data.getMapXMax()-data.getMapXMin(), data.getWallSize()));
		//right
		group.getChildren().add(new Rectangle(data.getMapXMax(), data.getMapYMin(), data.getWallSize(),data.getMapYMax()));
	}

	@Override
	public Stage getStage() {
		return this.stage;
	}

	@Override
	public void restart() {
		root.getChildren().removeAll(root.getChildren());
		fillMap(root);
		showRobot(root);
		fillEntities(root);

	}

	@Override
	public void draw() {
		robot.setX(data.getRobotPosition().getX()+1);
	}

}
