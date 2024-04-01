package C22408466;

import ie.tudublin.Visual;
import main.song;
import processing.core.PFont;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;


public class Star 
{
    float x, y, z; 
    float px, py, pz; // previous coords
    float w;
    float h;
    float starSpeed;
    float starSize;

    song s;

    public Star() 
    {
        x = s.random(-w, w);
        y = s.random(-h, h);
        z = s.random(w);
        px = x;
        py = y;
        pz = z;
    }

    public void update() 
    {
        z = z - starSpeed;

        if (z < 1) {
            z = w;
            x = s.random(-w, w);
            y = s.random(-h, h);
            pz = z;
        }
    }

    public void render() 
    {
        
        s.fill(255);
        s.noStroke();

        float sx = map(x / z, 0, 1, 0, w);
        float sy = map(y / z, 0, 1, 0, h);

        starSize = map(z, 0, w, 16, 0);
        s.ellipse(sx, sy, starSize, starSize);

        float px = map(x / pz, 0, 1, 0, w);
        float py = map(y / pz, 0, 1, 0, h);
        
        pz = z;
        s.stroke(255);
        s.line(px, py, sx, sy);
    
    }
}
