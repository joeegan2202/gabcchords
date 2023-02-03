import java.util.ArrayList;
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

    public void makeUpBreaks() {
        int duration = 0;
        ListIterator<LObject> iter = soprano.listIterator();
        while(iter.hasNext()) {
            LObject object = iter.next();
            if(object.getClass().equals(LVoiceFragment.class)) {
                duration += ((LVoiceFragment)object).getNotesSize();
            }
            if(duration >= 25) {
                iter.add(new Break());
                duration = 0;
            }
        }
    }

    public void fixTenor() {
        ListIterator<LObject> sopranoIter = soprano.listIterator();
        int sopranoDuration = 0;
        ListIterator<LObject> tenorIter = tenor.listIterator();
        int tenorDuration = 0;

        while(sopranoDuration != 0 || tenorDuration != 0 || sopranoIter.hasNext() || tenorIter.hasNext()) {
            int min = Math.min(sopranoDuration, tenorDuration);
            sopranoDuration -= min;
            tenorDuration -= min;

            if(sopranoDuration <= tenorDuration) {
                if(!sopranoIter.hasNext()) break;
                LObject sopranoNext = sopranoIter.next();

                if(sopranoNext.getClass().equals(LVoiceFragment.class)) {
                    sopranoDuration += ((LVoiceFragment)sopranoNext).getNotesDuration();
                } else if(sopranoNext.getClass().equals(LClef.class)) {
                    tenorIter.add(sopranoNext);
                } else if(sopranoNext.getClass().equals(Bar.class)) {
                    if(sopranoDuration != tenorDuration) System.out.println("We're trying to add a tenor bar where it doesn't make sense!");
                    tenorIter.add(sopranoNext);
                }
            } else {
                if(!tenorIter.hasNext()) break;
                LObject tenorNext = tenorIter.next();

                if(tenorNext.getClass().equals(LVoiceFragment.class)) {
                    tenorDuration += ((LVoiceFragment)tenorNext).getNotesDuration();
                }
            }
        }
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
