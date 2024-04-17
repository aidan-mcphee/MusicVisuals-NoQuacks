package ie.tudublin;

import main.Song;


public class Main {

    public void startUI() {
        String[] a = { "MAIN" };
        processing.core.PApplet.runSketch(a, new Song());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startUI();
    }
}