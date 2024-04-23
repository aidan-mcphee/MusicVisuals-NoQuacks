package C22408466;

import ie.tudublin.Visual;
import processing.core.PGraphics;


public class EilishsVisual extends Visual
{
    Star stars[] = new Star[1000];
    Rain rain[] = new Rain[100];

    public EilishsVisual(PGraphics g) 
    {
        this.g = g;
        for (int i = 0; i < stars.length; i++) 
        {
            stars[i] = new Star(this.g);
        }

        for (int i = 0; i < rain.length; i++) 
        {
            rain[i] = new Rain(this.g);
        }
        
    }
    
    public void Starfield(float smoothAmp) 
    {
        colorMode(RGB);
        background(0);
        pushMatrix();
        translate(g.width / 2, g.height / 2);

        for (int i = 0; i < stars.length; i++) 
        {
            stars[i].setAmplitude(smoothAmp);
            stars[i].update();
            stars[i].renderYellow();
            
        }
        
        for (int i = 0; i < stars.length; i++) 
        {
            stars[i].setAmplitude(smoothAmp);
            stars[i].updateSlow();
            stars[i].renderPurple();
            
        }

        popMatrix();
    }

    public void Beams(float smoothAmp)
    {
        colorMode(RGB);
        background(255, 213, 0);
        pushMatrix();

        for (int i = 0; i < rain.length; i++) 
        {
            rain[i].fall();
            rain[i].render();
        }

        popMatrix();
    }
}