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
        y = random(-200, -100);
        w = g.width/5;
        h = g.height/2;
        fallspeed = random(4, 10);
        rainLength = random(g.width, 20);

    }

    public void fall() {
        y = y + fallspeed;

        if (y > height) 
        {
            y = random(-200, -100);
        }
    }

    public void render() {
        colorMode(RGB);

        stroke(51, 0, 51);
        line(x, y, x, y + rainLength);

    }

    
}