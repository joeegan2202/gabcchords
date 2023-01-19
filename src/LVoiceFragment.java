import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class LVoiceFragment implements LObject {
    private final ArrayList<LNote> notes;

    public LVoiceFragment(ArrayList<LNote> notes) {
        this.notes = notes;
    }

    public ListIterator<LNote> startNotes() {
        return notes.listIterator();
    }

    public String digest() {
        StringBuilder sb = new StringBuilder();

        for(LNote note : notes) {
            sb.append(note);
            sb.append(" ");
        }

        return sb.toString();
    }
}
