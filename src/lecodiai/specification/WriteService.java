package lecodiai.specification;

import java.util.ArrayList;

import lecodiai.model.Entity;
import lecodiai.model.Position;

public interface WriteService {
	
	public void setEntities(ArrayList<Entity> entities);
	public void addEntity(Entity entity);
	public void setRobotPosition(Position newPosition);
	public void setEntitySize(int size);

}
