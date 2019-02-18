package lecodiai.model;

import java.util.ArrayList;

public class Map {
	private int minX, maxX, minY, maxY;
	private int width ;
	private int height ;
	private ArrayList<Entity> entities;

	public Map(int minX, int maxX, int minY, int maxY) {
		this.minX 		= minX;
		this.minY 		= minY;
		this.maxX 		= maxX;
		this.maxY 		= maxY;
		this.width 		= maxX-minX;
		this.height 	= maxY-minY;
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

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public int getMinX() {
		return minX;
	}

	public void setMinX(int minX) {
		this.minX = minX;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMinY() {
		return minY;
	}

	public void setMinY(int minY) {
		this.minY = minY;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
	
	
	
	
}
