public class Neum {
    public boolean flat;
    public boolean isQuilisma;
    public boolean dotted;
    private final char name;

    public Neum(char name, boolean flat, boolean isQuilisma, boolean dotted) {
        this.name = name;
        this.flat = flat;
        this.isQuilisma = isQuilisma;
        this.dotted = dotted;
    }

    public void setDotted(boolean dotted) {
        this.dotted = dotted;
    }

    public char getName() {
        return this.name;
    }

    public LNote convert(GClef clef, int sharps, int transpose) {
        String name = "";
        int duration = this.dotted ? 3 : 2;
        int octave = 0;

        int dist;
        if(clef.equals("(c4)")) {
            dist = switch (this.name) {
                //case 'a' -> 0;
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
            dist = switch (this.name) {
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
            dist = switch (this.name) {
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
            dist = switch (this.name) {
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
            dist = switch (this.name) {
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
            dist = switch (this.name) {
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
            dist = switch (this.name) {
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
            System.out.println("I have no idea why we couldn't find a clef!!!");
            dist = 0;
        }
        dist = flat ? dist - 1 : dist;
        dist += transpose;

        switch (dist) {
            case 0 -> //octave = 0;
                    name = "a";
            case 1 -> //octave = 0;
                    name = (sharps > 0) ? "ais" : (sharps < 0) ? "bes" : "s";
            case 2 -> //octave = 0;
                    name = (sharps < 0) ? "ces" : "b";
            case 3 -> {
                name = (sharps > 1) ? "bis" : "c";
                octave = 1;
            }
            case 4 -> {
                name = (sharps > 0) ? "cis" : (sharps < 0) ? "des" : "s";
                octave = 1;
            }
            case 5 -> {
                name = "d";
                octave = 1;
            }
            case 6 -> {
                name = (sharps > 0) ? "dis" : (sharps < 0) ? "ees" : "s";
                octave = 1;
            }
            case 7 -> {
                name = (sharps < -1) ? "fes" : "e";
                octave = 1;
            }
            case 8 -> {
                name = (sharps > 0) ? "eis" : "f";
                octave = 1;
            }
            case 9 -> {
                name = (sharps > 0) ? "fis" : (sharps < 0) ? "ges" : "s";
                octave = 1;
            }
            case 10 -> {
                name = "g";
                octave = 1;
            }
            case 11 -> {
                name = (sharps > 0) ? "gis" : (sharps < 0) ? "aes" : "s";
                octave = 1;
            }
            case 12 -> {
                name = "a";
                octave = 1;
            }
            case 13 -> {
                name = (sharps > 0) ? "ais" : (sharps < 0) ? "bes" : "s";
                octave = 1;
            }
            case 14 -> {
                name = (sharps < 0) ? "ces" : "b";
                octave = 1;
            }
            case 15 -> {
                name = (sharps > 1) ? "bis" : "c";
                octave = 2;
            }
            case 16 -> {
                name = (sharps > 0) ? "cis" : (sharps < 0) ? "des" : "s";
                octave = 2;
            }
            case 17 -> {
                name = "d";
                octave = 2;
            }
            case 18 -> {
                name = (sharps > 0) ? "dis" : (sharps < 0) ? "ees" : "s";
                octave = 2;
            }
            case 19 -> {
                name = (sharps < -1) ? "fes" : "e";
                octave = 2;
            }
            case 20 -> {
                name = (sharps > 0) ? "eis" : "f";
                octave = 2;
            }
            case 21 -> {
                name = (sharps > 0) ? "fis" : (sharps < 0) ? "ges" : "s";
                octave = 2;
            }
        }

        return new LNote(name, isQuilisma, octave, true, duration);
    }

    public String toString() {
        return "(" + name + (flat?", flat":"") + (isQuilisma?", quilisma":"") + (dotted?", dotted":"") + ")";
    }
}
