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
    SlidingText bling;
    
    public KimsVisual(song s, PFont font){
        this.s = s;
        this.w = s.width;
        this.h = s.height;
        this.font = font;
        x = w;
        x2 = w;
        x3 = w;
        bling = new SlidingText(s,"Test", w, h/12, 10, 0);
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
        
        bling.Render();
        //System.out.println(s.textWidth("Bling"));
    }
    
    public void UpperTextAnimation(){
        float y = h/12;

        s.textSize(fontSize);    
        s.fill(255);
        s.textFont(font);
        s.textAlign(LEFT,CENTER);

        s.text("Bling", x, y);
        //Checks if x position overlaps with screen edge and stops, if not move left   
        if(x - 0 < 200){
            x = 0;
        }else{
            x-=200;
        }
        
        float offset1 = s.textWidth("Bling");
        s.text("Bang", x2, y);
        //Checks if x position overlaps with first word (offset) and stops, if not move left     
        if(x2 - offset1 < 200){
            x2 = offset1;
        }else{
            x2-=200;
        }
        
        float offset2 = s.textWidth("Bang");
        s.text("Bang", x3, y);
        //Checks if x position overlaps with first 2 words (offset) and stops, if not move left   
        if(x3 - (offset1 + offset2) < 200){
            x3 = offset1 + offset2;
        }else{
            x3-=200;
        }
        
    }
}