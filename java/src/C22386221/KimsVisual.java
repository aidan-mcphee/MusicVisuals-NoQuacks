package C22386221;

import ie.tudublin.Visual;
import processing.core.PFont;

public class KimsVisual extends Visual{
    PFont font;
    song s;
    float w;
    float h;
    float x;
    float y;

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
    
    public void play(){
        s.colorMode(HSB);
        int m = millis();
        //s.background(m % 255);
        s.background(37,255,255);

        s.fill(0);
        s.rect(0, 0, w, h/5);
        s.rect(0, h, w, -h/5);

        s.textSize(128);    
        s.fill(255);
        s.textFont(font);
        s.textAlign(CENTER,CENTER);
        //s.text("Bling", w/8, h/12); 
        //s.text("Bang", w/2.9f, h/12);
        //s.text("Bang", w/1.75f, h/12); 
        s.text("Bling", w/8, h/12); 
        s.text("Bang", w/2.9f, h/12);
        s.text("Bang", w/1.75f, h/12);

    }
}