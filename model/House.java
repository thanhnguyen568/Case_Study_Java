package model;

public class House extends Facility implements Comparable<House>{
    private String roomStand;
    private int numberOfFloors;

    public House() {
    }

    public House(String codeService, String nameService, double usableArea, double rentalCosts, int maxNumberOfPeople, String rentalType, String roomStand, int numberOfFloors) {
        super(codeService, nameService, usableArea, rentalCosts, maxNumberOfPeople, rentalType);
        this.roomStand = roomStand;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStand() {
        return roomStand;
    }

    public void setRoomStand(String roomStand) {
        this.roomStand = roomStand;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String getInfo(){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,", getCodeService(), getNameService(), getUsableArea(), getRentalCosts(), getMaxNumberOfPeople(), getRentalType(), getRoomStand(), getNumberOfFloors());
    }
    @Override
    public String toString() {
        return "House{" +
                "codeService='" + getCodeService() + '\'' +
                ", rentalCosts=" + getRentalCosts() +
                ", roomStand='" + roomStand + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }


    @Override
    public int compareTo(House o) {
        return this.getCodeService().compareTo(o.getCodeService());
    }
}
