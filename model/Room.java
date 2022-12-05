package model;

public class Room extends Facility implements Comparable<Room> {
    private String freeService;

    public Room() {
    }

    public Room(String codeService, String nameService, double usableArea, double rentalCosts, int maxNumberOfPeople, String rentalType, String freeService) {
        super(codeService, nameService, usableArea, rentalCosts, maxNumberOfPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String getInfo(){
        return String.format("%s,%s,%s,%s,%s,%s,%s,", getCodeService(), getNameService(), getUsableArea(), getRentalCosts(), getMaxNumberOfPeople(), getRentalType(), getFreeService());
    }

    @Override
    public String toString() {
        return "Room{" +
                "codeService='" + getCodeService() + '\'' +
                ", rentalCosts=" + getRentalCosts() +
                ", freeService='" + freeService + '\'' +
                '}';
    }

    @Override
    public int compareTo(Room o) {
        return this.getCodeService().compareTo(o.getCodeService());
    }
}
