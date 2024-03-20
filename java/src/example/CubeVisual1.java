package example;

import ie.tudublin.Visual;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;


public class CubeVisual1 extends Visual
{
    Minim minim;
    AudioPlayer player;
    AudioBuffer buffer;
    public void settings()
    {
        size(800, 600, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        startMinim();
        startListening();
        //loadAudio("heroplanet.mp3");

        minim = new Minim(this);
        player = minim.loadFile("data/Creepy Nuts - Bling-Bang-Bang-Born.mp3");
        player.play();
        buffer = player.mix;

        colorMode(HSB);
    }

    /*
    public void keyPressed()
    {
        if (key == ' ')
        {
            //getAudioPlayer().cue(0);
            //getAudioPlayer().play();
            player.play();
        }
    } */

    float angle = 0;

    public void draw()
    {
        background(0);
        calculateAverageAmplitude();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        strokeWeight(5);
        noFill();
        lights();
        pushMatrix();
        //
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        translate(0, 0, -200);
        rotateX(angle);
        rotateZ(angle);       
        float boxSize = 50 + (200 * getSmoothedAmplitude()); 
        box(boxSize);   
        popMatrix();
        angle += 0.01f;
    }


}