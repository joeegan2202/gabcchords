import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Printer {
    private LStaff staff;
    private ListIterator<String> lyricIter;
    private String lyric;
    private ListIterator<LObject> sopranoIter;
    private ArrayList<LObject> soprano;
    private ArrayList<LObject> alto;
    private ArrayList<LObject> tenor;
    private ArrayList<LObject> bass;

    public Printer(LStaff staff) {
        this.staff = staff;
        lyricIter = staff.getLyrics().listIterator();
        sopranoIter = staff.getSoprano().listIterator();
        advance();
    }

    public void chord() {
        Scanner scanner = new Scanner(System.in);
        while (advance()) {
            print();
            System.out.println("Input alto:");
            String altoLine = scanner.nextLine();

            for(int i = 0; i < altoLine.length(); i++) {
                String name = "";
                int octave = 0;
                int duration = 0;



                new LNote(name, false, octave, false, duration);
            }
        }
    }

    public boolean advance() {
        int lyricLength = 0;
        int sopranoLength = 0;
        boolean advanced = false;

        lyric = "";
        soprano = new ArrayList<>();
        do {
            if(lyricLength <= sopranoLength) {
                if (lyricIter.hasNext()) {
                    lyric += lyricIter.next() + " ";
                    lyricLength++;
                    advanced = true;
                }
            } else {
                while (sopranoIter.hasNext()) {
                    LObject nextSoprano = sopranoIter.next();
                    if (nextSoprano.getClass().equals(LVoiceFragment.class)) {

                        boolean inGroup = false;
                        ListIterator<LNote> iter = ((LVoiceFragment) nextSoprano).startNotes();
                        while (iter.hasNext()) {
                            LNote note = iter.next();
                            if (note.beginGroup) inGroup = true;
                            else if (note.endGroup) {
                                inGroup = false;
                                sopranoLength++;
                            } else if (!inGroup) {
                                sopranoLength++;
                            }
                        }

                        advanced = true;
                        soprano.add(nextSoprano);
                        break;
                    } else if(nextSoprano.getClass().equals(Bar.class)) {
                        advanced = true;
                        soprano.add(nextSoprano);
                        break;
                    }
                }
            }
        } while(lyricLength != sopranoLength);

        alto = new ArrayList<>();
        tenor = new ArrayList<>();
        bass = new ArrayList<>();
        return advanced;
    }

    public void print() {
        System.out.println(lyric);
        System.out.println("\nSoprano:");
        soprano.stream().forEach(object -> System.out.print(object.digest() + ' '));
        System.out.println("\n\nAlto:");
        alto.stream().forEach(object -> System.out.print(object.digest() + ' '));
        System.out.println("\n\nTenor:");
        tenor.stream().forEach(object -> System.out.print(object.digest() + ' '));
        System.out.println("\n\nBass:");
        bass.stream().forEach(object -> System.out.print(object.digest() + ' '));
    }
}
