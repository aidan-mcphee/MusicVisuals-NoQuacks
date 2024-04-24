package C22363431;

import ie.tudublin.Visual;
import processing.core.PGraphics;

public class DiscoTiles extends Visual {
    int h, w;
    int cols, rows;
    float[][] tiles;
    float currentHue;
    boolean peak;

    public DiscoTiles(PGraphics g, float size) {
        this.width = g.width;
        this.height = g.height;
        this.g = g;
        w = (int)(width*size*2);
        h = (int)(height*size*2);
        setupTiles();
    }

    public void setupTiles() {

        cols = w / 400;
        rows = h / 400;
        
        tiles = new float[cols][rows];

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                tiles[x][y] = random(50);  // Random hue from 0 to 360
            }
        }
    }

    public void drawTiles(float amp) {
        colorMode(HSB);

        pushMatrix();
        for (int x = 0; x < cols; x++) {
            for(int y = 0; y < rows; y++) {
                noStroke();
                fill(tiles[x][y]*amp, 200, 200);  
                rect(x*(width/cols), y*(height/rows),(width/cols),(height/rows));

                tiles[x][y] += 1; 

                if (tiles[x][y] >= 60) {
                    tiles[x][y] = 0;    
                    }
            }
        }
        popMatrix();
    }
}
