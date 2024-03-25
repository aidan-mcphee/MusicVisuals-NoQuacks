package C22386221;

import ie.tudublin.Visual;
import processing.core.PFont;

public class song extends Visual{
    KimsVisual Kim; 

    public void settings(){
        size(1920, 1080, P3D);
    }
    
    public void setup()
    {
        //super.setup();
        colorMode(HSB);
        setFrameSize(1024);
        frameRate(30);
        
        startMinim();
        loadAudio("data/Creepy Nuts - Bling-Bang-Bang-Born.mp3");
        getAudioPlayer().play();
        PFont font = createFont("Cabazon.otf", 200);
        Kim = new KimsVisual(this, font);
    }   

    public void keyPressed(){
        if(keyCode == ' ') {
            if (getAudioPlayer().isPlaying()) {
                getAudioPlayer().pause();
            } else {
                getAudioPlayer().play();
            }
        }
        if(keyCode == '0'){
            getAudioPlayer().rewind();
        }
        }
    
    public void draw(){
        Kim.play();
    }
}
