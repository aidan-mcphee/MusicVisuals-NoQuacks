package C22386221;
import ie.tudublin.Visual;
import main.Song;
import processing.core.PGraphics;
import processing.core.PImage;

public class DancingStickman extends Visual{
    Song s;
    float x,y;
    PImage[] stickman;

    public DancingStickman(PGraphics g, float x, float y, PImage[] stickman){
        this.g = g;
        this.x = x;
        this.y = y;
        this.stickman = stickman;
    }

    public void render(){
        int index = frameCount % stickman.length;
        image(stickman[index], x, y);
    }
}
