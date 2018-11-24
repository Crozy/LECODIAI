package classes;
/**
 * Sensor Class
 *
 * Represents the robot's sensors
 */
public abstract class Sensor {

    private Position position;

    public Sensor(Position position){
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String toString(){
        return "Capteur position en x : " + this.getPosition().x + " position en y : " + this.getPosition().y ;
    }


}