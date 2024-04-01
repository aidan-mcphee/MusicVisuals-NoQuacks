package C22408466;

import ie.tudublin.Visual;
import main.song;
import processing.core.PFont;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;

public class EilishsVisual extends Visual
{
    Star[] stars = new Star[1000];
    float starSpeed;

    public void settings() {
        size(800, 800, P3D);
        
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
        }
    }

    void draw() {

        starSpeed = map(mouseX, 0, width, 0, 50);
        background(0);
        translate(width / 2, height / 2);

        for (int i = 0; i < stars.length; i++) {
            stars[i].update();
            stars[i].show();
        }
    }
}