public class Bar implements GObject, LObject {
    private final String token;
    private BarType type;
    private String text = null;

    public Bar(String token){
        this.token = token;

        try {
            String[] elements = token.split("[()]");
            text = elements[0].isEmpty() ? null : elements[0];
            String inner = elements[1];

            switch (inner) {
                case "," -> type = BarType.MINIMA;
                case "'" -> type = BarType.BREATH;
                case ";" -> type = BarType.MAIOR;
                case ":" -> type = BarType.MAXIMA;
                case "::" -> type = BarType.FINALIS;
                default -> {
                    System.out.println("Unknown bar type: " + inner);
                    type = BarType.MAXIMA;
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to get bar type!");
            type = BarType.MAXIMA;
        }
    }

    public String toString() {
        return "Bar: \"" + token + "\" (" + type + ((text == null) ? ")" : ", \"" + text + "\")");
    }

    public LObject convert(LLyrics lyrics, GClef c, int s, int t) {
        if(text != null && !text.isEmpty()) {
            lyrics.append(String.format("\\set stanza = \"%s\"\n", text));
        }
        return this;
    }

    public String digest() {
        return switch (type) {
            case MINIMA -> "\\divisioMinima";
            case MAIOR -> "\\divisioMaior";
            case MAXIMA -> "\\divisioMaxima";
            case FINALIS -> "\\finalis";
            case BREATH -> "\\breath";
        };

    }
}
