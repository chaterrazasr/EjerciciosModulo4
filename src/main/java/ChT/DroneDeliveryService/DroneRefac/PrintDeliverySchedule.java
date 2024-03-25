package ChT.DroneDeliveryService.DroneRefac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintDeliverySchedule implements DeliveryScheduler {
    @Override
    public void printDeliverySchedule(List<Drone> drones, List<String[]> locations) {
        Map<Drone, List<String>> deliveryMap = new HashMap<>();
        for (Drone drone : drones) {
            deliveryMap.put(drone, new ArrayList<>());
        }

        for (String[] location : locations) {
            String locationName = location[0];
            int weight = Integer.parseInt(location[1]);

            for (Drone drone : drones) {
                if (drone.canCarry(weight)) {
                    deliveryMap.get(drone).add(locationName);
                    drone.load(weight);
                    break;
                }
            }
        }

        int tripNumber = 1;
        for (Drone drone : drones) {
            System.out.println("[" + drone.getName() + "]");
            List<String> deliveries = deliveryMap.get(drone);
            int i = 0;
            while (i < deliveries.size()) {
                System.out.println("Viaje #" + tripNumber++);
                int totalWeight = 0;
                List<String> currentTripLocations = new ArrayList<>();
                while (i < deliveries.size() && totalWeight + Integer.parseInt(locations.get(i)[1]) <= ((SimpleDrone) drone).getMaxWeight()) {
                    String location = deliveries.get(i);
                    currentTripLocations.add(location);
                    totalWeight += Integer.parseInt(locations.get(i)[1]);
                    i++;
                }
                System.out.println(String.join(", ", currentTripLocations));
            }
        }
    }
}

