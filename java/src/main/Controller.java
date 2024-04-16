package main;

import ddf.minim.AudioPlayer;

public class Controller {
    private Song song;

    public Controller(Song song){
        this.song = song;
        
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
                movePosition(-500);
                break;
            case Song.RIGHT:
                movePosition(500);
                break;    
            default:
                System.out.println("Unkown key: " + keyCode);
                break;
        }
    }

    public void movePosition(int ms) {
        AudioPlayer aPlayer = song.getAudioPlayer();
        aPlayer.skip(ms);
    }
}

