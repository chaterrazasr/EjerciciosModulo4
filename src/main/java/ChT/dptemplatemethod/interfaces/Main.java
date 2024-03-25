package ChT.dptemplatemethod.interfaces;

public class Main {
    public static void main(String[] args) {
        WarriorA warriorA = new WarriorA("Warrior A", 100, 10, 5);
        WarriorB warriorB = new WarriorB("Warrior B", 100, 10, 5);
        WarriorC warriorC = new WarriorC("Warrior C", 100, 10, 5);

        warriorA.calculateDamage();
        warriorB.calculateDamage();
        warriorC.calculateDamage();
    }
}
