import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class StaffPrinter {
    private ArrayList<LObject> soprano= null;
    private ArrayList<LObject> alto= null;
    private ArrayList<LObject> tenor= null;
    private ArrayList<LObject> bass= null;

    private LStaff staff;
    private StringBuilder lyricsLine;
    private StringBuilder slurLine;
    private StringBuilder gfLine;
    private StringBuilder gdLine;
    private StringBuilder gbLine;
    private StringBuilder ggLine;
    private StringBuilder geLine;
    private StringBuilder acLine;
    private StringBuilder cLine;
    private StringBuilder ucLine;
    private StringBuilder faLine;
    private StringBuilder ffLine;
    private StringBuilder fdLine;
    private StringBuilder fbLine;
    private StringBuilder fgLine;
    private StringBuilder underLine;

    public StaffPrinter(LStaff staff) {
        this.staff = staff;
        lyricsLine = new StringBuilder();
        slurLine = new StringBuilder();
        gfLine = new StringBuilder();
        gdLine = new StringBuilder();
        gbLine = new StringBuilder();
        ggLine = new StringBuilder();
        geLine = new StringBuilder();
        acLine = new StringBuilder();
        cLine = new StringBuilder();
        ucLine = new StringBuilder();
        faLine = new StringBuilder();
        ffLine = new StringBuilder();
        fdLine = new StringBuilder();
        fbLine = new StringBuilder();
        fgLine = new StringBuilder();
        underLine = new StringBuilder();
    }

    public void start() {
        lyricsLine = new StringBuilder();
        slurLine = new StringBuilder();
        gfLine = new StringBuilder();
        gdLine = new StringBuilder();
        gbLine = new StringBuilder();
        ggLine = new StringBuilder();
        geLine = new StringBuilder();
        acLine = new StringBuilder();
        cLine = new StringBuilder();
        ucLine = new StringBuilder();
        faLine = new StringBuilder();
        ffLine = new StringBuilder();
        fdLine = new StringBuilder();
        fbLine = new StringBuilder();
        fgLine = new StringBuilder();
        underLine = new StringBuilder();

        soprano = staff.getSoprano();
        alto = staff.getAlto();
        tenor = staff.getTenor();
        bass = staff.getBass();
    }

    public void next() {
        char lyricsLineNext = ' ';
        char slurLineNext = ' ';
        char gfLineNext = '-';
        char gdLineNext = '-';
        char gbLineNext = '-';
        char ggLineNext = '-';
        char geLineNext = '-';
        char acLineNext = ' ';
        char cLineNext = '-';
        char ucLineNext = ' ';
        char faLineNext = '-';
        char ffLineNext = '-';
        char fdLineNext = '-';
        char fbLineNext = '-';
        char fgLineNext = '-';
        char underLineNext = ' ';

        LNote sopranoNext = null;
        LNote altoNext = null;
        LNote tenorNext = null;
        LNote bassNext = null;

    }

    public void print() {
        System.out.println(lyricsLine);
        System.out.println(slurLine);
        System.out.println(gfLine);
        System.out.println(gdLine);
        System.out.println(gbLine);
        System.out.println(ggLine);
        System.out.println(geLine);
        System.out.println(acLine);
        System.out.println(cLine);
        System.out.println(ucLine);
        System.out.println(faLine);
        System.out.println(ffLine);
        System.out.println(fdLine);
        System.out.println(fbLine);
        System.out.println(fgLine);
        System.out.println(underLine);
    }
}
