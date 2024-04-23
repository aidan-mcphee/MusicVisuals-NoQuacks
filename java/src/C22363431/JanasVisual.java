package C22363431;

import ie.tudublin.Visual;
import processing.core.PGraphics;

public class JanasVisual extends Visual{

    public Terrain terrainGen;
    public SpinningSquares SpSquares;
    public DiscoTiles DiscTiles;

    public JanasVisual(PGraphics g, float size) {
        this.width = g.width;
        this.height = g.height;
        this.g = g;
        terrainGen = new Terrain(this.g, size);
        SpSquares = new SpinningSquares(this.g);
        DiscTiles = new DiscoTiles(g, size);
    }

    public void play(float amp) {
        //terrainGen.drawTerrain(amp);
        //SpSquares.drawSquares(amp);
        DiscTiles.drawTiles(amp);
    }
    
}