package C22408466;

import ie.tudublin.Visual;
import processing.core.PGraphics;


public class Star extends Visual 
{
    float x, y, z; 
    float px, py, pz; // previous coords
    float starSpeed;
    float smoothAmp;
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

    public void setAmplitude(float amp) {
        smoothAmp = amp;
    }

    public void update() 
    {
        float maxAmpSpeed = 200;
        starSpeed = map(smoothAmp, 0, 1, 0, maxAmpSpeed);
        z = z - starSpeed;
      
        if (z < 1) {
            z = g.width;
            x = random(-g.width, g.width);
            y = random(-g.height, g.height);
        }
    }
    
    public void updateSlow() 
    {
        float maxAmpSpeed = 60;
        starSpeed = map(smoothAmp, 0, 1, 0, maxAmpSpeed);
        z = z - starSpeed;
        
        if (z < 1) {
            z = g.width;
            x = random(-g.width, g.width);
            y = random(-g.height, g.height);
        }

    }

    public void renderYellow() 
    {
        colorMode(RGB);

        float sx = map(x / z, 0, 1, 0, g.width);
        float sy = map(y / z, 0, 1, 0, g.height);
        
        starSize = map(z, 0, g.width, 20, 0);
        
        px = map(x / pz, 0, 1, 0, g.width);
        py = map(y / pz, 0, 1, 0, g.height);
        
        pz = z;
        stroke(255, 213, 0);
        strokeWeight(sx / 5);
        line(px, py, sx, sy); 
        
    }
    
    
    public void renderPurple() 
    {
        colorMode(RGB);
        
        float sx = map(x / z, 0, 1, 0, g.width);
        float sy = map(y / z, 0, 1, 0, g.height);
        
        starSize = map(z, 0, g.width, 20, 0);
        
        px = map(x / pz, 0, 1, 0, g.width);
        py = map(y / pz, 0, 1, 0, g.height);
        ellipse(sx, sy, starSize, starSize);
        
        pz = z;

        stroke(186, 3, 252);
        strokeWeight(starSize);
        line(px, py, sx, sy);
    }
}
