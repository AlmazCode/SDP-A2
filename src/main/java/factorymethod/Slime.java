package factorymethod;

public class Slime implements Enemy {
    @Override
    public String getName() {
        return "Slime";
    }

    @Override
    public int getDamage() {
        return 3;
    }

    @Override
    public void attack() {
        System.out.println("  Slime bounces and splashes acid! [" + getDamage() + " dmg]");
    }
}
