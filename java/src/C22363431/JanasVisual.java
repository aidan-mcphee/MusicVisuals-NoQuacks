package C22363431;

import ie.tudublin.Visual;
import processing.core.PGraphics;

public class JanasVisual extends Visual{

    Terrain terrainGen;

    public JanasVisual(PGraphics g, float size) {
        this.g = g;
        terrainGen = new Terrain(this.g, size);
    }

    public void play(float amp) {
        terrainGen.drawTerrain(amp);
    }

}