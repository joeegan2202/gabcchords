public class LNote {
    private final String name;
    // Calculated in terms of eight notes
    private final int octave;
    private final boolean isMelody;
    private final int duration;
    public final boolean quilisma;
    public boolean beginGroup = false;
    public boolean endGroup = false;
    public boolean tie = false;

    public LNote(String name, boolean quilisma, int octave, boolean isMelody, int duration) {
        this.name = name;
        this.quilisma = quilisma;
        this.octave = octave;
        this.isMelody = isMelody;
        this.duration = duration;
    }

    public LNote(int midiNote, int sharps, int duration) {
        String[] sharpNotes = {"c", "cis", "d", "dis", "e", "f", "fis", "g", "gis", "a", "ais", "b"};
        String[] flatNotes = {"c", "des", "d", "ees", "e", "f", "ges", "g", "aes", "a", "bes", "b"};
        name = (sharps > 0) ? sharpNotes[midiNote % 12] : flatNotes[midiNote % 12];
        quilisma = false;
        octave = (midiNote / 12) - 4;
        isMelody = false;
        this.duration = duration;
    }

    public LNote(int duration) {
        // Specifically meant to create a spacer/empty notes
        name = "s";
        quilisma = false;
        octave = 0;
        isMelody = false;
        this.duration = duration;
    }

    public boolean equals(LNote note) {
        if(note == null) return false;
        return this.name.equals(note.name) && this.octave == note.octave;
    }
    public void setBeginGroup() {
        beginGroup = true;
    }

    public void setEndGroup() {
        endGroup = true;
    }

    public void setTie() {
        tie = true;
    }

    public String getName() {
        return name;
    }

    public int getOctave() {
        return octave;
    }

    public int getDuration() {
        return duration;
    }

    public String toString() {
        String octaveMark = (octave == -1) ? "," : (octave == 0) ? "" : (octave == 1) ? "'" : "''";
        String quilMark = quilisma ? "\\quil " : "";
        return quilMark + name + octaveMark + (isMelody ? 4 + ((duration == 3) ? "." : "") : (duration < 4 ? (duration < 3 ? "4" : "4.") : "2*" + duration + "/4")) + (endGroup ? ")" : "") + (beginGroup ? "(" : "") + (tie ? "~" : "");
    }
}
