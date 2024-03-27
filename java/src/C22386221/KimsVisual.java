package C22386221;

import ie.tudublin.Visual;
import main.song;
import processing.core.PFont;

public class KimsVisual extends Visual{
    PFont font;
    song s;
    float w;
    float h;
    float x;
    float x2;
    float x3;
    int fontSize = 128;
    
    public KimsVisual(song s, PFont font){
        this.s = s;
        this.w = s.width;
        this.h = s.height;
        this.font = font;
        x = w;
        x2 = w;
        x3 = w;
    }
    
    public void play(){
        int m = millis();
        s.colorMode(HSB);
        //s.background(m % 255);
        s.background(37,255,255);

        //black bars
        s.fill(0);
        s.rect(0, 0, w, h/5);
        s.rect(0, h, w, -h/5);
        
        if (m >= 1000){
            UpperTextAnimation();
        }
        
        //System.out.println(s.textWidth("Bling"));
    }
    
    public void UpperTextAnimation(){
        float y = h/12;

        s.textSize(fontSize);    
        s.fill(255);
        s.textFont(font);
        s.textAlign(LEFT,CENTER);

        s.text("Bling", x, y);   
        if(x - 0 < 100){
            x = 0;
        }else{
            x-=100;
        }
        
        float offset1 = s.textWidth("Bling");
        s.text("Bang", x2, y);   
        if(x2 - offset1 < 100){
            x2 = offset1;
        }else{
            x2-=100;
        }
        
        float offset2 = s.textWidth("Bang");
        s.text("Bang", x3, y);   
        if(x3 - (offset1 + offset2) < 100){
            x3 = offset1 + offset2;
        }else{
            x3-=100;
        }
        
    }
}