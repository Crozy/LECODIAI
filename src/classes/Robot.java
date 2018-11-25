package classes;

import java.util.ArrayList;

/****
 *
 * Robot class
 *
 */

public class Robot {

    protected ArrayList<Sensor> sensor;
    private Position position;
    private int width;
    private int height;

    public Robot(Position position) {
        this.position = position;
    }

    public void addSensor(Sensor sensor){
        this.sensor.add(sensor);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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

    public String toString(){
        return "Le robot est en position " + this.position.x + ", " + this.position.y;
    }
}
