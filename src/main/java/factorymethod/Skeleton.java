package factorymethod;

public class Skeleton implements Enemy {
    @Override
    public String getName() {
        return "Skeleton";
    }

    @Override
    public int getDamage() {
        return 8;
    }

    @Override
    public void attack() {
        System.out.println("  Skeleton fires a bone arrow! [" + getDamage() + " dmg]");
    }
}
