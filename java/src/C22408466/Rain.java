package C22408466;

import ie.tudublin.Visual;
import processing.core.PGraphics;

public class Rain extends Visual
{

    float x, y;
    float fallspeed;
    float smoothAmp;
    float rainLength;
    float w, h;

    public Rain(PGraphics g) {
        this.g = g;
        x = random(g.width);
        y = random(-20, -10);
        fallspeed = 20;
        rainLength = random(20, 40);

    }

    public void setAmplitude(float amp) {
        smoothAmp = amp;
    }

    public void fall() {
        float maxAmpFall = -h;
        fallspeed = map(smoothAmp, 0, 1, 0, maxAmpFall);
        y = y + fallspeed;

        if (y > height) 
        {
            y = random(-200, -h);
        }
    }

    public void render() {
        colorMode(RGB);

        stroke(51, 0, 51);
        line(x, y, x, y + rainLength);

        //System.out.println("height " + h);
        //System.out.println("width  " + w);
    }

    
}