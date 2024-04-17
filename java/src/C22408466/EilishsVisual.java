package C22408466;

import ie.tudublin.Visual;
import processing.core.PGraphics;


public class EilishsVisual extends Visual
{
    Star stars[] = new Star[1000];
    //float starSpeed;

    public EilishsVisual(PGraphics g) 
    {
        this.g = g;
        for (int i = 0; i < stars.length; i++) 
        {
            stars[i] = new Star(this.g);
        }
    }
    
    public void play() 
    {
        background(0);
        pushMatrix();
        //translate(g.width / 2, g.height / 2);

        for (int i = 0; i < stars.length; i++) 
        {
            stars[i].update();
            stars[i].render();
        }

        popMatrix();
    }
}