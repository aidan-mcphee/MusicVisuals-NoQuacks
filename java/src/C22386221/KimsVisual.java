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
    DancingStickman stickman;
    PImage[] stickmanImages;
    MagicCircle magicCircle;
    
    public KimsVisual(PGraphics g, PFont font, PImage[] stickmanImg){
        this.g = g;
        this.w = g.width;
        this.h = g.height;
        this.font = font;
        this.stickmanImages = stickmanImg;

        x = w;
        x2 = w;
        x3 = w;

        bling = new SlidingText(this.g,"Bling", font, x, h/12, 200, 0);
        bang = new SlidingText(this.g, "Bang", font, x2, h/12, 200, 394);
        bang2 = new SlidingText(this.g, "Bang", font, x3, h/12, 200, (394 + 389));

        rBling = new SlidingText(this.g,"Bling", font, 0, h - h/9, 200, x - (394 + 389));
        rBang = new SlidingText(this.g, "Bang", font, 0, h - h/9, 200, x - 394);
        rBang2 = new SlidingText(this.g,"Bang", font, 0, h - h/9, 200, x);

        stickman = new DancingStickman(this.g, w/8,h/8, stickmanImg);
        magicCircle = new MagicCircle(this.g, w / 2, h / 2 + 50, -100, 300, PI / 3);
    }
    
    public void play(){
        int m = millis();
        colorMode(RGB);
        //background(m % 255);
        background(255, 204, 0);

        //black bars
        fill(0);
        rect(0, 0, w, h/5);
        rect(0, h, w, -h/5);
        
        if (m >= 1000){
            bling.SlideLeft();
            bang.SlideLeft();
            bang2.SlideLeft();

            rBling.SlideRight();
            rBang.SlideRight();
            rBang2.SlideRight();
        }

        magicCircle.render();

        //stickman.render();
        
        //System.out.println(textWidth("Bang"));
    }
}