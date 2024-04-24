package C22408466;

import ie.tudublin.Visual;
import processing.core.PGraphics;

public class Rain extends Visual
{

    float x, y;
    float fallspeed;
    float smoothAmp;
    float rainLength;
    float sy;
    float h;

    public Rain(PGraphics g) {
        this.g = g;
        x = random(g.width);
        y = random(5, -h);
        fallspeed = random(15, 30);
        rainLength = random(g.width / 40, g.height / 20);
        this.height = g.height;
    }

    public void setAmplitude(float amp) {
        smoothAmp = amp;
    }

    public void fall() {

        y = y + (fallspeed * (smoothAmp * 3));
        //float sy = y + (fallspeed * smoothAmp);

        if (y > height) 
        {
            y = random(10, -h);
        }
    }

    public void render() {

        colorMode(RGB);

        stroke(186, 3, 252);
        strokeWeight(g.width / 100);
        line(x, y, x, y + rainLength);

    }

    /*public void renderThin() {

        colorMode(RGB);

        stroke(186, 3, 252);
        strokeWeight(g.width / 400);
        line(x, sy, x, sy + rainLength);

    }*/

    
}