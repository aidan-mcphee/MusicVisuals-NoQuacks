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

    /*public void setMouseX(int mouseX) 
    {
        this.mouseX = mouseX;
    }*/
    
    public void play() 
    {
        //starSpeed = map(mouseX, 0, g.width, 0, 50);
        background(0);
        translate(g.width / 2, g.height / 2);

        for (int i = 0; i < stars.length; i++) 
        {
            stars[i].update();
            stars[i].render();
        }
    }
}