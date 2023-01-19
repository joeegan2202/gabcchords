import java.util.ArrayList;
import java.util.Collections;

public class GStaff {
    private final ArrayList<GObject> objects;

    public GStaff() {
        objects = new ArrayList<>();
    }

    public void ingest(String token) throws Exception {
        token = replaceSP(token);
        if(token.matches("\\([cf]b?\\d\\)")) {
            //System.out.println("Found clef token? " + token);
            objects.add(new GClef(token));
        } else if (token.matches(".*\\([,';:]+\\)")) {
            objects.add(new Bar(token));
        } else {
            //System.out.println("Found word token? " + token);
            Word word = new Word(token);
            GObject[] wordObjects = word.rectify();

            if (wordObjects == null) {
                objects.add(word);
            } else {
                Collections.addAll(objects, wordObjects);
            }
        }
    }

    private String replaceSP(String token) {
        return token.replaceAll("<sp>V/</sp>", "℣")
                .replaceAll("<sp>R/</sp>", "℟")
                .replaceAll("<sp>A/</sp>" ,"Ⱥ")
                .replaceAll("<sp>ae</sp>", "æ")
                .replaceAll("<sp>AE</sp>", "Æ")
                .replaceAll("<sp>oe</sp>", "œ")
                .replaceAll("<sp>OE</sp>", "Œ")
                .replaceAll("<sp>'ae</sp>", "ǽ")
                .replaceAll("<sp>'AE</sp>", "Ǽ")
                .replaceAll("<sp>'oe</sp>", "œ́")
                .replaceAll("<sp>'OE</sp>", "Œ́")
                .replaceAll("<sp>'a</sp>", "á")
                .replaceAll("<sp>'A</sp>", "Á")
                .replaceAll("<sp>'e</sp>", "é")
                .replaceAll("<sp>'E</sp>", "É")
                .replaceAll("<sp>'i</sp>", "í")
                .replaceAll("<sp>'I</sp>", "Í")
                .replaceAll("<sp>'o</sp>", "ó")
                .replaceAll("<sp>'O</sp>", "Ó")
                .replaceAll("<sp>'u</sp>", "ú")
                .replaceAll("<sp>'U</sp>", "Ú");
    }

    public LStaff convert(LLyrics lyrics, int sharps, String startingNote) throws Exception {
        LStaff lStaff = new LStaff(lyrics);

        GClef clef = null;
        Neum firstNeum = null;
        for(GObject obj : objects) {
            if(obj.getClass() == GClef.class) {
                clef = (GClef) obj;
            } else if(obj.getClass() == Word.class) {
                firstNeum = ((Word) obj).getFirstNeum();
                break;
            }
        }
        if(firstNeum == null || clef == null) {
            System.out.println("Could not find first neum or clef of GStaff!! How did this happen???");
            throw new Exception();
        }

        int neumDistance;
        if(clef.equals("(c4)")) {
            neumDistance = switch (firstNeum.getName()) {
                // case 'a' -> 0;
                case 'b' -> 2;
                case 'c' -> 3;
                case 'd' -> 5;
                case 'e' -> 7;
                case 'f' -> 8;
                case 'g' -> 10;
                case 'h' -> 12;
                case 'i' -> 14;
                case 'j' -> 15;
                case 'k' -> 17;
                case 'l' -> 19;
                case 'm' -> 20;
                default -> 0;
            };
        } else if(clef.equals("(c3)")) {
            neumDistance = switch (firstNeum.getName()) {
                //case 'a' -> 0;
                case 'b' -> 2;
                case 'c' -> 4;
                case 'd' -> 5;
                case 'e' -> 7;
                case 'f' -> 9;
                case 'g' -> 11;
                case 'h' -> 12;
                case 'i' -> 14;
                case 'j' -> 16;
                case 'k' -> 17;
                case 'l' -> 19;
                case 'm' -> 21;
                default -> 0;
            };
        } else if(clef.equals("(cb3)")) {
            neumDistance = switch (firstNeum.getName()) {
                //case 'a' -> 0;
                case 'b' -> 2;
                case 'c' -> 4;
                case 'd' -> 5;
                case 'e' -> 7;
                case 'f' -> 9;
                case 'g' -> 10;
                case 'h' -> 12;
                case 'i' -> 14;
                case 'j' -> 16;
                case 'k' -> 17;
                case 'l' -> 19;
                case 'm' -> 21;
                default -> 0;
            };
        } else if(clef.equals("(c2)")) {
            neumDistance = switch (firstNeum.getName()) {
                //case 'a' -> 0;
                case 'b' -> 1;
                case 'c' -> 3;
                case 'd' -> 5;
                case 'e' -> 7;
                case 'f' -> 8;
                case 'g' -> 10;
                case 'h' -> 12;
                case 'i' -> 13;
                case 'j' -> 15;
                case 'k' -> 17;
                case 'l' -> 19;
                case 'm' -> 20;
                default -> 0;
            };
        } else if(clef.equals("(c1)")) {
            neumDistance = switch (firstNeum.getName()) {
                //case 'a' -> 0;
                case 'b' -> 2;
                case 'c' -> 4;
                case 'd' -> 5;
                case 'e' -> 7;
                case 'f' -> 9;
                case 'g' -> 10;
                case 'h' -> 12;
                case 'i' -> 14;
                case 'j' -> 16;
                case 'k' -> 17;
                case 'l' -> 19;
                case 'm' -> 21;
                default -> 0;
            };
        } else if(clef.equals("(f4)")) {
            neumDistance = switch (firstNeum.getName()) {
                //case 'a' -> 0;
                case 'b' -> 2;
                case 'c' -> 3;
                case 'd' -> 5;
                case 'e' -> 7;
                case 'f' -> 9;
                case 'g' -> 10;
                case 'h' -> 12;
                case 'i' -> 14;
                case 'j' -> 15;
                case 'k' -> 17;
                case 'l' -> 19;
                case 'm' -> 21;
                default -> 0;
            };
        } else if(clef.equals("(f3)")) {
            neumDistance = switch (firstNeum.getName()) {
                //case 'a' -> 0;
                case 'b' -> 2;
                case 'c' -> 4;
                case 'd' -> 6;
                case 'e' -> 7;
                case 'f' -> 9;
                case 'g' -> 11;
                case 'h' -> 12;
                case 'i' -> 14;
                case 'j' -> 16;
                case 'k' -> 18;
                case 'l' -> 19;
                case 'm' -> 21;
                default -> 0;
            };
        } else {
            System.out.println("I have no idea why we didn't find a clef!!!");
            neumDistance = 0;
        }
        neumDistance = firstNeum.flat ? neumDistance - 1 : neumDistance;

        int noteDistance = switch (startingNote) {
            //case "a" -> 0;
            case "ais", "bes" -> 1;
            case "b", "ces" -> 2;
            case "c", "bis" -> 3;
            case "cis", "des" -> 4;
            case "d" -> 5;
            case "dis", "ees" -> 6;
            case "e", "fes" -> 7;
            case "eis", "f" -> 8;
            case "fis", "ges" -> 9;
            case "g" -> 10;
            case "gis", "aes" -> 11;
            default -> 0;
        };

        int transpose = noteDistance - neumDistance;

        for(GObject obj : objects) {
            lStaff.appendSoprano(obj.convert(lyrics, clef, sharps, transpose));
        }

        return lStaff;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(GObject object : objects) {
            sb.append(object);
            sb.append('\n');
        }
        return sb.toString();
    }
}
