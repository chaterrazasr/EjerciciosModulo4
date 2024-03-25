package ChT.DroneDeliveryService.dron;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    public int carriedWeight;
    int id;
    List<Location> locations;
    Package aPackage;

    public Trip(int id, List<Location> locations) {
        this.id = id;
        this.locations = locations;
        this.carriedWeight = 0;
        this.aPackage = null;
    }

    public Trip() {
        this.id = 0;
        this.locations = new ArrayList<>();
        this.carriedWeight = 0;
        this.aPackage = null;
    }



}
