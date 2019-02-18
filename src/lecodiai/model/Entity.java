package lecodiai.model;

public class Entity {
	
	private Position pos;
	private int width;
	private int height;

	public Entity(Position pos) {
		this.pos = pos;
		this.width = 0;
		this.height = 0;
	}
	
	public Entity(Position pos, int width, int height) {
		this.pos = pos;
		this.width = width;
		this.height = height;
	}
	
	public Position getPosition() {
		return pos;
	}

	public void setPosition(Position pos) {
		this.pos = pos;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
