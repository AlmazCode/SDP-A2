package abstractfactory;

public class World {
    private final WorldEnemy enemy;
    private final Terrain terrain;
    private final Soundtrack soundtrack;

    public World(WorldFactory factory) {
        this.enemy = factory.createEnemy();
        this.terrain = factory.createTerrain();
        this.soundtrack = factory.createSoundtrack();
    }

    public void describe() {
        System.out.println("--- World Created ---");
        System.out.println("Terrain:     " + terrain.getName());
        System.out.println("               " + terrain.getDescription());
        System.out.println("Soundtrack:  " + soundtrack.getTitle());
        System.out.println("               " + soundtrack.getMood());
        System.out.println("Enemy:       " + enemy.getName() + " [" + enemy.getDamage() + " dmg]");
        System.out.println();
    }

    public void spawnEncounter() {
        System.out.println("A wild " + enemy.getName() + " appears!");
        enemy.attack();
    }
}
