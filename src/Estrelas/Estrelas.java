package Estrelas;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import java.util.Random;

public class Estrelas {

    private GLU glu;
    private Random random;
    private float x, y, z;

    public Estrelas() {
        random = new Random();
        x = (random.nextFloat() * 660) - (float) 330;
        y = (random.nextFloat() * 360) - (float) 180;
        z = -200;
    }

    public void formaEstrela(GL2 gl, GLU glu) {
        GLUquadric cafe = glu.gluNewQuadric();

        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        glu.gluSphere(cafe, random.nextDouble(), 25, 25);
        gl.glPopMatrix();
    }

    public float getZ() {
        return this.z;
    }

    public void setZ(float z) {
        this.z = z;
    }

}
