package main;

import C22300773.AidansVisual;
import C22300773.subtitles.SubtitleReader;
import C22386221.KimsVisual;
import C22408466.EilishsVisual;
import ie.tudublin.Visual;
import processing.core.PFont;

public class Song extends Visual{
    KimsVisual Kim; 
    AidansVisual Aidan;
    EilishsVisual Eilish;
    SubtitleReader sr;
    Controller c;

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
        PFont font = createFont("fonts/Cabazon.otf", 200);
        PFont calibri = createFont("fonts/calibri-regular.ttf", 100);
        //pg = createGraphics(1600, 900, P3D);
        c = new Controller(this);

        Kim = new KimsVisual(this.g, font);
        Eilish = new EilishsVisual(this.g);
        Aidan = new AidansVisual(this.g, calibri);
        sr = new SubtitleReader("java/data/subtitles/subs.srt");
    }

    public void keyPressed() {
        c.handleKeyPress(keyCode);
    }

    private void playMusicVideo() {
        //Aidan.SpinningSphere(width, height, 1.0f);
        String[] vars = {"Width", "height", "Amplitude"};
        String[] vals = {Integer.toString(width), Integer.toString(height), Float.toString(getSmoothedAmplitude())};
        //Kim.play();
        //Subtitle sub = sr.getCurrentSubtitle(getAudioPlayer().position() / 1000);
        //yana.drawJanasVisual();
        /* 
        if (sub != null) {
            St  ring text = sub.getText();
            textAlign(CENTER, CENTER);
            textSize(64);
            text(text, width/2, height/2);
        }
        */
        //Eilish.setMouseX(mouseX);
        //Eilish.play();
        Aidan.printVars(vars, vals);
        //Aidan.SpinningSphere(100, 100, 50);
        //Aidan.printVars(vars, vals);
    }
    
    public void draw() {
        calculateAverageAmplitude();
        background(0);
        playMusicVideo();
    }
}
