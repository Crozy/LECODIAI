package lecodiai.model;

public class Robot extends Entity {
	private int step;
	private Direction direction;
	
	public Robot(Position pos, int width, int height, Direction direction) {
		super(pos,width,height);
		this.step = 0;
		this.direction = direction;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;		
	}
	
}
