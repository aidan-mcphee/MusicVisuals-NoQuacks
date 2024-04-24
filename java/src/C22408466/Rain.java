package C22408466;

import ie.tudublin.Visual;
import processing.core.PGraphics;

public class Rain extends Visual
{

    float x, y;
    float fallspeed;
    float smoothAmp;
    float rainLength;
    float size;

    public Rain(PGraphics g) {
        this.g = g;
        x = random(g.width);
        y = random(-g.height, 5);
        this.height = g.height;
        fallspeed = random(15, 30);
        rainLength = random(g.width / 40, g.height / 5);
        size = random(5, 30);
    }

    public void setAmplitude(float amp) {
        smoothAmp = amp;
    }

    public void fall() {

        y = y + (fallspeed * (smoothAmp * 3));

        if (y > height) 
        {
            y = random(10, -g.height);
        }
    }

    public void render() {

        colorMode(RGB);

        // outer layer
        stroke(254, 173, 255);
        strokeWeight(size);
        line(x, y, x, y + rainLength);

        // middle layer
        stroke(214, 102, 255);
        strokeWeight(size / 1.5f);
        line(x, y, x, y + rainLength);

        // inner layer
        stroke(89, 2, 98);
        strokeWeight(size / 4f);
        line(x, y, x, y + rainLength);


    }
    
}