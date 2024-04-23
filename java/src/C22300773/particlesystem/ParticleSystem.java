package C22300773.particlesystem;

import java.util.ArrayList;

import ie.tudublin.Visual;
import processing.core.PVector;
import processing.core.PGraphics;

public class ParticleSystem extends Visual {
    ArrayList<Particle> particles = new ArrayList<Particle>();
    PVector origin;
    float sphereRadius;

    public ParticleSystem(PVector origin, PGraphics g, float sphereRadius) {
        this.origin = origin;
        this.g = g;
        this.sphereRadius = sphereRadius;
    }

    public void addParticle() {
        particles.add(new Particle(g, origin, sphereRadius));
    }

    public void run(float amplitude) {
        for (int i = particles.size() - 1; i >= 0; i--) {
            Particle p = particles.get(i);
            p.update(amplitude);
            p.render();
        }
    }
}
