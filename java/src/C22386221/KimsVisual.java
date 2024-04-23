package C22386221;

import ie.tudublin.Visual;
import main.Song;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PImage;

public class KimsVisual extends Visual{
    PFont font;
    Song s;
    float w;
    float h;
    float x;
    float x2;
    float x3;
    int fontSize = 128;
    SlidingText bling, bang, bang2;
    SlidingText rBling, rBang, rBang2;
    DancingStickman stickman, stickman2, stickmanBig;
    PImage[] stickmanImages, stickmanImages2;
    MagicCircle magicCircle, magicCircle2;
    int numSquares;
    int squareSize;

    public KimsVisual(PGraphics g, PFont font, PImage[] stickmanImg, PImage[] stickmanImg2){
        this.g = g;
        this.w = g.width;
        this.h = g.height;
        this.font = font;
        this.stickmanImages = stickmanImg;
        this.stickmanImages2 = stickmanImg2;


        x = w;
        x2 = w;
        x3 = w;
        numSquares = 5;
        squareSize = (int) max(w, h) / numSquares;

        bling = new SlidingText(this.g,"Bling", font, x, h/12, 200, 0);
        bang = new SlidingText(this.g, "Bang", font, x2, h/12, 200, 394);
        bang2 = new SlidingText(this.g, "Bang", font, x3, h/12, 200, (394 + 389));

        rBling = new SlidingText(this.g,"Bling", font, 0, h - h/9, 200, x - (394 + 389));
        rBang = new SlidingText(this.g, "Bang", font, 0, h - h/9, 200, x - 394);
        rBang2 = new SlidingText(this.g,"Bang", font, 0, h - h/9, 200, x);

        stickman = new DancingStickman(this.g, w/2 + 50,h/2.5f, stickmanImg);
        stickman2 = new DancingStickman(this.g, w/4 + 50,h/2.5f, stickmanImg);
        stickmanBig = new DancingStickman(this.g, w/3 + 50,h/5, stickmanImg2);
        magicCircle = new MagicCircle(this.g, w / 2, h/2  + 10, -100, 800, PI / 3);
    }
    
    public void play(float smoothAmp){
        colorMode(RGB);
        background(0);

        noStroke();
        pushMatrix();
        translate(w/2, h/2, -600);
        translate(-numSquares * squareSize / 2, -numSquares * squareSize / 2);
        for (int i = 0; i < numSquares; i++) {
            for (int j = 0; j < numSquares; j++) {
                
                if ((i + j) % 2 == 0) {
                    fill(0);
                } else {
                    if (smoothAmp > 0.4f) {
                        fill(100, 166, 217);
                    } else{
                        fill(255, 204, 0);
                    }
                }
                rect(j * squareSize, i * squareSize, squareSize, squareSize);
            }
          }
        popMatrix();
        
        if (smoothAmp > 0.3f){
            bling.SlideLeft();
            bang.SlideLeft();
            bang2.SlideLeft();

            rBling.SlideRight();
            rBang.SlideRight();
            rBang2.SlideRight();
        }

        magicCircle.setAmplitude(smoothAmp);
        magicCircle.render();

        stickman.render();
        stickman2.render();
        stickmanBig.render();
        
    }
}