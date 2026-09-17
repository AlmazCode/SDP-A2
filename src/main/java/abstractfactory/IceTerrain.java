package abstractfactory;

public class IceTerrain implements Terrain {
    @Override
    public String getName() {
        return "Frozen Tundra";
    }

    @Override
    public String getDescription() {
        return "Endless ice plains, cracking glaciers, aurora-lit skies";
    }
}
