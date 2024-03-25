package C22386221;

import ie.tudublin.Visual;
import processing.core.PFont;
import processing.core.PGraphics;

public class KimsVisual extends Visual{
    PFont font;
    float w;
    float h;
    song s;

    public KimsVisual(song s){
        this.s = s;
    }
    public void setup() {
        this.w = s.width;
        this.h = s.height;
    }

    public void setFont(PFont font) {
        this.font = font;
    }
    
    public void play(PGraphics pg){
        pg.background(37,255,255);

        pg.textSize(128);
        pg.fill(0);
        pg.textFont(font);
        pg.textAlign(CENTER,CENTER);
        pg.text("Bling", this.w/2, this.h/2); 

    }
}