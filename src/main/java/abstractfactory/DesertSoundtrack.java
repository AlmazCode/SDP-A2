package abstractfactory;

public class DesertSoundtrack implements Soundtrack {
    @Override
    public String getTitle() {
        return "Desert Solitude";
    }

    @Override
    public String getMood() {
        return "Vast, echoing, with distant drum rhythms";
    }
}
