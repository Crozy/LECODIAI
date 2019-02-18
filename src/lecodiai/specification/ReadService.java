package lecodiai.specification;

import java.util.ArrayList;

import lecodiai.model.Entity;
import lecodiai.model.Position;

public interface ReadService {
	
	public ArrayList<Entity> getEntities();
	public int getMapXMax();
	public int getMapYMin();
	public int getMapYMax();
	public int getMapXMin();
	public int getWallSize();
	public Position getRobotPosition();
	public int getRobotHeight();
	public int getRobotWidth();
	public int getEntitySize();
}
