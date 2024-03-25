package ChT.dptemplatemethod.abstracto;

public class WarriorA extends Warrior {
    public WarriorA(String name, int power, int attack, int defense) {
        super(name, power, attack, defense);
    }
    @Override
    protected double calculateImpact(double multiplier) {
        return Math.floor((double) this.attack / this.defense) * multiplier + 1;
    }

}
