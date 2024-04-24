package C22300773;

import C22300773.particlesystem.ParticleSystem;
import ie.tudublin.Visual;
import main.Song;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PVector;

public class AidansVisual extends Visual{

    Song s;
    float y;
    PFont font;
    SpinningSphere sphere;
    ParticleSystem ps;

    public AidansVisual(PGraphics g, PFont font) {
        this.g = g;
        this.font = font;
        height = g.height;
        width = g.width;
        sphere = new SpinningSphere(g);
        ps = new ParticleSystem(new PVector(width / 2, height / 2), g, height / 4);
        for (int i = 0; i < 40; i++) {
            ps.addParticle();
        }
    }

    public void printVars(String[] names, String[] variables) {
        assert (names.length == variables.length);
        colorMode(RGB);
        float fontSize = 30;
        float biggestWord = 0;
        textFont(font);
        textSize(fontSize);
        textAlign(LEFT, TOP);
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
    }

    public void render(float smoothAmp) {
        sphere.drawSphere(width / 2, height / 2, smoothAmp, width / 2, height / 2, -640);
        ps.run(smoothAmp);
    }
}
