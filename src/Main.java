import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        if(args.length != 3) {
            System.out.println("Usage: gabcchords <number of sharps in key signature> <starting note> <filename>");
            return;
        }

        int sharps;
        String startingNote;

        try {
            sharps = Integer.parseInt(args[0]);
            if(sharps < -7 || sharps > 7) {
                System.out.println("Incorrect number of sharps! Must be between -7 and 7");
                return;
            }
            startingNote = args[1];
        } catch(Exception e) {
            System.out.println("Could not parse number of sharps to integer!");
            return;
        }

        Scanner scanner;
        try {
            scanner = new Scanner(new File(args[2]));
        } catch(Exception e) {
            System.out.println("Could not open file: " + args[2]);
            return;
        }

        GStaff gStaff = new GStaff();
        boolean notes = false;
        while(scanner.hasNext()) {
            String token = scanner.next();
            System.out.println("Reading token: " + token);
            if(token.contains("%%")) {
                notes = true;
                continue;
            }
            if(!notes) continue;

            try {
                gStaff.ingest(token);
            } catch (Exception e) {
                System.out.println("Encountered exception! Quitting...");
                return;
            }
        }

        System.out.println(gStaff);

        LStaff lStaff;
        lStaff = gStaff.convert(new LLyrics(), sharps, startingNote);
        lStaff.makeUpBreaks();

        try {
            Scanner hold = new Scanner(System.in);
            Recorder.setSharps(sharps);

            // Record the alto line
            System.out.println("Play the soprano and alto lines on the MIDI controller, and press enter when finished: ");
            Recorder.startRecording(lStaff.getSoprano(), lStaff.getAlto());
            hold.nextLine();
            Recorder.stopRecording();

            // Record the tenor line
            System.out.println("Play the soprano and tenor lines on the MIDI controller, and press enter when finished: ");
            Recorder.startRecording(lStaff.getSoprano(), lStaff.getTenor());
            hold.nextLine();
            Recorder.stopRecording();

            // Record the bass line
            System.out.println("Play the soprano and bass lines on the MIDI controller, and press enter when finished: ");
            Recorder.startRecording(lStaff.getSoprano(), lStaff.getBass());
            hold.nextLine();
            Recorder.stopRecording();
        } catch (Exception e) {
            System.out.println("Could not open midi device!");
        }

        lStaff.fixTenor();

        Scanner template = new Scanner(new File("template.ly"));
        FileWriter output = new FileWriter(args[2].replace("gabc", "ly"), false);

        while(template.hasNextLine()) {
            String tempLine = template.nextLine();
            if(tempLine.contains("$$LYRICS$$")) {
                output.write("\t" + lStaff.digestLyrics());
            } else if(tempLine.contains("$$SOPRANO$$")) {
                output.write("\t" + lStaff.digestSoprano());
            } else if(tempLine.contains("$$ALTO$$")) {
                output.write("\t" + lStaff.digestAlto());
            } else if(tempLine.contains("$$TENOR$$")) {
                output.write("\t" + lStaff.digestTenor());
            } else if(tempLine.contains("$$BASS$$")) {
                output.write("\t" + lStaff.digestBass());
            } else {
                output.write(tempLine + "\n");
            }
        }

        output.close();
    }
}
