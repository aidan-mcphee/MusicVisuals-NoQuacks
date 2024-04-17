package C22386221;

import ie.tudublin.Visual;
import main.Song;
import processing.core.PGraphics;

public class MagicCircle extends Visual {
    Song s;
    float centerX, centerY, centerZ;
    int circleSize;
    float rotationX;

    public MagicCircle(PGraphics g, float x, float y, float z, int size, float rotX) {
        this.g = g;
        this.centerX = x;
        this.centerY = y;
        this.centerZ = z;
        this.circleSize = size;
        this.rotationX = rotX;
    }

    public void render() {
        g.pushMatrix();
        g.translate(centerX, centerY, centerZ);
        g.rotateX(rotationX);

        drawGlowingCircle();
        drawMagicEffects();

        g.popMatrix();
    }

    private void drawGlowingCircle() {
        g.noStroke();
        g.fill(237, 249, 255, 140); // Alpha value for desired glow intensity
        g.ellipse(0, 0, circleSize * 1.2f, circleSize * 1.2f); // Size for glow effect
        g.fill(176, 229, 255, 150);
        g.ellipse(0, 0, circleSize, circleSize);
    }

    private void drawMagicEffects() {
        int m = millis();
        
        float angleStep = 15; // Angle step for the density of effects
        float arcLength = 20; // Length of the arcs
        float arcRadius = circleSize / 2; // Radius of the arcs
    
        for (float angle = 0; angle < 360; angle += angleStep) {
            float x1 = cos(radians(angle)) * arcRadius;
            float y1 = sin(radians(angle)) * arcRadius;
            float x2 = cos(radians(angle + arcLength)) * arcRadius;
            float y2 = sin(radians(angle + arcLength)) * arcRadius;
    
            // Gradient fill color for the arcs
            int arcColor1 = color(m % 255, 240, 255);
            int arcColor2 = color(m% 255, 240, 255);
            float gradientFactor = map(angle, 0, 360, 0, 1);
            int arcColor = lerpColor(arcColor1, arcColor2, gradientFactor);
            g.stroke(arcColor);
            g.strokeWeight(3);
            g.line(x1, y1, 0, x2, y2, 200);
        }
    }
    
}
