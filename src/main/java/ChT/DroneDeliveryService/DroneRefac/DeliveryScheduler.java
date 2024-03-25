package ChT.DroneDeliveryService.DroneRefac;

import java.util.List;

public interface DeliveryScheduler {
    void printDeliverySchedule(List<Drone> drones, List<String[]> locations);
}
