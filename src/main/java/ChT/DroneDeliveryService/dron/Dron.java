package ChT.DroneDeliveryService.dron;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dron{
    String name;
    public int originalCapacity;
    int currentCapacity;
    LinkedList<Trip> trips;
    List<Package> packages;

    public Dron(String name, int capacity) {
        this.name = name;
        this.originalCapacity = capacity;
        trips = new LinkedList<>();
        this.currentCapacity = capacity;
        packages = new ArrayList<>();
    }
}
