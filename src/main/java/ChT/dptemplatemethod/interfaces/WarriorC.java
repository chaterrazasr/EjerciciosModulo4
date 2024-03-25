package ChT.dptemplatemethod.interfaces;

public class WarriorC extends Warrior{
    public WarriorC(String name, int power, int attack, int defense) {
        super(name, power, attack, defense);
    }
    @Override
    protected double calculateImpact(double multiplier) {
        return Math.floor((double) this.attack + this.defense) * multiplier + 1;
    }
}
