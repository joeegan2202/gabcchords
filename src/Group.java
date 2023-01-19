import java.util.ArrayList;
import java.util.stream.Collectors;

public class Group {
    private final String lyric;
    private ArrayList<Neum> neums;

    public Group(String lyric) {
        this.lyric = lyric;
        neums = new ArrayList<>();
    }

    public void setNotes(ArrayList<Neum> neums) {
        this.neums = neums;
    }

    public boolean isEmpty() {
        return neums.isEmpty();
    }

    public Neum getFirstNeum() {
        return neums.get(0);
    }

    public String getLyric() {
        return lyric;
    }

    public ArrayList<LNote> convert(GClef clef, int sharps, int transpose) {
        return neums.stream().map(neum -> neum.convert(clef, sharps, transpose)).collect(Collectors.toCollection(ArrayList::new));
    }

    public String toString() {
        return "(\"" + lyric + "\" " + neums.toString() + ")";
    }
}
