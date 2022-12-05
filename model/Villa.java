package model;

public class Villa extends Facility implements Comparable<Villa> {
    private String roomStand;
    private double swimmingPoolArea;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String codeService, String nameService, double usableArea, double rentalCosts, int maxNumberOfPeople, String rentalType, String roomStand, double swimmingPoolArea, int numberOfFloors) {
        super(codeService, nameService, usableArea, rentalCosts, maxNumberOfPeople, rentalType);
        this.roomStand = roomStand;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStand() {
        return roomStand;
    }

    public void setRoomStand(String roomStand) {
        this.roomStand = roomStand;
    }

    public double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String getInfo(){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,", getCodeService(), getNameService(), getUsableArea(), getRentalCosts(), getMaxNumberOfPeople(), getRentalType(), getRoomStand(), getSwimmingPoolArea(), getNumberOfFloors());
    }

    @Override
    public String toString() {
        return "Villa{" +
                "codeService='" + getCodeService() + '\'' +
                ", rentalCosts=" + getRentalCosts() +
                ", roomStand='" + roomStand + '\'' +
                ", swimmingPoolArea=" + swimmingPoolArea +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }

    @Override
    public int compareTo(Villa o) {
//        Double.compare(this.getRentalCosts(), o.getRentalCosts());
        return this.getCodeService().compareTo(o.getCodeService());
    }
}
