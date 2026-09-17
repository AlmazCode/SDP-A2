package abstractfactory;

public class DesertTerrain implements Terrain {
    @Override
    public String getName() {
        return "Scorching Dunes";
    }

    @Override
    public String getDescription() {
        return "Endless sand dunes, oasis mirages, blazing sun";
    }
}
