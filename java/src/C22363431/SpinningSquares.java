package C22363431;

import ie.tudublin.Visual;
import processing.core.PGraphics;
public class SpinningSquares extends Visual{

    float aspeed;

    public SpinningSquares(PGraphics g) {
        this.g = g;
        frameRate = 60;
    }

    public void drawSquares() {
        translate(100, 100);
        aspeed = ((float)frameCount / 360) * TWO_PI;

        noFill();
        strokeWeight(2);
        stroke(50);

        for (int y = 0; y <= 300; y += 30) {
            for (int x = 0; x <= 300; x += 30) {
            float size2 = map(cos(-aspeed+x*49+y*2), -1, 1, -50, 50);
            pushMatrix();
            translate(x, y);
            rotate(aspeed);
            rectMode(CENTER);
            rect(0, 0, size2*0.7f, size2*0.7f);
            popMatrix();
            }
        }
    }
}

// Need to fix: Must make squares move and spin and be in the center
