package C22386221;
import ie.tudublin.Visual;
import main.Song;
import processing.core.PGraphics;
import processing.core.PImage;

public class DancingStickman extends Visual{
    Song s;
    float x,y;
    PImage[] stickman;
    int frameCount, frameDelay, frameIndex;

    public DancingStickman(PGraphics g, float x, float y, PImage[] stickman){
        this.g = g;
        this.x = x;
        this.y = y;
        this.stickman = stickman;
        this.frameCount = 0;
        this.frameDelay = 3;
        this.frameIndex = 0;
    }

    public void render(){
        int index = frameIndex % stickman.length;
        image(stickman[index], x, y);

        if (frameCount % frameDelay == 0) {
            frameIndex++;
        }
        frameCount++;
    }
}
