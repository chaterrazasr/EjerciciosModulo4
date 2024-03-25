package ChT.DroneDeliveryService.DroneRefac;

public class SimpleDrone implements Drone {
    private String name;
    private int maxWeight;
    private int actualWeight;

    public SimpleDrone(String name, int maxWeight) {
        this.name = name;
        this.maxWeight = maxWeight;
        this.actualWeight = 0;
    }

    @Override
    public boolean canCarry(int weight) {
        return actualWeight + weight <= maxWeight;
    }

    @Override
    public void load(int weight) {
        actualWeight += weight;
    }

    @Override
    public void reset() {
        actualWeight = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
}
