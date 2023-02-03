import java.util.ArrayList;

public class LVoiceFragment implements LObject {
    private final ArrayList<LNote> notes;

    public LVoiceFragment(ArrayList<LNote> notes) {
        this.notes = notes;
    }
    public LVoiceFragment(LNote note) {
        this.notes = new ArrayList<>();
        notes.add(note);
    }

    public int getNotesSize() {
        return notes.size();
    }

    public int getNotesDuration() {
        int duration = 0;
        for (LNote note :
                notes) {
            duration += note.getDuration();
        }
        return duration;
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
