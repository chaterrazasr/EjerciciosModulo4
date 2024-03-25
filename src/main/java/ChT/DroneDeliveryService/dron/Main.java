package ChT.DroneDeliveryService.dron;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Handler handler = new Handler();
        Display display = new Display();

        LinkedList<Dron> drones = getDron();
        LinkedList<Location> locations = getLocalizacions();

        run(handler, locations, drones);
        display.PrintTripsOfEachDrone(drones);
    }

    private static void run(Handler manejador, LinkedList<Location> locations, LinkedList<Dron> drones) {
        System.out.println("_______________________________________________");
        int ultimoViaje = 0;
        while (manejador.arePackagesMissing(locations)) {
            if (manejador.arePackagesMissing(locations)) {
                if(ultimoViaje > 1){
                    System.out.println("There are missing packages.");
                    manejador.rechargeDrones(drones, locations);
                }
                ultimoViaje++;
                manejador.trip(drones, locations, ultimoViaje);
            } else {
                System.out.println("There are no missing packages.");
            }
        }
    }

    private static LinkedList<Location> getLocalizacions() {
        LinkedList<Location> locations = new LinkedList<>();
        Location location = new Location("Location1", 50);
        Location location2 = new Location("Location2", 15);
        Location location3 = new Location("Location3", 10);
        locations.add(location);
        locations.add(location2);
        locations.add(location3);
        return locations;
    }

    private static LinkedList<Dron> getDron() {
        LinkedList<Dron> drones = new LinkedList<>();
        Dron drone = new Dron("Drone1", 40);
        Dron drone2 = new Dron("Drone2", 20);
        Dron drone3 = new Dron("Drone3", 30);
        drones.add(drone);
        drones.add(drone2);
        drones.add(drone3);
        sort(drones);
        return drones;
    }

    private static void sort(LinkedList<Dron> drones) {
        drones.sort((d1, d2) -> d2.originalCapacity - d1.originalCapacity);
        System.out.println("Drones: ");
        for (Dron d : drones) {
            System.out.println("Drone: " + d.name + " Capacity: " + d.originalCapacity);
        }
    }
}
