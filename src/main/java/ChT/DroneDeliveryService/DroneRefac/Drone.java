package ChT.DroneDeliveryService.DroneRefac;

public interface Drone {
    boolean canCarry(int weight);
    void load(int weight);
    void reset();
    String getName();
}
