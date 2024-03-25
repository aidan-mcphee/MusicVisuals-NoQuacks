package ie.tudublin;

import C22363431.JanasVisual;
import example.CubeVisual;
import example.CubeVisual1;
import example.MyVisual;
import example.RotatingAudioBands;
import C22386221.*;

public class Main {

    public void startUI() {
        String[] a = { "MAIN" };
        processing.core.PApplet.runSketch(a, new song());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startUI();
    }
}