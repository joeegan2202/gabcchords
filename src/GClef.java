public class GClef implements GObject {
    private final String token;
    private final ClefType type;
    private final int position;

    public GClef(String token) throws Exception {
        this.token = token;

        try {
            String inner = token.split("[()]")[1];
            String[] elements = inner.replaceAll("([cbf]+)", "$1&").split("&");
            switch (elements[0]) {
                case "c" -> type = ClefType.C;
                case "f" -> type = ClefType.F;
                case "cb" -> type = ClefType.CB;
                default -> {
                    System.out.println("Unknown clef type: " + elements[0]);
                    type = ClefType.C;
                }
            }

            position = Integer.parseInt(elements[1]);
        } catch (Exception e) {
            System.out.println("Failed to parse clef! " + token);
            throw new Exception();
        }
    }

    public LObject convert(LLyrics l, GClef c, int sharps, int t) {
        return new LClef(sharps);
    }

    public boolean equals(String clef) {
        return this.token.equals(clef);
    }

    public String toString() {
        return "Clef: \"" + token + "\" (" + type + ", " + position + ")";
    }
}
