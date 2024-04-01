package main;

import C22300773.AidansVisual;
import C22386221.KimsVisual;
import C22408466.EilishsVisual;
import ie.tudublin.Visual;
import processing.core.PFont;

public class song extends Visual{
    KimsVisual Kim; 
    AidansVisual Aidan;
    EilishsVisual Eilish;

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
        PFont calibri = createFont("calibri-regular.ttf", 100);
        //pg = createGraphics(1600, 900, P3D);

        Kim = new KimsVisual(this, font);
        
        Aidan = new AidansVisual(this.g, calibri);
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

    private void playMusicVideo() {
        //Aidan.SpinningSphere(width, height, 1.0f);
        String[] vars = {"Width", "height", "Amplitude"};
        String[] vals = {Integer.toString(width), Integer.toString(height), Float.toString(getSmoothedAmplitude())};
        Kim.play();
        //Aidan.printVars(vars, vals);
        Aidan.SpinningSphere(100, 100, 50);
        Aidan.printVars(vars, vals);
    }
    
    public void draw(){
        background(0);
        playMusicVideo();
    }
}
