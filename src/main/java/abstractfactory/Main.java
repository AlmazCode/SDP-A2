package abstractfactory;

import java.util.Map;

public class Main {
    private static final Map<String, WorldFactory> FACTORIES = Map.of(
        "forest", new ForestWorldFactory(),
        "ice",    new IceWorldFactory(),
        "desert", new DesertWorldFactory()
    );

    public static void main(String[] args) {
        System.out.println("=== Part B: Abstract Factory ===\n");

        String[] worlds = {"forest", "ice", "desert"};

        for (String worldName : worlds) {
            System.out.println(">> Creating world: " + worldName.toUpperCase());
            WorldFactory factory = FACTORIES.get(worldName);
            World world = WorldGenerator.createWorld(factory);
            world.describe();
            world.spawnEncounter();
            System.out.println();
        }
    }
}
