package lecodiai.model;

public class Robot extends Entity {
	private int step;
	
	public Robot(Position pos, int width, int height) {
		super(pos,width,height);
		step = 0;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
	
	
}
