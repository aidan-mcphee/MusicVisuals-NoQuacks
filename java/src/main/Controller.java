package main;

import C22300773.AidansVisual;
import C22386221.KimsVisual;
import C22408466.EilishsVisual;
import C22363431.JanasVisual;
import ddf.minim.AudioPlayer;
import processing.core.PGraphics;
import C22300773.subtitles.Subtitle;

import java.util.Map;
import java.util.HashMap;

public class Controller {
    private Song song;
    KimsVisual Kim;
    AidansVisual Aidan;
    EilishsVisual Eilish;
    JanasVisual Jana;
    AudioPlayer aPlayer;

    Map <String, Boolean> playing = new HashMap<String, Boolean>();


    public Controller(Song song){
        this.song = song;
        aPlayer = song.getAudioPlayer();
        Kim = new KimsVisual(song.getGraphics(), song.getFont(0), song.getStickman(0), song.getStickman(1));
        Aidan = new AidansVisual(song.getGraphics(), song.getFont(1));
        Eilish = new EilishsVisual(song.getGraphics());
        Jana = new JanasVisual(song.getGraphics(), 0.8f);
        
        String[] visuals = {"Kim", "Aidan1", "Eilish", "Jana", "Aidan2", "Eilish2", "Jana2"};

        for (String keyString : visuals) {
            playing.put(keyString, false);
        }
    }

    public void handleKeyPress(int keyCode) {
        switch (keyCode) {
            case ' ':
                AudioPlayer aPlayer = song.getAudioPlayer();
                if (aPlayer.isPlaying()) {
                    aPlayer.pause();
                } else {
                    aPlayer.play();
                }
                break;
            case Song.LEFT:
                movePosition(-2000);
                break;
            case Song.RIGHT:
                movePosition(2000);
                break;
            case '1':
                swap("Kim");
                break;
            case '2':
                swap("Aidan1");
                break;
            case '3':
                swap("Eilish");
                break;
            case '4':
                swap("Jana");
                break;
            case '5':
                swap("Aidan2");
                break;
            case '6':
                swap("Eilish2");
                break;
            case '7':
                swap("Jana2");
                break;
            default:
                System.out.println("Unkown key: " + keyCode);
                break;
        }
    }

    public void controlVisual() {
        PGraphics g = song.getGraphics();
        String s = "Now playing: ";
        float smoothedAmplitude = song.getSmoothedAmplitude();
        if (playing.get("Kim")) {
            Kim.play(smoothedAmplitude);
            s = s.concat("Kim, ");
        }
        if (playing.get("Aidan1")) {
            Aidan.render(smoothedAmplitude);
            s = s.concat("Aidan1, ");
        }
        if (playing.get("Eilish")) {
            Eilish.Starfield(smoothedAmplitude);
            s = s.concat("Eilish, ");
        }
        if (playing.get("Jana")) {
            Jana.DiscTiles.drawTiles(smoothedAmplitude);
            s = s.concat("Jana");
        }
        if (playing.get("Aidan2")) {
            Subtitle sub = song.sr.getCurrentSubtitle(song.getAudioPlayer().position() / 1000);
        
            if (sub != null) {
                String text = sub.getText();
                g.textAlign(Song.CENTER, Song.CENTER);
                g.textSize(64);
                g.text(text, g.width/2, g.height - 100);
            }
            s = s.concat("Aidan2");
        }
        if (playing.get("Eilish2")) {
            Eilish.Beams(smoothedAmplitude);
            s = s.concat("Eilish2");
        }
        if (playing.get("Jana2")) {
            Jana.SpSquares.drawSquares(smoothedAmplitude);
            s = s.concat("Jana2");
        }
        g.colorMode(g.RGB);
        g.fill(255, 255, 255);
        g.stroke(255, 255, 255);
        g.textSize(24);
        g.textFont(song.getFont(1));
        g.textAlign(g.LEFT, g.TOP);
        g.text(s, 0, 0);
    }

    private void swap(String key) {
        if (playing.get(key)) {
            playing.put(key, false);
        } else {
            playing.put(key, true);
        }
    }
 
    public void movePosition(int ms) {
        
        aPlayer.skip(ms);
    }
}

