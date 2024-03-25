package ChT.DroneDeliveryService.DroneRefac;

import java.util.Comparator;
import java.util.List;

public class AssignPackages implements PackageAssignment {
    @Override
    public void assignPackages(List<Drone> drones, List<String[]> locations) {
        for (String[] location : locations) {
            int weight = Integer.parseInt(location[1]);
            drones.sort(Comparator.comparingInt(a -> a.canCarry(weight) ? 0 : 1));
            for (Drone drone : drones) {
                if (drone.canCarry(weight)) {
                    drone.load(weight);
                    break;
                }
            }
        }
    }
}
