package C22408466;

import ie.tudublin.Visual;
import processing.core.PGraphics;

public class Rain extends Visual
{

    float x, y;
    float fallspeed;
    float rainLength;
    float w, h;

    public Rain(PGraphics g) {
        this.g = g;
        x = random(g.width);
        y = random(-20, -10);
        w = g.width/10;
        h = g.height;
        fallspeed = random(4, 10);
        rainLength = random(w, h);

    }

    public void fall() {
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