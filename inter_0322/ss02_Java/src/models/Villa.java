package models;

import java.io.Serializable;

public class Villa extends Facility {
    private String standardVilla;
    private double areaPool;
    private int floor;

    public Villa(String id, String name, double area, int price, int people, String rentType, String standard, Double areaPool, int floor) {
        super(id, name, area, price, people, rentType, standard, areaPool, floor);
    }

    public Villa(String idFacility, String nameService, double areaUse, int rentalPrice, int peopleMax, String styleRental) {
        super(idFacility, nameService, areaUse, rentalPrice, peopleMax, styleRental);
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

    public void setFloor(int floor) {}

    @Override
    public String toString() {
        return "Villa{" +
                "standardVilla='" + standardVilla + '\'' +
                ", areaPool=" + areaPool +
                ", floor=" + floor +
                '}';
    }
}