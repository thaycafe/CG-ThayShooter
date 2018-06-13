
package MenuGameOver;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;
import java.io.IOException;
import java.io.InputStream;

public class Quadrado {
    public Texture quads;
    
    public Quadrado(){
        
    }
    
    public void Quads(GL2 gl, GLUT glut, GLU glu, float x){
        quads.enable(gl);
        quads.bind(gl);
        
        gl.glPushMatrix();
            gl.glPushMatrix();
                gl.glTranslatef(1,12, x + 70);
                GLUquadric quads1 = glu.gluNewQuadric();
                glu.gluQuadricTexture(quads1, true);
                glu.gluQuadricDrawStyle(quads1, GLU.GLU_FILL);
                glu.gluQuadricNormals(quads1, GLU.GLU_FLAT);
                glu.gluQuadricOrientation(quads1, GLU.GLU_OUTSIDE);
                glut.glutSolidCube(40);
                glu.gluDeleteQuadric(quads1);
                quads.disable(gl);
            gl.glPopMatrix();    
        gl.glPopMatrix();
    }   
    
    public void textquads(){
        try {
            InputStream streamQuadrado = getClass().getResourceAsStream("asteroide.jpg");
            TextureData dataQuadrado = TextureIO.newTextureData(GLProfile.getDefault(), streamQuadrado, false, "jpg");
            quads = TextureIO.newTexture(dataQuadrado);
            
        } catch (IOException exc) {
            exc.printStackTrace();
            System.exit(1);
        }
    }
        
    
}
