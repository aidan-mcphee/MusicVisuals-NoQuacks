package C22363431;

import ie.tudublin.Visual;
import processing.core.PGraphics;

public class JanasVisual extends Visual{

    Terrain terrainGen;
    SpinningSquares SpSquares;
    int frameCount;

    public JanasVisual(PGraphics g, float size) {
        this.g = g;
        terrainGen = new Terrain(this.g, size);
        SpSquares = new SpinningSquares(this.g);
        frameCount = 0;
    }

    public void play(float amp) {
        //terrainGen.drawTerrain(amp);
        SpSquares.drawSquares(frameCount);
        frameCount++;
    }
}