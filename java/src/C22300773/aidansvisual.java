package C22300773;

import processing.core.PApplet;

public class aidansvisual extends PApplet{

    int sphereHue = 0;
    float currangle = 0;

    public void SpinningSphere(float w, float h, PApplet p, float amplitude) {
        p.background(0);
        p.pushMatrix();
        p.translate(w*0.5f, h*0.35f, -640f);
        if (p.frameCount % 60 == 0) {
            sphereHue = (sphereHue + 50) % 255;
        }
        p.noFill();
        p.stroke(sphereHue, 255, 255);
        float r = map(amplitude, 0, 1, h/5, h/2);
        float angle = TWO_PI * 0.1f * amplitude;
        currangle += angle;
        p.rotateZ(currangle);
        p.sphere(r);
        p.popMatrix();
    }
}