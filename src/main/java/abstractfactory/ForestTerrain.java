package abstractfactory;

public class ForestTerrain implements Terrain {
    @Override
    public String getName() {
        return "Ancient Forest";
    }

    @Override
    public String getDescription() {
        return "Dense canopy, moss-covered stones, shafts of golden light";
    }
}
