package abstractfactory;

public class DesertEnemy implements WorldEnemy {
    @Override
    public String getName() {
        return "Sand Scorpion";
    }

    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public void attack() {
        System.out.println("  Sand Scorpion strikes with venomous stinger! [" + getDamage() + " dmg]");
    }
}
