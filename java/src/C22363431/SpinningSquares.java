package C22363431;

import ie.tudublin.Visual;
import processing.core.PGraphics;
public class SpinningSquares extends Visual{

    float aspeed;
    boolean peak;
    float currentHue;

    public SpinningSquares(PGraphics g) {
        this.width = g.width;
        this.height = g.height;
        this.g = g;
        frameRate = 60;
        currentHue = 0; 
    }
    

    public void drawSquares(float amp) {
        colorMode(HSB);
        rectMode(CORNER);
        aspeed = (100*amp / 360) * TWO_PI;
 
        noStroke();
        //System.out.println(aspeed);
        for (int y = 0; y <= height; y += 200) {
            for (int x = 0; x <= width; x += 200) {
                fill(currentHue, 360, 360);
                if (aspeed > 0.9f && !peak) {
                    currentHue = (currentHue + 30) % 255;
                    peak = true;
                }
                else if (aspeed < 0.3f) {
                    peak = false;
                }

            float size2 = map(cos(-aspeed+x*49+y*2), -1, 1, -50, 50);
            pushMatrix();
            translate(x, y);
            rotate(aspeed);
            rectMode(CENTER);
            rect(0, 0, size2*3f, size2*3f);
            popMatrix();
            }
        }
    }
}

// Need to fix: Must make squares move and spin and be in the center
