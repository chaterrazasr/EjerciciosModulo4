package ChT.DroneDeliveryService.DroneRefac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Drone> drones = new ArrayList<>();
        List<String[]> locations = new ArrayList<>();
        PackageAssignment packageAssignment = new AssignPackages();
        DeliveryScheduler deliveryScheduler = new PrintDeliverySchedule();

        // Solicitar información sobre los drones
        System.out.println("Por favor ingresa la información de los drones en el formato:");
        System.out.println("[Nombre del Drone #1], [Peso máximo #1], [Nombre del Drone #2], [Peso máximo #2], etc.");
        String droneInput = scanner.nextLine();
        String[] droneInputs = droneInput.split(", ");
        for (int i = 0; i < droneInputs.length; i += 2) {
            drones.add(new SimpleDrone(droneInputs[i], Integer.parseInt(droneInputs[i + 1])));
        }

        // Solicitar información sobre las ubicaciones y los paquetes
        System.out.println("Por favor ingresa la información de las ubicaciones y los paquetes en el formato:");
        System.out.println("[Nombre de la Ubicación #1], [Peso del paquete de la Ubicación #1]");
        System.out.println("[Nombre de la Ubicación #2], [Peso del paquete de la Ubicación #2]");
        System.out.println("Escribe una línea vacía para finalizar.");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;
            locations.add(line.split(", "));
        }

        // Asignar paquetes y mostrar el horario de entrega
        packageAssignment.assignPackages(drones, locations);
        deliveryScheduler.printDeliverySchedule(drones, locations);
    }
}