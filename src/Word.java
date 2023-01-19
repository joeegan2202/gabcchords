import java.util.ArrayList;
import java.util.Optional;

public class Word implements GObject {
    private final String token;
    private final GObject[] childObjects;
    private final ArrayList<Group> subgroups;

    //public static final char[] NOTES = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'};

    public Word(String token) {
        this.token = token;
        this.subgroups = new ArrayList<>();

        // The capability to add bars in the middle of words is annoying
        // Split string into all subwords and bars
        String[] substrings = token.replaceAll("[:;,]+(?=[^(]*\\))", "\\)&\\($0\\)&\\(").split("&");

        // If there are no bars, we'll set childobjects to null to let score know that we are a solo word
        if(substrings.length == 1) {
            childObjects = null;
        } else {
            childObjects = new GObject[substrings.length];

            for(int i = 0; i < substrings.length; i++) {
                // Same regex as in score to detect bar
                if (substrings[i].matches(".*\\([,';:]+\\)")) {
                    // Pass the inner bar to a new Bar child
                    childObjects[i] = new Bar(substrings[i]);
                } else {
                    // Go ahead and pass along the gabc to a child Word
                    childObjects[i] = new Word(substrings[i]);
                }
            }

            // Return and let Score handle getting my children
            // This Word is not going to parse anything
            return;
        }

        // We're going to continue parsing a word as it has been assured that there are no bars in it now
        String[] syllables = token.replaceAll("\\)", ")&").split("&");
        for (String syllable : syllables) {
            String[] elements = syllable.split("[()]");

            if(elements.length < 2) {
                // Basically we have an empty syllable, it will be translated into a stanza directive
                Group group = new Group(elements[0].isEmpty() ? "_" : elements[0]);
                subgroups.add(group);
                continue;
            }

            char[] inner = elements[1].toCharArray();
            ArrayList<Neum> notesGroup = new ArrayList<>();
            ArrayList<Character> flats = new ArrayList<>(2);
            boolean inclinatus = false;

            for(int i = 0; i < inner.length; i++) {
                boolean isQuilisma = false;
                boolean dotted = false;

                if(!((inner[i] >= 'a' && inner[i] <= 'm') || (inner[i] >= 'A' && inner[i] <= 'M'))) {
                    switch (inner[i]) {
                        case 'x':
                            System.out.println("Unsure how we caught 'x' here! Continuing... " + syllable);
                            continue;
                        case 'w':
                            //System.out.println("Unsure how we caught 'w' here! Continuing... " + syllable);
                            continue;
                        case '.':
                            //System.out.println("Unsure how we caught '.' here! Continuing... " + syllable);
                            continue;

                        case 'v':
                        case 'V':
                            // We should only encounter this if we're seeing a double virga
                            if(i < inner.length - 1 && inner[i + 1] == '.') {
                                notesGroup.add(new Neum(inner[i-2], flats.contains(inner[i-2]), false, true));
                                i++;
                            } else {
                                notesGroup.add(new Neum(inner[i-2], flats.contains(inner[i-2]), false, false));
                            }
                            continue;
                        case '/':
                            if(notesGroup.isEmpty()) continue;
                            // If we encounter a double slash, dot the last note of the group
                            if(i < inner.length - 1 && inner[i+1] == '/') notesGroup.get(notesGroup.size() - 1).setDotted(true);
                            Group group = new Group(elements[0].isEmpty() ? "_" : elements[0]);
                            elements[0] = "_";
                            group.setNotes(notesGroup);
                            subgroups.add(group);
                            notesGroup = new ArrayList<>();
                            inclinatus = false;
                            continue;

                        case '~':
                        case 's':
                        case '<':
                        case '>':
                        case 'o':
                        case '\'':
                        case '_':
                        case '!':
                        case '@':
                            // We're just going to ignore all of these characters
                            continue;
                        default:
                            System.out.println("Encountered unknown character '" + inner[i] + "' in syllable: " + syllable);
                    }
                }

                if(i < inner.length - 1 && inner[i + 1] == 'x') {
                    flats.add(inner[i]);
                    i++;
                    continue;
                }
                if(i < inner.length - 1 && (inner[i + 1] == 'w' || inner[i + 1] == 'W')) {
                    isQuilisma = true;
                }
                if(i < inner.length - 1 && inner[i + 1] == '.') {
                    dotted = true;
                }
                if(i < inner.length - 1 && (inner[i + 1] == 'v' || inner[i + 1] == 'V')) {
                    // Virga means last group is finished
                    if(!notesGroup.isEmpty()) {
                        Group group = new Group(elements[0].isEmpty() ? "_" : elements[0]);
                        elements[0] = "_";
                        group.setNotes(notesGroup);
                        subgroups.add(group);
                        notesGroup = new ArrayList<>();
                    }
                    notesGroup.add(new Neum(inner[i], flats.contains(inner[i]), isQuilisma, dotted));
                    i++;
                    inclinatus = false;
                    continue;
                }

                if(Character.isUpperCase(inner[i])) {
                    inclinatus = true;
                    inner[i] = Character.toLowerCase(inner[i]);
                } else if(Character.isLowerCase(inner[i]) && inclinatus) {
                    // First neum after inclinatus means that group is finished

                    // This is a special rule to include a single neum after an inclinatus in the group
                    // This is very likely going to break
                    if(i == inner.length - 1) {
                        notesGroup.add(new Neum(inner[i], flats.contains(inner[i]), false, false));
                        Group group = new Group(elements[0].isEmpty() ? "_" : elements[0]);
                        elements[0] = "_";
                        group.setNotes(notesGroup);
                        subgroups.add(group);
                        notesGroup = new ArrayList<>();
                        break;
                    } else if(i == inner.length - 2 && inner[i+1] == '.') {
                        notesGroup.add(new Neum(inner[i], flats.contains(inner[i]), false, true));
                        Group group = new Group(elements[0].isEmpty() ? "_" : elements[0]);
                        elements[0] = "_";
                        group.setNotes(notesGroup);
                        subgroups.add(group);
                        notesGroup = new ArrayList<>();
                        break;
                    }

                    Group group = new Group(elements[0].isEmpty() ? "_" : elements[0]);
                    elements[0] = "_";
                    group.setNotes(notesGroup);
                    subgroups.add(group);
                    notesGroup = new ArrayList<>();
                    inclinatus = false;
                }

                notesGroup.add(new Neum(inner[i], flats.contains(inner[i]), isQuilisma, dotted));
            }

            Group group = new Group(elements[0].isEmpty() ? "_" : elements[0]);
            elements[0] = "_";
            group.setNotes(notesGroup);
            subgroups.add(group);
        }
    }

    public Neum getFirstNeum() {
        return subgroups.get(0).getFirstNeum();
    }

    public GObject[] rectify() {
        return childObjects;
    }

    public LObject convert(LLyrics lyrics, GClef clef, int sharps, int transpose) {
        ArrayList<LNote> notes = new ArrayList<>();

        Optional<Group> lastGroup = subgroups.stream().reduce((oldgroup, newgroup) -> newgroup.getLyric().equals("_") ? oldgroup : newgroup);

        boolean first = true, stopDash = false;
        for(Group group : subgroups) {
            if(group.isEmpty() && group.getLyric() != null && !group.getLyric().isEmpty()) {
                lyrics.append(String.format("\\set stanza = \"%s\"\n", group.getLyric()));
                continue;
            }

            if(first) {
                lyrics.append(group.getLyric());
                first = false;
            } else {
                if(stopDash) {
                    lyrics.append(group.getLyric());
                } else {
                    lyrics.append("-- " + group.getLyric());
                }
            }
            stopDash = group.getLyric().equals("_") || lastGroup.get() == group;

            ArrayList<LNote> temp = group.convert(clef, sharps, transpose);
            if(temp.size() > 1) {
                temp.get(0).setBeginGroup();
                temp.get(temp.size() - 1).setEndGroup();
            }

            notes.addAll(temp);
        }

        return new LVoiceFragment(notes);
    }

    public String toString() {
        return "Word: \"" + token + "\", " + subgroups.toString();
    }
}
