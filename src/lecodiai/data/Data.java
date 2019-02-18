package lecodiai.data;

import java.util.ArrayList;

import lecodiai.model.Entity;
import lecodiai.model.Map;
import lecodiai.model.Position;
import lecodiai.model.Robot;
import lecodiai.specification.DataService;

public class Data implements DataService {
	
	private Map map ;
	private Robot robot;

	@Override
	public void init() {
		map = new Map(Parameters.MIN_X, Parameters.MAX_X,Parameters.MIN_Y, Parameters.MAX_Y);
		robot = new Robot(new Position(Parameters.ROBOT_POS_X,Parameters.ROBOT_POS_Y), Parameters.ROBOT_WIDTH, Parameters.ROBOT_HEIGHT);
	}

	@Override
	public ArrayList<Entity> getEntities() {
		return map.getEntities();
	}

	@Override
	public void setEntities(ArrayList<Entity> entities) {
		this.map.setEntities(entities);
	}

	@Override
	public int getMapXMax() {
		return this.map.getMaxX();
	}

	@Override
	public int getMapYMin() {
		return this.map.getMinY();
	}

	@Override
	public int getMapYMax() {
		return this.map.getMaxY();
	}

	@Override
	public int getMapXMin() {
		return this.map.getMinX();
	}

	@Override
	public void addEntity(Entity entity) {
		if (this.map.getEntities() != null) {
			this.map.getEntities().add(entity);
		}
	}

	@Override
	public int getWallSize() {
		return Parameters.WALL_SIZE;
	}

	@Override
	public Position getRobotPosition() {
		return this.robot.getPosition();
	}

	@Override
	public void setRobotPosition(Position newPosition) {
		this.robot.setPosition(newPosition);
	}

	@Override
	public int getRobotHeight() {
		return this.robot.getHeight();
	}

	@Override
	public int getRobotWidth() {
		return this.robot.getWidth();
	}

	@Override
	public int getEntitySize() {
		return Parameters.ENTITY_SIZE;
	}

	@Override
	public void setEntitySize(int size) {
		// final value
		
	}
	
	
}
