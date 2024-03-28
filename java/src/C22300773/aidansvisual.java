package C22300773;

import ie.tudublin.Visual;
import main.song;
import processing.core.PFont;


public class AidansVisual extends Visual {

    int sphereHue = 0;
    float currangle = 0;
    song s;
    float y;
    PFont font;

    public AidansVisual(song s, PFont font) {
        this.s = s;
        this.font = font;
    }

    public void SpinningSphere(float w, float h, float amplitude) {
        s.pushMatrix();
        s.translate(w*0.5f, h*0.35f, -640f);
        if (s.frameCount % 60 == 0) {
            sphereHue = (sphereHue + 50) % 255;
        }
        s.noFill();
        s.stroke(sphereHue, 255, 255);
        float r = map(amplitude, 0, 1, h/5, h/2);
        float angle = TWO_PI * 0.1f * amplitude;
        currangle += angle;
        s.rotateZ(currangle);
        s.sphere(r);
        s.popMatrix();
    }

    public void printVars(String[] names, String[] variables) {
        assert (names.length == variables.length);
        s.colorMode(RGB);
        float fontSize = s.height/30;
        float biggestWord = 0;
        s.textFont(font);
        s.textSize(fontSize);
        y = 0;
        /* 
        for (String var : variables) {
            if (s.textWidth(var) > biggestWord) {
                biggestWord = s.textWidth(var);
            }
        }
        */

        for (int i = 0; i < variables.length; i++) {
            if (s.textWidth(names[i] + ": " + variables[i]) > biggestWord) {
                biggestWord = s.textWidth(names[i] + ": " + variables[i]);
            }
        }
        s.fill(0, 190);
        s.rect(0, 0, biggestWord, fontSize * variables.length);
        s.fill(255, 0, 0, 255);

        //loop through the variables and print them
        for (int i = 0; i < variables.length; i++) {
            s.textAlign(LEFT, TOP);
            s.text(names[i] + ": " + variables[i], 0, y);
            y += fontSize;
        }

        /* 
        for (String var : variables) {
            s.textAlign(LEFT, TOP);
            s.text(var, 0, y);
            y += fontSize;
        }
        */
    }
}