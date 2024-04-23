package C22300773;

import processing.core.PGraphics;
import ie.tudublin.Visual;

public class SpinningSphere extends Visual {
    
    int sphereHue = 0;
    float currangle = 0;

    public SpinningSphere(PGraphics g) {
        this.g = g;
    }

    public void drawSphere(float w, float h, float amplitude, float x, float y, float z) {
        pushMatrix();
        translate(x, y, z);
        stroke(sphereHue, 255, 255);
        if (frameCount % 60 == 0) {
            sphereHue = (sphereHue + 50) % 255;
        }
        colorMode(RGB);
        fill(33, 137, 215);
        float r = map(amplitude, 0, 1, h/5, h/2);
        float angle = TWO_PI * 0.1f * amplitude;
        currangle += angle;
        rotateZ(currangle);
        sphere(r);
        popMatrix();
        //pointLight(255, 0, 0, x, y, z);
    }
}
