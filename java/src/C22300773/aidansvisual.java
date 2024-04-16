package C22300773;

import ie.tudublin.Visual;
import main.Song;
import processing.core.PFont;
import processing.core.PGraphics;


public class AidansVisual extends Visual{

    int sphereHue = 0;
    float currangle = 0;
    Song s;
    float y;
    PFont font;

    public AidansVisual(PGraphics g, PFont font) {
        this.g = g;
        this.font = font;
        height = g.height;
        width = g.width;
    }

    public void SpinningSphere(float w, float h, float amplitude) {
        pushMatrix();
        translate(w*0.5f, h*0.35f, -640f);
        if (frameCount % 60 == 0) {
            sphereHue = (sphereHue + 50) % 255;
        }
        noFill();
        stroke(sphereHue, 255, 255);
        float r = map(amplitude, 0, 1, h/5, h/2);
        float angle = TWO_PI * 0.1f * amplitude;
        currangle += angle;
        rotateZ(currangle);
        sphere(r);
        popMatrix();
    }
    public void printVars(String[] names, String[] variables) {
        assert (names.length == variables.length);
        colorMode(RGB);
        float fontSize = 30;
        float biggestWord = 0;
        textFont(font);
        textSize(fontSize);
        y = 0;
        for (String var : variables) {
            if (textWidth(var) > biggestWord) {
                biggestWord = textWidth(var);
            }
        }

        for (int i = 0; i < variables.length; i++) {
            if (textWidth(names[i] + ": " + variables[i]) > biggestWord) {
                biggestWord = textWidth(names[i] + ": " + variables[i]);
            }
        }
        fill(0, 190);
        rect(0, 0, biggestWord, fontSize * variables.length);
        fill(255, 0, 0, 255);

        //loop through the variables and print them
        for (int i = 0; i < variables.length; i++) {
            textAlign(LEFT, TOP);
            text(names[i] + ": " + variables[i], 0, y);
            y += fontSize;
        }
        for (String var : variables) {
            textAlign(LEFT, TOP);
            text(var, 0, y);
            y += fontSize;
        }
    }
}