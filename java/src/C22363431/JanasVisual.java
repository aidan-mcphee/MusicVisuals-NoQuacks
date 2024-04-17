package C22363431;

import ie.tudublin.Visual;
import processing.core.PGraphics;

public class JanasVisual extends Visual{

    int mode = 0;
    int cols, rows;
    int scale = 40;
    int h;
    int w;

    float flying = 0;
    float angle = 0;
    float [][] terrain;
    

    public JanasVisual(PGraphics g, float size) {
        this.g = g;
        height = g.height;
        width = g.width;
        w = (int)(width*size*2);
        h = (int)(height*size*2);
        setupTerrain();
    }


    public void setupTerrain() {

        cols = w / scale;
        rows = h / scale;
        
        terrain = new float[cols][rows];
        
    }


    public void drawTerrain(float amp) {
        colorMode(RGB);

        stroke(255, 250, 0);
        strokeWeight(1);
        noFill();
        pushMatrix();
        translate(width/2, height/2); //Object of affection position
        rotateX(PI/3);
        translate(-w/2, -h/2); // Camera 
        flying -= 0.05f;


        float yoffset = flying;
        for (int x = 0; x < rows; x++) {
            float xoffset = 0;
            for (int y = 0; y < cols; y++) {
                terrain[y][x] = map(noise(xoffset,yoffset), 0, 1, -500*amp, 500*amp);
                xoffset += 0.2f;
            }
            yoffset += 0.2f;
        }

        for (int y = 0; y < rows-1; y++) {
            beginShape(TRIANGLE_STRIP);
            for (int x = 0; x < cols; x++) {
                vertex(x*scale,y*scale, terrain[x][y]);
                vertex(x*scale,(y+1)*scale, terrain[x][y+1]);
            }
            endShape();
        }

        popMatrix();
    }
}