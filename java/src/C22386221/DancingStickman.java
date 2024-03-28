package C22386221;
import ie.tudublin.Visual;
import main.song;
import processing.core.PImage;

public class DancingStickman extends Visual{
    song s;
    float x,y;
    PImage[] stickman = new PImage[32];

    public DancingStickman(song s, float x, float y){
        this.s = s;
        this.x = x;
        this.y = y;
        for(int i = 0; i < stickman.length; i++){
            String filename = "Stickman_dance/frame" + i + ".png";
            stickman[i] = s.loadImage(filename);
        }
    }

    public void render(){
        int index = s.frameCount % stickman.length; // Loop through the images
        s.image(stickman[index], x, y);
    }
}
