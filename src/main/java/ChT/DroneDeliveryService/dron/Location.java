package ChT.DroneDeliveryService.dron;

public class Location {
    String name;
    int maxStorage;
    int currentStorage;
    String status; //Complete, Missing

    public Location(String name, int maxStorage) {
        this.name = name;
        this.maxStorage = maxStorage;
        this.currentStorage = maxStorage;
        this.status = "Missing";
    }
}
