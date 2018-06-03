
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

public class Projetil {
    
     private Texture texturaProjetil;
    
    public void textura(){
        try {
            InputStream streamProjetil = getClass().getResourceAsStream("texturaProjetil.jpg");
            TextureData dataProjetil = TextureIO.newTextureData(GLProfile.getDefault(), streamProjetil, false, "jpg");
            texturaProjetil = TextureIO.newTexture(dataProjetil);
        } catch (IOException exc) {
            exc.printStackTrace();
            System.exit(1);
        }
    }
    
public void formaProjetil(GL2 gl, GLU glu) {
        texturaProjetil.enable(gl);
        texturaProjetil.bind(gl);
        GLUquadric cafe = glu.gluNewQuadric();
        gl.glTranslatef(0f, 0f, -5f);
        gl.glScalef(-.1f, -.2f, .2f);
        glu.gluQuadricTexture(cafe, true);
        glu.gluQuadricDrawStyle(cafe, GLU.GLU_FILL);
        glu.gluQuadricNormals(cafe, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(cafe, GLU.GLU_OUTSIDE);
        glu.gluCylinder(cafe, 5.5f, 5f, 20f, 10, 50);
        glu.gluDeleteQuadric(cafe);

        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, -5f);
        glu.gluQuadricTexture(cafe, true);
        glu.gluQuadricDrawStyle(cafe, GLU.GLU_FILL);
        glu.gluQuadricNormals(cafe, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(cafe, GLU.GLU_OUTSIDE);
        glu.gluCylinder(cafe,.5, 5.3, 5,50, 50);
        glu.gluDeleteQuadric(cafe);
        gl.glPopMatrix();
        
                texturaProjetil.disable(gl);
    }
}
