package Inimigo;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLProfile;
import java.util.Random;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;
import java.io.IOException;
import java.io.InputStream;

public class Inimigo {

    private Texture texturaNave;
    private GLU glu;
    public int timer;
    public float posZ, posX, posY;
    private Random random;

    public Inimigo() {
        random = new Random();
        timer = 0;
        posX = ((random.nextFloat() * 200) - (float) 100);
        posY = ((random.nextFloat() * 200) - (float) 100);
        posZ = -200;
    }

    public void texturaInimigo() {
        try {
            InputStream streamNave = getClass().getResourceAsStream("texturaNave.jpg");
            TextureData dataNave = TextureIO.newTextureData(GLProfile.getDefault(), streamNave, false, "jpg");
            texturaNave = TextureIO.newTexture(dataNave);
        } catch (IOException exc) {
            exc.printStackTrace();
            System.exit(1);
        }
    }

    public void renderizaNave(GL2 gl, GLU glu) {

        texturaNave.enable(gl);
        texturaNave.bind(gl);

        gl.glTranslatef(posX, posY, posZ);
        gl.glPushMatrix();
        corpo(gl, glu);
        gl.glPushMatrix();
        asas(gl, glu);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(18f, -2.6f, -4f);
        turbina(gl, glu);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(-18f, -2.6f, -4f);
        turbina(gl, glu);
        gl.glPopMatrix();
        gl.glPopMatrix();

        texturaNave.disable(gl);

    }

    public void reiniciar(int x, int y, float z) {
        posX = x;
        posY = y;
        posZ = z;
        timer = 0;
    }

    private void corpo(GL2 gl, GLU glu) {

        GLUquadric cafe = glu.gluNewQuadric();

        glu.gluQuadricTexture(cafe, true);
        glu.gluQuadricDrawStyle(cafe, GLU.GLU_FILL);
        glu.gluQuadricNormals(cafe, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(cafe, GLU.GLU_OUTSIDE);
        gl.glScalef(.7f, .7f, .7f);
        glu.gluCylinder(cafe, .1f, 6.3f, 8f, 50, 50);
        gl.glTranslatef(0f, 0f, 13f);
        glu.gluSphere(cafe, 8, 50, 50);
        glu.gluDeleteQuadric(cafe);
    }

    private void asas(GL2 gl, GLU glu) {

        GLUquadric cafe = glu.gluNewQuadric();

        glu.gluQuadricTexture(cafe, true);
        glu.gluQuadricDrawStyle(cafe, GLU.GLU_FILL);
        glu.gluQuadricNormals(cafe, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(cafe, GLU.GLU_OUTSIDE);

        gl.glScalef(1.5f, .1f, .4f);
        gl.glTranslatef(0, -18f, -4f);
        glu.gluSphere(cafe, 12, 50, 50);
        glu.gluDeleteQuadric(cafe);

    }

    public void turbina(GL2 gl, GLU glu) {
        GLUquadric cafe = glu.gluNewQuadric();
        glu.gluQuadricTexture(cafe, true);
        glu.gluQuadricDrawStyle(cafe, GLU.GLU_FILL);
        glu.gluQuadricNormals(cafe, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(cafe, GLU.GLU_OUTSIDE);

        gl.glPushMatrix();
        gl.glScalef(.2f, .2f, .2f);
        glu.gluCylinder(cafe, 5.5f, 5f, 20f, 50, 50);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glScalef(.176f, .176f, .2f);
        gl.glTranslatef(0f, 0f, -8f);
        glu.gluCylinder(cafe, .1f, 6.3f, 8f, 50, 50);
        gl.glPopMatrix();

        glu.gluDeleteQuadric(cafe);

    }
}
