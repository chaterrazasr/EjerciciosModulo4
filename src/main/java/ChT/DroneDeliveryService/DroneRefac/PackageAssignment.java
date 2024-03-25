package ChT.DroneDeliveryService.DroneRefac;

import java.util.List;

public interface PackageAssignment {
    void assignPackages(List<Drone> drones, List<String[]> locations);
}
