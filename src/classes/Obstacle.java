package classes;

/****
 * Obstacle class (furniture, flower pot, etc.)
 *
 */
public class Obstacle {
	Position position;

	public Obstacle(Position position){
		this.position = position;
	}
	
	public Position getPosition() {
		return position;
	}

}
