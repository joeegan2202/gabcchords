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
        return quilMark + name + octaveMark + (isMelody ? 4 + ((duration == 3) ? "." : "") : "2*" + duration + "/4") + (endGroup ? ")" : "") + (beginGroup ? "(" : "") + (tie ? "~" : "");
    }
}
