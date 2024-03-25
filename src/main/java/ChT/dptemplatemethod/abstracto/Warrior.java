package ChT.dptemplatemethod.abstracto;

public abstract class Warrior {
    String name;
    int power;
    int attack;
    int defense;

    public Warrior(String name, int power, int attack, int defense) {
        this.name = name;
        this.power = power;
        this.attack = attack;
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "name= '" + name + '\'' +
                ", power= " + power +
                ", attack= " + attack +
                ", defense= " + defense +
                '}';
    }


    public final void calculateDamage(){
        double multiplier = CalculateMultiplier();
        double damage = calculateImpact(multiplier);
        this.showDamage(damage);
    }

    protected abstract double calculateImpact(double multiplier);
    private double CalculateMultiplier() {
        return (0.5) * this.power * (Math.random() * 100);
    }
    private void showDamage(double damage) {
        System.out.println("Damage: " + damage);
    }
}
