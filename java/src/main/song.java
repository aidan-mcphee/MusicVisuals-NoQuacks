package main;

import C22300773.AidansVisual;
import C22300773.subtitles.SubtitleReader;
import C22386221.KimsVisual;
import C22408466.EilishsVisual;
import ie.tudublin.Visual;
import processing.core.PFont;
import C22300773.subtitles.Subtitle;
import processing.core.PImage;

public class Song extends Visual{
    KimsVisual Kim; 
    AidansVisual Aidan;
    EilishsVisual Eilish;
    SubtitleReader sr;
    Controller c;
    PImage[] stickman = new PImage[32];

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

        for(int i = 0; i < stickman.length; i++){
            String filename = "Stickman_dance/frame" + i + ".png";
            stickman[i] = loadImage(filename);
        }

        c = new Controller(this);

        Kim = new KimsVisual(this.g, font, stickman);
        Eilish = new EilishsVisual(this.g);
        Aidan = new AidansVisual(this.g, calibri);
        sr = new SubtitleReader("java/data/subtitles/subs.srt");
    }

    public void keyPressed() {
        c.handleKeyPress(keyCode);
    }

    private void playMusicVideo() {
        //Aidan.SpinningSphere(width, height, 1.0f);
        //String[] vars = {"Width", "height", "Amplitude"};
        //String[] vals = {Integer.toString(width), Integer.toString(height), Float.toString(getSmoothedAmplitude())};
        Kim.play();
        Subtitle sub = sr.getCurrentSubtitle(getAudioPlayer().position() / 1000);

        if (sub != null) {
            String text = sub.getText();
            textAlign(CENTER, CENTER);
            textSize(64);
            text(text, width/2, height/2);
        }

        //Eilish.setMouseX(mouseX);
        //Eilish.play();
        //Aidan.printVars(vars, vals);
        //Aidan.SpinningSphere(100, 100, 50);
        //Aidan.printVars(vars, vals);
    }
    
    public void draw() {
        background(0);
        playMusicVideo();
    }
}
