package C22363431;

import ie.tudublin.Visual;

public class JanasVisual extends Visual{

    int mode = 0;
    int cols, rows;
    int scale = 20;
    int w = 1200;
    int h = 900;

    float flying = 0;
    float angle = 0;
    float [][] terrain;

    


    public void settings() {
        size(600, 600, P3D);
    }
    public void setup() {
        startMinim();
        startListening();

        cols = w / scale;
        rows = h / scale;
        
        terrain = new float[cols][rows];
        
    }


    public void draw() {

        switch (mode) {
            case 0:
            flying -= 0.05f;

            float yoffset = flying;
            for (int x = 0; x < rows; x++) {
                float xoffset = 0;
                for (int y = 0; y < cols; y++) {
                    terrain[y][x] = map(noise(xoffset,yoffset), 0, 1, -50, 50);
                    xoffset += 0.2f;
                }
                yoffset += 0.2f;
            } 
    
            background(0);
            strokeWeight(2);
            stroke(255,220,0);
            fill(0);
    
            translate(width/2, height/2);
            rotateX(PI/3);
            translate(-w/2, -h/4); // Camera 
    
            for (int y = 0; y < rows-1; y++) {
                beginShape(TRIANGLE_STRIP);
                for (int x = 0; x < cols; x++) {
                    vertex(x*scale,y*scale, terrain[x][y]);
                    vertex(x*scale,(y+1)*scale, terrain[x][y+1]);
                }
                endShape();
            }
            break;
            case 1:
            background(0);
            translate(width/2, height/2);
            rotateY(angle);
            rotateX(angle);
            angle += 0.03f;

            noFill();
            stroke(255);

            float beta = 0;

            beginShape();
            while (beta < PI) {
                float r = 100*(1 * 1f * sin(6 * beta));
                float theta = 2 * beta;
                float phi = 1 * PI * sin(12 * beta);

                float x = r * cos(phi) * cos(beta);
                float y = r * cos(phi) * sin(theta);
                float z = r * sin(phi);

                beta += 0.01f;
                vertex(x,y,z);
            }
            endShape();
            break;
            default:
                break;
        }
    }
}