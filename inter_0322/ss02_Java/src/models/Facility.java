package models;

public class Facility {
    private String id;
    private String name;
    private double areaUse;
    private int rentalPrice;
    private int peopleMax;
    private String styleRental;

    public Facility(String id, String name, double area, int price, int people, String rentType, String standard, Double areaPool, int floor) {
    }

    public Facility(String idFacility, String nameService, double areaUse, int rentalPrice, int peopleMax, String styleRental) {
        this.id = idFacility;
        this.name = nameService;
        this.areaUse = areaUse;
        this.rentalPrice = rentalPrice;
        this.peopleMax = peopleMax;
        this.styleRental = styleRental;
    }

    public String getIdFacility() {
        return id;
    }

    public void setIdFacility(String idFacility) {
        this.id = idFacility;
    }

    public String getNameService() {
        return name;
    }

    public void setNameService(String nameService) {
        this.name = nameService;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public int getPeopleMax() {
        return peopleMax;
    }

    public void setPeopleMax(int peopleMax) {
        this.peopleMax = peopleMax;
    }

    public String getStyleRental() {
        return styleRental;
    }

    public void setStyleRental(String styleRental) {
        this.styleRental = styleRental;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "idFacility='" + id + '\'' +
                ", nameService='" + name + '\'' +
                ", areaUse=" + areaUse +
                ", rentalPrice=" + rentalPrice +
                ", peopleMax=" + peopleMax +
                ", styleRental='" + styleRental + '\'' +
                '}';
    }
}
