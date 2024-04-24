package C22300773.subtitles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// TODO: Fix subtitles to not include any disallowed characters (non utf-8)

public class SubtitleReader {

    ArrayList<Subtitle> subtitles;
    Scanner fileReader;
    int lineNumber = 0;
    float offset = 0.3f;

    public SubtitleReader(String filename) {
        subtitles = new ArrayList<Subtitle>();
        // open file
        try {
            File file = new File(filename);
            fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                // add subtitle to array
                subtitles.add(readNextSubtitle());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private Subtitle readNextSubtitle() {
        int id = Integer.parseInt(fileReader.nextLine());
        String[] times = fileReader.nextLine().split(" --> ");
        String startTime = times[0];
        String endTime = times[1];
        String text = "";
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            if (line.equals("")) {
                break;
            }
            text += line + "\n";
        }
        return new Subtitle(id, startTime, endTime, text);
    }

    public Subtitle getCurrentSubtitle(float time) {
        for (Subtitle subtitle : subtitles) {
            if (subtitle.isTime(time, offset) == 0) {
                return subtitle;
            }
        }
        return null;
    }
}
