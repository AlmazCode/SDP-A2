package abstractfactory;

public class ForestWorldFactory implements WorldFactory {
    @Override
    public WorldEnemy createEnemy() {
        return new ForestEnemy();
    }

    @Override
    public Terrain createTerrain() {
        return new ForestTerrain();
    }

    @Override
    public Soundtrack createSoundtrack() {
        return new ForestSoundtrack();
    }
}
