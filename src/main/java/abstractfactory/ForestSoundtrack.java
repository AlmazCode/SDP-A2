package abstractfactory;

public class ForestSoundtrack implements Soundtrack {
    @Override
    public String getTitle() {
        return "Forest Ambience";
    }

    @Override
    public String getMood() {
        return "Peaceful, mysterious, with distant bird calls";
    }
}
