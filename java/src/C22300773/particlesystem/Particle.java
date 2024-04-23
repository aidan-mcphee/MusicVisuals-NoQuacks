package C22300773.particlesystem;

import ie.tudublin.Visual;
import processing.core.PGraphics;
import processing.core.PVector;

public class Particle extends Visual {
    PVector origin;
    float sphereRadius;
    float distance;
    float theta;
    float phi;
    float velTheta;
    float velPhi;
    float velDistance;
    float MaxDistance = 10;

    public Particle(PGraphics g, PVector origin, float sphereRadius) {
        this.g = g;
        this.origin = origin;
        this.sphereRadius = sphereRadius;
        
        this.theta = random(-PI, PI);
        this.phi = random(-PI, PI);
        this.velTheta = (random(2) < 1 ? -1 : 1) * random(0.10f, 0.2f);
        this.velPhi = (random(2) < 1 ? -1 : 1) * random(0.10f, 0.2f);
    }

    public void update(float amplitude) {
        theta += velTheta * amplitude;
        phi += velPhi * amplitude;
    }

    public void render() {
        float x = origin.x + (sphereRadius + distance) * sin(theta) * cos(phi);
        float y = origin.y + (sphereRadius + distance) * sin(theta) * sin(phi);
        float z = origin.z + (sphereRadius + distance) * cos(theta);
        pushMatrix();
        stroke(209,106,255);
        noFill();
        translate(x, y, z);
        sphere(5);
        popMatrix();
    }
}
