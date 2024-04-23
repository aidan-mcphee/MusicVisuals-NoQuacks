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
                tiles[x][y] = random(60);  // Random hue from 0 to 360
            }
        }
    }

    public void drawTiles(float amp) {
        colorMode(HSB);

        pushMatrix();
        for (int x = 0; x < cols; x++) {
            for(int y = 0; y < rows; y++) {
                noStroke();
                fill(tiles[x][y], 360, 360);  // Set color based on hue and amplitude
                rect(x*(width/cols), y*(height/rows),(width/cols),(height/rows));

                // Update hue to change color over time
                tiles[x][y] += 1;  // Increment hue

                if (tiles[x][y] >= 70) {
                    tiles[x][y] = 0;  // Reset hue if it goes over 360
                    }
            }
        }
        popMatrix();
    }
}
