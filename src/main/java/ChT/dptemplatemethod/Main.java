package ChT.dptemplatemethod;

public class Main {
    public static void main(String[] args) {
        Warrior warrior1 = new WarriorA("Warrior 1", 100, 20, 10);
        Warrior warrior2 = new WarriorB("Warrior 2", 100, 50, 30);
        Warrior warrior3 = new WarriorC("Warrior 3", 100, 40, 20);

        System.out.println(warrior1);
        warrior1.calculateDamage();
        System.out.println(warrior2);
        warrior2.calculateDamage();
        System.out.println(warrior3);
        warrior3.calculateDamage();

    }
}

class WarriorA extends Warrior {
    public WarriorA(String name, int power, int attack, int defense) {
        super(name, power, attack, defense);
    }

    public void calculateDamage() {
        double multiplier = (0.5) * this.power * (Math.random() * 100);
        double impact = Math.floor((double) this.attack / this.defense) * multiplier + 1;
        System.out.println("Damage: " + impact);
    }
}

class WarriorB extends Warrior {
    public WarriorB(String name, int power, int attack, int defense) {
        super(name, power, attack, defense);
    }

    public void calculateDamage() {
        double multiplier = (0.5) * this.power * (Math.random() * 100);
        double impact = Math.floor((double) this.attack / this.defense) * multiplier + 1;
        System.out.println("Damage: " + impact);
    }
}

class WarriorC extends Warrior {
    public WarriorC(String name, int power, int attack, int defense) {
        super(name, power, attack, defense);
    }

    public void calculateDamage() {

        double multiplier = (0.5) * this.power * (Math.random() * 100);
        double impact = Math.floor((double) this.attack / this.defense) * multiplier + 1;
        System.out.println("Damage: " + impact);
    }
}

