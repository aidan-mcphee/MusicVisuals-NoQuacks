package C22300773.subtitles;

import main.Song;

public class Subtitle extends Song {
    private int id;
    private float startTime;
    private float endTime;
    private String text;

    public Subtitle(int id, String startTime, String endTime, String text) {
        this.id = id;
        this.startTime = convertTime(startTime);
        this.endTime = convertTime(endTime);
        this.text = text;
    }

    /**
     * Converts a srt file time into a float time in seconds.
     * 
     * @param time the time in the format hh:mm:ss,ms
     * @return the time in seconds
     */
    private float convertTime(String time) {
        // convert the time to seconds
        String[] t = time.split(":");
        return Float.parseFloat(t[0]) * 3600 + Float.parseFloat(t[1]) * 60 + Float.parseFloat(t[2].replace(", ", "."));
    }


    /**
     * Checks if the given time is within the range of the subtitle.
     * 
     * @param time the time to check
     * @return -1 if the time is before the subtitle, 0 if the time is within the subtitle, 1 if the time is after the subtitle
    */
    public float isTime(float time) {
        return time < startTime ? -1 : time > endTime ? 1 : 0;
    }

    public int getId() {
        return id;
    }

    public float getStartTime() {
        return startTime;
    }

    public float getEndTime() {
        return endTime;
    }

    public String getText() {
        return text;
    }

    public void print() {
        System.out.println("ID: " + id);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);
        // print with utf-16 encoding
        System.out.println("Text: " + text);
    }
}
