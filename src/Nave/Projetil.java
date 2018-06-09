
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
     private float pX,pY, pZ;
     private boolean ativo;
     
     public Projetil(){
         pX = 0;
         pY = 0;
         pZ =0;
         ativo = false;
     }
    
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
        
        gl.glPushMatrix();
        gl.glTranslatef(getpX(), getpY(), getpZ());
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
            
        gl.glPopMatrix();
        
                texturaProjetil.disable(gl);
    }

    /**
     * @return the pX
     */
    public float getpX() {
        return pX;
    }

    /**
     * @param pX the pX to set
     */
    public void setpX(float pX) {
        this.pX = pX;
    }

    /**
     * @return the pY
     */
    public float getpY() {
        return pY;
    }

    /**
     * @param pY the pY to set
     */
    public void setpY(float pY) {
        this.pY = pY;
    }

    /**
     * @return the pZ
     */
    public float getpZ() {
        return pZ;
    }

    /**
     * @param pZ the pZ to set
     */
    public void setpZ(float pZ) {
        this.pZ = pZ;
    }

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public void movimento(){
        //pZ-=1;
    }
}
