import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class LStaff {
    private final LLyrics lyrics;
    private final ArrayList<LObject> soprano;
    private final ArrayList<LObject> alto;
    private final ArrayList<LObject> tenor;
    private final ArrayList<LObject> bass;

    public LStaff(LLyrics lyrics) {
        this.lyrics = lyrics;

        soprano = new ArrayList<>();
        alto = new ArrayList<>();
        tenor = new ArrayList<>();
        bass = new ArrayList<>();
    }

    public ArrayList<String> getLyrics() {
        return lyrics.getLyrics();
    }

    public ArrayList<LObject> getSoprano() {
        return soprano;
    }

    public ArrayList<LObject> getAlto() {
        return alto;
    }
    public ArrayList<LObject> getTenor() {
        return tenor;
    }
    public ArrayList<LObject> getBass() {
        return bass;
    }

    public void appendSoprano(LObject newObj) {
        soprano.add(newObj);
    }

    public void appendAlto(LObject newObj) {
        alto.add(newObj);
    }

    public void appendTenor(LObject newObj) {
        tenor.add(newObj);
    }

    public void appendBass(LObject newObj) {
        bass.add(newObj);
    }

    public String digestLyrics() {
        return lyrics.digest();
    }

    public String digestSoprano() {
        StringBuilder sb = new StringBuilder();

        for(LObject vf : soprano) {
            sb.append(vf.digest());
            sb.append('\n');
        }

        return sb.toString();
    }

    public String digestAlto() {
        StringBuilder sb = new StringBuilder();

        for(LObject vf : alto) {
            sb.append(vf.digest());
            sb.append('\n');
        }

        return sb.toString();
    }

    public String digestTenor() {
        StringBuilder sb = new StringBuilder();

        for(LObject vf : tenor) {
            sb.append(vf.digest());
            sb.append('\n');
        }

        return sb.toString();
    }

    public String digestBass() {
        StringBuilder sb = new StringBuilder();

        for(LObject vf : bass) {
            sb.append(vf.digest());
            sb.append('\n');
        }

        return sb.toString();
    }
}
