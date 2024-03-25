package C22386221;

import ie.tudublin.Visual;
import processing.core.PFont;
import processing.core.PGraphics;

public class song extends Visual{
    PGraphics pg;
    KimsVisual Kim; 

    public void settings(){
        size(1600, 900, P3D);
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
        pg = createGraphics(1600, 900, P3D);

        Kim = new KimsVisual(this);
        Kim.setFont(font);
        Kim.setup();
        
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
        pg.beginDraw();
        pg.background(0);
        Kim.play(pg);
        pg.endDraw();
        image(pg, 0, 0);
    }
}
