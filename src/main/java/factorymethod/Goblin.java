package factorymethod;

public class Goblin implements Enemy {
    @Override
    public String getName() {
        return "Goblin";
    }

    @Override
    public int getDamage() {
        return 5;
    }

    @Override
    public void attack() {
        System.out.println("  Goblin slashes with a rusty dagger! [" + getDamage() + " dmg]");
    }
}
