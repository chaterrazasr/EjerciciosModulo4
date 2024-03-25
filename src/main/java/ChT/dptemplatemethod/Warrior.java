package ChT.dptemplatemethod;

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

    public abstract void calculateDamage();
}
