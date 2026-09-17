package abstractfactory;

public class WorldGenerator {
    public static World createWorld(WorldFactory factory) {
        return new World(factory);
    }
}
