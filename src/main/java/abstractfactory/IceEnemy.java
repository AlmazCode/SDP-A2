package abstractfactory;

public class IceEnemy implements WorldEnemy {
    @Override
    public String getName() {
        return "Frost Elemental";
    }

    @Override
    public int getDamage() {
        return 15;
    }

    @Override
    public void attack() {
        System.out.println("  Frost Elemental unleashes a blizzard! [" + getDamage() + " dmg]");
    }
}
