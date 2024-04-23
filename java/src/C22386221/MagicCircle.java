package C22386221;

import ie.tudublin.Visual;
import main.Song;
import processing.core.PGraphics;

public class MagicCircle extends Visual {
    Song s;
    float centerX, centerY, centerZ;
    int circleSize;
    float rotationX;
    float smoothAmp;
    int slowedTime;

    public MagicCircle(PGraphics g, float x, float y, float z, int size, float rotX) {
        this.g = g;
        this.centerX = x;
        this.centerY = y;
        this.centerZ = z;
        this.circleSize = size;
        this.rotationX = rotX;
    }

    public void setAmplitude(float amp) {
        smoothAmp = amp;
    }

    public void render() {
        g.pushMatrix();
        g.translate(centerX, centerY, centerZ);
        g.rotateX(rotationX);
        drawGlowingCircle();
        g.popMatrix();
    }

    private void drawGlowingCircle() {
        g.noStroke();

        slowedTime = millis()/5;
        g.fill(bouncingModulus((int) random(slowedTime - 40, slowedTime + 40), 255), 171, 252);
        g.ellipse(0, 0, circleSize * 1.2f, circleSize * 1.2f);
        g.fill(bouncingModulus((int) random(slowedTime - 40, slowedTime + 40), 255), 3, 252);
        g.ellipse(0, 0, circleSize * 1.1f, circleSize * 1.1f);
        g.fill(bouncingModulus((int)random(slowedTime - 40, slowedTime + 40), 255), 240, 255);
        g.ellipse(0, 0, circleSize, circleSize);

        drawMagicEffects();

        g.ellipse(0, 0, circleSize * 0.9f, circleSize * 0.9f);
        g.ellipse(0, 0, circleSize * 0.8f, circleSize * 0.8f);

        g.fill(bouncingModulus((int) random(slowedTime - 40, slowedTime + 40), 255), 171, 252);
        g.ellipse(0, 0, circleSize * 0.6f, circleSize * 0.6f);
        g.fill(bouncingModulus((int) random(slowedTime - 40, slowedTime + 40), 255), 3, 252);
        g.ellipse(0, 0, circleSize * 0.5f, circleSize * 0.5f);

        g.fill(bouncingModulus((int) random(slowedTime - 40, slowedTime + 40), 255), 171, 252);
        g.ellipse(0, 0, circleSize * 0.3f, circleSize * 0.3f);
        g.fill(bouncingModulus((int) random(slowedTime - 40, slowedTime + 40), 255), 3, 252);
        g.ellipse(0, 0, circleSize * 0.2f, circleSize * 0.2f);


    }

    private void drawMagicEffects() {
    
        float angleStep = 15; 
        float arcRadius = circleSize / 2;
    
        float maxAmplitudeHeight = 500; 
    
        for (float angle = 0; angle < 360; angle += angleStep) {
            float x1 = cos(radians(angle)) * arcRadius;
            float y1 = sin(radians(angle)) * arcRadius;
            float x2 = x1;
            float y2 = y1; 
    
            float z2 = map(smoothAmp, 0, 1, 0, maxAmplitudeHeight);

            int arcColor1 = color(millis() % 255, 240, 255);
            int arcColor2 = color(millis() % 255, 240, 255);
            float gradientFactor = map(angle, 0, 360, 0, 1);
            int arcColor = lerpColor(arcColor1, arcColor2, gradientFactor);
            g.stroke(arcColor);
            g.strokeWeight(5);
            g.line(x1, y1, 0, x2, y2, z2);
        }
    }

    private int bouncingModulus(int x, int m){
        if (x/m % 2 == 0) {
            return x % m;
        } else{
            return m - (x % m);
        }
    }
     
    
}
