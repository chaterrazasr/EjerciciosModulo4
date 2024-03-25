package ChT.DroneDeliveryService.dron;

import java.util.LinkedList;

public class Display {
    public void PrintTripsOfEachDrone(LinkedList<Dron> drones) {
        System.out.println("Trips of Each Drone");
        for (Dron dron : drones) {
            System.out.println("\n_______________________________________________");
            System.out.println("Drone: " + dron.name + " :");
            for (Trip trip : dron.trips) {
                System.out.println("Trip: " + trip.id + " :");
                for (Location location : trip.locations) {
                    System.out.print("[ " + location.name + " ]");
                }
            }
        }
    }
}
