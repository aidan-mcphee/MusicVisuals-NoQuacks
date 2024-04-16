package C22386221;
import ie.tudublin.Visual;
import main.Song;
import processing.core.PGraphics;
import processing.core.PImage;

public class DancingStickman extends Visual{
    Song s;
    float x,y;
    PImage[] stickman = new PImage[32];

    public DancingStickman(PGraphics g, float x, float y){
        this.g = g;
        this.x = x;
        this.y = y;
        for(int i = 0; i < stickman.length; i++){
            String filename = "Stickman_dance/frame" + i + ".png";
            //stickman[i] = loadImage(filename)
        }
    }

    public void render(){
        int index = frameCount % stickman.length; // Loop through the images
        //image(stickman[index], x, y);
    }
}
