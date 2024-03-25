package ChT.DroneDeliveryService.dron;

public class Package {
    String destination;
    int originalWeight;
    int currentWeight;
    int trips;

    public Package(String destination, int originalWeight) {
        this.destination = destination;
        this.originalWeight = originalWeight;
        this.currentWeight = originalWeight;
        this.trips = 0;
    }
}
