package models;

import java.io.Serializable;

public class Villa extends Facility implements Serializable {
    private String standardVilla;
    private double areaPool;
    private int floor;

    public Villa() {
    }

    public Villa(String standardVilla, double areaPool, int floor) {
        this.standardVilla = standardVilla;
        this.areaPool = areaPool;
        this.floor = floor;
    }

    public Villa(String idFacility, String nameService, double areaUse, int rentalPrice, int peopleMax, String styleRental, String standardVilla, double areaPool, int floor) {
        super(idFacility, nameService, areaUse, rentalPrice, peopleMax, styleRental);
        this.standardVilla = standardVilla;
        this.areaPool = areaPool;
        this.floor = floor;
    }

    public String getStandardVilla() {
        return standardVilla;
    }

    public void setStandardVilla(String standardVilla) {
        this.standardVilla = standardVilla;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "standardVilla='" + standardVilla + '\'' +
                ", areaPool=" + areaPool +
                ", floor=" + floor +
                "} " + super.toString();
    }
}
