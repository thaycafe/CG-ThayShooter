
package Nave;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class Explosao {
    
    public Texture explosao;
    public float eX, eY, eZ;
    
     public void textColisao() {
        try {
            InputStream streamColisao1 = getClass().getResourceAsStream("explosaoColisao.jpg");
            TextureData dataColisao1 = TextureIO.newTextureData(GLProfile.getDefault(), streamColisao1, false, "jpg");
            explosao = TextureIO.newTexture(dataColisao1);

        } catch (IOException exc) {
            exc.printStackTrace();
            System.exit(1);
        }
    }
     
     public void ExplosaoColisao(GL2 gl, GLU glu) {
       explosao.enable(gl);
        explosao.bind(gl);

        gl.glPushMatrix();
        gl.glTranslatef(eX, eY, eZ);
        GLUquadric explo = glu.gluNewQuadric();
        glu.gluQuadricTexture(explo, true);
        glu.gluQuadricDrawStyle(explo, GLU.GLU_FILL);
        glu.gluQuadricNormals(explo, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(explo, GLU.GLU_OUTSIDE);
        glu.gluSphere(explo, 20, 5, 5);
        glu.gluDeleteQuadric(explo);
        gl.glPopMatrix();

    explosao.disable(gl);
    }
}
