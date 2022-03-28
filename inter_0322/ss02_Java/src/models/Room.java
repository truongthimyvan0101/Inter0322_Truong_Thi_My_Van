package models;

import java.io.Serializable;

public class Room extends Facility implements Serializable {
    private String furniture;

    public Room() {
    }

    public Room(String furniture) {
        this.furniture = furniture;
    }

    public Room(String idFacility, String nameService, double areaUse, int rentalPrice, int peopleMax, String styleRental, String furniture) {
        super(idFacility, nameService, areaUse, rentalPrice, peopleMax, styleRental);
        this.furniture = furniture;
    }

    public String getFurniture() {
        return furniture;
    }

    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    @Override
    public String toString() {
        return "Room{" +
                "furniture=" + furniture +
                "} " + super.toString();
    }
}
