package C22386221;

import ie.tudublin.Visual;
import processing.core.PFont;
import processing.core.PGraphics;

public class SlidingText extends Visual{
    String text;
    PFont font;
    float x,y;
    float speed;
    float end;
    float jitter, angle;
    float startX, startY;
    
    public SlidingText(PGraphics g,String text, PFont font, float x, float y, float speed, float end){
        this.g = g;
        this.text = text;
        this.font = font;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.end = end;
        this.startX = x;
        this.startY = y;
    }

    public void SlideLeft(){
        textSize(128);    
        fill(255);
        textFont(font);
        textAlign(LEFT,CENTER);

        text(text,x,y);
        //Checks if x position overlaps the end location and stops, if not move left
        if(x - end < speed){
            x = end;
        }else{
            x -= speed;
        }

        if (x == end) {
            x = startX;
        }
    }

    public void SlideRight(){
        textSize(128);    
        fill(255);
        textFont(font);
        textAlign(RIGHT,CENTER);

        text(text,x,y);
        //Checks if x position overlaps the end location and stops, if not move right
        if(x + speed > end){
            x = end;
        }else{
            x += speed;
        }
        
        if (x == end) {
            x = startX;
        }
    }
}
