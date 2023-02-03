import javax.sound.midi.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Recorder implements Receiver {
    public static Recorder recorder;
    public static MidiDevice device;
    public static int sharps;
    public static void setSharps(int sharps) {
        Recorder.sharps = sharps;
    }
    public static void startRecording(ArrayList<LObject> soprano, ArrayList<LObject> other) throws Exception {
        recorder = new Recorder(soprano, other);
        MidiDevice.Info[] devices = MidiSystem.getMidiDeviceInfo();
        for(MidiDevice.Info info : devices) {
            device = MidiSystem.getMidiDevice(devices[3]);
        }
        if(device == null) throw new Exception();

        device.open();
        Transmitter transmitter = device.getTransmitter();
        transmitter.setReceiver(recorder);
    }

    public static void stopRecording() {
        device.close();
        device = null;
        recorder = null;
    }

    private int noteHigh = 0;
    private int noteLow = 0;
    private int duration = 0;
    private final HashSet<Integer> notesOn;
    private LNote lastNote = null;
    private final ArrayList<LObject> soprano;
    private final ArrayList<LObject> other;

    public Recorder(ArrayList<LObject> soprano, ArrayList<LObject> other) {
        this.soprano = soprano;
        this.other = other;
        notesOn = new HashSet<>();
    }

    @Override
    public void send(MidiMessage message, long time) {
        ShortMessage sm;
        try {
            sm = (ShortMessage)message;
        }
        catch (Exception e) {
            return;
        }

        if(sm.getCommand() != ShortMessage.NOTE_ON) return;

        // Second byte is velocity: we can disregard it
        if(!notesOn.contains(sm.getData1())){
            notesOn.add(sm.getData1());
            System.out.println("Note On");
            if(noteHigh != 0) {
                if(noteLow != 0) {
                    // High & Low: we are going to make new high note and increment duration
                    noteHigh = sm.getData1();
                    duration += 2;
                } else {
                    // High & !Low: new high and low
                    if(duration != 0) { // This is necessary to add spacers
                        lastNote = null;
                        other.add(new LVoiceFragment(new LNote(duration)));
                        duration = 0;
                    }
                    noteLow = Math.min(noteHigh, sm.getData1());
                    noteHigh = Math.max(noteHigh, sm.getData1());
                }
            } else {
                noteHigh = sm.getData1();
            }
        } else {
            notesOn.remove(sm.getData1());
            System.out.println("Note Off");
            if(sm.getData1() == noteHigh) {
                noteHigh = 0;
                duration += 2;
            } else if(sm.getData1() == noteLow) {
                if(noteHigh != 0) duration += 2;

                LNote note = new LNote(noteLow, sharps, duration);
                if(note.equals(lastNote)) {
                    lastNote.setTie();
                }
                other.add(new LVoiceFragment(note));
                lastNote = note;
                noteLow = 0;
                noteHigh = 0;
                duration = 0;
            }
        }
    }

    @Override
    public void close() {

    }
}