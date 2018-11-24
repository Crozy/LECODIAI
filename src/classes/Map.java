package classes;

import java.util.ArrayList;

/****
 *
 * Robot class
 *
 */


public class Map {
	private int width = 919;
	private int height = 750;
	private ArrayList <Obstacle> obstacles;

	public Map(int width, int height, ArrayList<Obstacle> os) {
		this.width = width;
		this.height = height;
		this.obstacles = os;
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

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	public void setObstacles(ArrayList<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}

}
