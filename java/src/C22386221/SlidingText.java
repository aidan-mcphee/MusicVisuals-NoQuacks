package C22386221;

import ie.tudublin.Visual;
import main.song;

public class SlidingText extends Visual{
    song s;
    String text;
    float x,y;
    float speed;
    float end;
    
    public SlidingText(song s,String text, float x, float y, float speed, float end){
        this.s = s;
        this.text = text;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.end = end;
    }

    public void Render(){
        s.textSize(128);    
        s.fill(255);
        s.textAlign(LEFT,CENTER);

        s.text(text,x,y);
        if(x - end < speed){
            x = end;
        }else{
            x -= speed;
        }
        
    }
}

//TODO pass in speed variable (float), *slowly accelerate/decelerate?
//TODO change the x from the start to the end
/*TODO if the x is in front of the end reduce the current x by speed, otherwise
increase the x */