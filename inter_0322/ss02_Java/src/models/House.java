package models;

import java.io.Serializable;

public class House extends Facility implements Serializable {
    private String direction;
    private int floor;

    public House() {
    }

    public House(String direction, int floor) {
        this.direction = direction;
        this.floor = floor;
    }

    public House(String idFacility, String nameService, double areaUse, int rentalPrice, int peopleMax, String styleRental, String direction, int floor) {
        super(idFacility, nameService, areaUse, rentalPrice, peopleMax, styleRental);
        this.direction = direction;
        this.floor = floor;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House{" +
                "direction='" + direction + '\'' +
                ", floor=" + floor +
                "} " + super.toString();
    }
}
