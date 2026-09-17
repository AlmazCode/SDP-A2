package abstractfactory;

public class IceSoundtrack implements Soundtrack {
    @Override
    public String getTitle() {
        return "Winter Winds";
    }

    @Override
    public String getMood() {
        return "Eerie, cold, howling wind melodies";
    }
}
