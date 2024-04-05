package C22408466;

import ie.tudublin.Visual;
import processing.core.PGraphics;


public class Star extends Visual 
{
    float x, y, z; 
    float px, py, pz; // previous coords
    float starSpeed;
    float starSize;

    public Star(PGraphics g) {
        this.g = g;
        x = random(-g.width, g.width);
        y = random(-g.height, g.height);
        z = random(g.width);
        px = x;
        py = y;
        pz = z;
    }

    public void update() 
    {
        z = z - 60;
      
        if (z < 1) {
            z = g.width;
            x = random(-g.width, g.width);
            y = random(-g.height, g.height);
            // pz = z; // takes away extra lines
        }
    }

    public void render() 
    {
        //fill(90, 90, 255);
        //noStroke();

        float sx = map(x / z, 0, 1, 0, g.width);
        float sy = map(y / z, 0, 1, 0, g.height);
        
        starSize = map(z, 0, g.width, 20, 0);
        //ellipse(sx, sy, starSize, starSize);

        px = map(x / pz, 0, 1, 0, g.width);
        py = map(y / pz, 0, 1, 0, g.height);
        
        pz = z;
        stroke(38, 255, 255);
        line(px, py, sx, sy);
    
    }
}
