package C22386221;

import ie.tudublin.Visual;
import main.song;
import processing.core.PFont;

public class SlidingText extends Visual{
    song s;
    String text;
    PFont font;
    float x,y;
    float speed;
    float end;
    
    public SlidingText(song s,String text, PFont font, float x, float y, float speed, float end){
        this.s = s;
        this.text = text;
        this.font = font;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.end = end;
    }

    public void SlideLeft(){
        s.textSize(128);    
        s.fill(255);
        s.textFont(font);
        s.textAlign(LEFT,CENTER);

        s.text(text,x,y);
        //Checks if x position overlaps the end location and stops, if not move left
        if(x - end < speed){
            x = end;
        }else{
            x -= speed;
        }
    }

    public void SlideRight(){
        s.textSize(128);    
        s.fill(255);
        s.textFont(font);
        s.textAlign(RIGHT,CENTER);

        s.text(text,x,y);
        //Checks if x position overlaps the end location and stops, if not move right
        if(x + speed > end){
            x = end;
        }else{
            x += speed;
        }
    }

}

//TODO pass in speed variable (float), *slowly accelerate/decelerate?
/*TODO if the x is in front of the end reduce the current x by speed, otherwise
increase the x */