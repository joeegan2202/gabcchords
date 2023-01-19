public class LClef implements LObject {
    private int sharps;
    public LClef(int sharps) {
        this.sharps = sharps;
    }

    public String digest() {
        return switch(sharps) {
            case -7 -> "\\key ces \\major";
            case -6 -> "\\key ges \\major";
            case -5 -> "\\key des \\major";
            case -4 -> "\\key aes \\major";
            case -3 -> "\\key ees \\major";
            case -2 -> "\\key bes \\major";
            case -1 -> "\\key f \\major";
            //case 0 -> "\\key c \\major";
            case 1 -> "\\key g \\major";
            case 2 -> "\\key d \\major";
            case 3 -> "\\key a \\major";
            case 4 -> "\\key e \\major";
            case 5 -> "\\key b \\major";
            case 6 -> "\\key fis \\major";
            case 7 -> "\\key cis \\major";
            default -> "\\key c \\major";
        };
    }
}
