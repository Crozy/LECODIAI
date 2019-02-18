package lecodiai.engine;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import lecodiai.model.Direction;
import lecodiai.model.Entity;
import lecodiai.model.Position;
import lecodiai.specification.DataService;
import lecodiai.specification.RequireDataService;

public class CustomTimer extends AnimationTimer implements RequireDataService {
	private DataService dataService;

	@Override
	public void handle(long now) {
		Position pos = dataService.getRobotPosition();
		Direction dir = dataService.getRobotDirection();
		ArrayList<Entity> entities = dataService.getEntities();
		switch (dir) {
		case RIGHT:
			for (Entity e : entities) {
				double eMinY = e.getPosition().getY();
				double eMaxY = e.getPosition().getY()+e.getHeight();
				System.out.println("Robot("+pos.getX()+","+pos.getY()+") Entity("+e.getPosition().getX()+","+e.getPosition().getY()+")");
				if ((pos.getX()+dataService.getRobotWidth()<=e.getPosition().getX() && pos.getY()>=eMinY && pos.getY()+dataService.getRobotHeight() <= eMaxY)){
					System.out.println("---\n");
					dataService.setRobotPosition(new Position(pos.getX()+1, pos.getY()));
				} else {
					dataService.setRobotDirection(Direction.DOWN);
					
				}
				//else {
//				}
			}
			break;
		case DOWN:
			dataService.setRobotPosition(new Position(pos.getX(), pos.getY()+1));
		default:
			break;
		}
	}

	@Override
	public void bindDataService(DataService service) {
		dataService = service;
	}
	
}
