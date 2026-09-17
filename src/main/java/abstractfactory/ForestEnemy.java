package abstractfactory;

public class ForestEnemy implements WorldEnemy {
    @Override
    public String getName() {
        return "Forest Treant";
    }

    @Override
    public int getDamage() {
        return 12;
    }

    @Override
    public void attack() {
        System.out.println("  Forest Treant hurls ancient roots! [" + getDamage() + " dmg]");
    }
}
