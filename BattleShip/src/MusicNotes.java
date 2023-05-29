import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 * Utility class to play musical notes.
 */
public class MusicNotes {
    public static final int BUF_SIZE = 32000;
    public static final int SAMPLE_RATE = 44000;
    public static final int FREQUENCY_A4 = 440;
    public static final int AMPLITUDE = 10;

    private static Map<String, Double> noteFrequencies = getNoteFrequencyMap(1, 7);
    private static SourceDataLine dataLine = initDataLine();
    private static byte[] buffer = new byte[BUF_SIZE];

    // public static void main(String[] args) {
    // // playNote("C3", 3);

    // var frequencyNoteList = invertMap(noteFrequencies);
    // for (var pair : frequencyNoteList) {
    // System.out.printf("%-5s: %s\n", Math.round(pair.getKey()), String.join(" ",
    // pair.getValue()));
    // play(pair.getKey(), 1);
    // }

    // String[]notes="C3 D3 E3 F3 G3 A3 B3 C4 D4 E4 F4 G4 A4 B4".split(" ");
    // for(String note:notes) {
    // System.out.println(noteFrequencies.get(note));
    // //playNote(note,1);
    // }
    // }

    /**
     * Plays specified note for specified duration. See musical notations:
     * https://www.audiolabs-erlangen.de/resources/MIR/FMP/data/C1/FMP_C1_F02.png
     * 
     * @param note        Note to play. Example notes: "C4" is middle C, "C#4" is
     *                    middle C sharp, "Eb3" is baritone E flat, etc.
     * @param durationSec Duration (in seconds) to play note for.
     */
    public static void playNote(String note, double durationSec) {
        Double frequency = noteFrequencies.get(note);

        if (frequency == null) {
            System.err.println("Unrecognized note: " + note);
            return;
        }

        play(frequency, durationSec);
    }

    /**
     * Plays note for 1 second. See {@link #playNote(String, double)} method.
     * 
     * @param note
     */
    public static void playNote(String note) {
        playNote(note, 1);
    }

    /**
     * Plays specified frequency for specified duration.
     * 
     * @param frequencyHz Frequency in Hz
     * @param durationSec Duraction in seconds.
     */
    public static void play(double frequencyHz, double durationSec) {
        long start = System.nanoTime();

        long beat = 0;
        while (System.nanoTime() - start < durationSec * 1_000_000_000) {
            for (int i = 0; i < BUF_SIZE; i++, beat++) {
                buffer[i] = (byte) (AMPLITUDE * Math.sin(2 * Math.PI * frequencyHz * beat / SAMPLE_RATE));
            }
            dataLine.write(buffer, 0, buffer.length);
        }
    }

    private static SourceDataLine initDataLine() {
        AudioFormat aFormat = new AudioFormat(SAMPLE_RATE, 8, 1, true, false);

        try {
            SourceDataLine line = AudioSystem.getSourceDataLine(aFormat);
            line.open(aFormat, BUF_SIZE);
            line.start();
            return line;
        } catch (LineUnavailableException exception) {
            System.err.println("Failed to open data line.");
            return null;
        }
    }

    private static Map<String, Double> getNoteFrequencyMap(int startScale, int endScale) {

        int offsetC = -9; // offset of C note relative to base A note in its scale.
        String[] noteFormatStrings = { "C%d", "C#%d", "D%d", "D#%d", "E%d", "F%d", "F#%d", "G%d", "G#%d", "A%d", "A#%d",
                "B%d" };

        Map<String, Double> noteFreqMap = new HashMap<String, Double>();

        for (int scale = startScale; scale <= endScale; scale++) {
            // Frequency of base A note in this scale.
            int frequencyA = scale >= 4 ? FREQUENCY_A4 << scale - 4 : FREQUENCY_A4 >> 4 - scale;

            for (int i = 0; i < noteFormatStrings.length; i++) {
                // Format note.
                String note = String.format(noteFormatStrings[i], scale);
                int offset = offsetC + i;
                // Calculate note frequency.
                double freq = getNoteFrequency(frequencyA, offset);
                // Store note-frequency pair in map.
                noteFreqMap.put(note, freq);

                // Also add equivalent note, if any.
                String equivalentNote = getEquivalentNote(note);
                if (equivalentNote != null) {
                    noteFreqMap.put(equivalentNote, freq);
                }
            }
        }

        return noteFreqMap;
    }

    /**
     * Calculates frequency of note at specified offset from specified base
     * frequency.
     * Eg., C4 is at an offset of 3 from A4 (A4, A4#, B4, C4), so frequency of C4 is
     * A4 * 2 ** (3/12) = 440 * 2 ** (3/12) ~ 523.28
     * 
     * @param baseFrequency
     * @param offset
     * @return
     */
    private static double getNoteFrequency(double baseFrequency, int offset) {
        return baseFrequency * Math.pow(2, (double) offset / 12.);
    }

    /**
     * 
     * @param note One of Cn, C#n, Dn, D#n, En, Fn, F#n, Gn, G#n, An, A#n, Bn.
     * @return
     */
    private static String getEquivalentNote(String note) {

        char naturalNote = note.charAt(0);

        // Sharps:
        if (note.charAt(1) == '#') {
            // Return equivalent flat:
            return (char) (naturalNote + 1) + "b" + note.substring(2);
        }

        // Naturals:
        int scale = Integer.parseInt(note.substring(1));
        switch (naturalNote) {
            case 'C':
                return "B#" + (scale - 1);
            case 'E':
                return "Fb" + scale;
            case 'F':
                return "E#" + scale;
            case 'B':
                return "Cb" + (scale + 1);
        }

        // No equivalent:
        return null;
    }

    private static <S, T extends Comparable<T>> List<Entry<T, List<S>>> invertMap(final Map<S, T> map) {

        Map<T, List<S>> inverseMap = new HashMap<>();
        for (Entry<S, T> entry : map.entrySet()) {
            S key = entry.getKey();
            T value = entry.getValue();
            if (inverseMap.get(value) == null) {
                inverseMap.put(value, new ArrayList<>());
            }

            inverseMap.get(value).add(key);
        }

        // Sort by frequency.
        var frequencyNoteList = new ArrayList<>(inverseMap.entrySet());
        frequencyNoteList.sort(Comparator.comparing(entry -> entry.getKey()));

        return frequencyNoteList;
    }
}

