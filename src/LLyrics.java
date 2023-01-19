import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class LLyrics {
    private final ArrayList<String> lyrics;

    public LLyrics() {
        lyrics = new ArrayList<>();
    }

    public ArrayList<String> getLyrics() {
        return lyrics;
    }

    public void append(String lyric) {
        lyrics.add(lyric);
    }

    public String digest() {
        StringBuilder sb = new StringBuilder();

        for(String lyric : lyrics) {
            sb.append(lyric);
            sb.append(' ');
        }

        sb.append('\n');

        return sb.toString();
    }
}
