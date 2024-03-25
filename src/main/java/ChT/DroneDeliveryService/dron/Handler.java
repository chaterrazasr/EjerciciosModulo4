package ChT.DroneDeliveryService.dron;

import java.util.LinkedList;

public class Handler {

    public void trip(LinkedList<Dron> drones, LinkedList<Location> locations, int lastTrip) {
        Trip tripDrone;
        Package aPackage;
        for (Dron dron : drones) {
            tripDrone = new Trip();
            while (dron.currentCapacity > 0 && arePackagesMissing(locations)) {
                tripDrone.id = lastTrip;
                aPackage = findNearestPackageToDroneCapacity(dron, locations);
                for (Location l : locations) {
                    packageDeliveryProcess(dron, l, aPackage, tripDrone);
                }
            }
            dron.trips.add(tripDrone);
        }
    }

    private static void packageDeliveryProcess(Dron dron, Location l, Package aPackage, Trip tripDrone) {
        if (l.name.equals(aPackage.destination)) {
            l.currentStorage = aPackage.currentWeight - dron.currentCapacity;
            dron.currentCapacity -= aPackage.currentWeight;
            itsCapacityIsLessThanZero(dron, l);
            tripDrone.locations.add(l);
            if (l.currentStorage == 0) {
                l.status = "Complete";
            }
        }
    }

    private static void itsCapacityIsLessThanZero(Dron dron, Location l) {
        if (l.currentStorage <= 0) {
            l.currentStorage = 0;
        }
        if (dron.currentCapacity <= 0) {
            dron.currentCapacity = 0;
        }
    }

    private static Package findNearestPackageToDroneCapacity(Dron drone, LinkedList<Location> locations) {

        if (!findPackageExceedingCapacity(drone, locations).destination.isEmpty()) {
            return findPackageExceedingCapacity(drone, locations);
        }else {
            return findClosestPackageWithinCapacity(drone, locations);
        }
    }

    private static Package findClosestPackageWithinCapacity(Dron drone, LinkedList<Location> locations) {
        int smallestDifference = Integer.MAX_VALUE;
        String name = "";
        int storage = 0;

        for (Location location : locations) {
            int difference = getDifference(drone, location);
            if (difference >= 0 && difference <= smallestDifference) {
                smallestDifference = difference;
                name = location.name;
                storage = location.currentStorage;
            }
        }

        return new Package(name, storage);
    }

    private static Package findPackageExceedingCapacity(Dron drone, LinkedList<Location> locations) {
        int largestNegativeDifference = Integer.MIN_VALUE;
        String excessName = "";
        int excessStorage = 0;

        for (Location location : locations) {
            int difference = getDifference(drone, location);
            if (difference < 0 && difference > largestNegativeDifference) {
                largestNegativeDifference = difference;
                excessName = location.name;
                excessStorage = location.currentStorage;
            }
        }
        return new Package(excessName, excessStorage);
    }


    private static int getDifference(Dron dron, Location l) {
        int difference;
        difference = dron.currentCapacity - l.currentStorage;
        return difference;
    }


    public boolean arePackagesMissing(LinkedList<Location> locations) {
        for (Location l : locations) {
            if (l.status.equals("Missing")) {
                return true;
            }
        }
        return false;
    }

    public void rechargeDrones(LinkedList<Dron> drones, LinkedList<Location> locations) {
        for (Dron dron : drones) {
            dron.currentCapacity = dron.originalCapacity;
            System.out.println("The " + dron.name + " has been recharged...");
        }
    }
}
