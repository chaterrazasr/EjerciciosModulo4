package ChT.dptemplatemethod.abstracto;

public class Main {
    public static void main(String[] args) {
        WarriorA warriorA = new WarriorA("Warrior A", 100, 20, 10);
        WarriorB warriorB = new WarriorB("Warrior B", 100, 20, 10);
        WarriorC warriorC = new WarriorC("Warrior C", 100, 20, 10);

        warriorA.calculateDamage();
        warriorB.calculateDamage();
        warriorC.calculateDamage();
    }
}
