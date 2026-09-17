package abstractfactory;

public class IceWorldFactory implements WorldFactory {
    @Override
    public WorldEnemy createEnemy() {
        return new IceEnemy();
    }

    @Override
    public Terrain createTerrain() {
        return new IceTerrain();
    }

    @Override
    public Soundtrack createSoundtrack() {
        return new IceSoundtrack();
    }
}
