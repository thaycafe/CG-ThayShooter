
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

public class Nave {
    
        private Texture texturaNave, texturaFoguinho, texturaIron, texturaNave2, texturaTurbina;
        private GLU glu;

    public void texturaNave(){
        try {
            InputStream streamNave = getClass().getResourceAsStream("texturaNave.jpg");
            TextureData dataNave = TextureIO.newTextureData(GLProfile.getDefault(), streamNave, false, "jpg");
            texturaNave = TextureIO.newTexture(dataNave);
            
            InputStream streamIron = getClass().getResourceAsStream("texturaIron.jpg");
            TextureData dataIron = TextureIO.newTextureData(GLProfile.getDefault(), streamIron, false, "jpg");
            texturaIron = TextureIO.newTexture(dataIron);
            
            InputStream streamFoguinho = getClass().getResourceAsStream("texturaFoguinho.jpg");
            TextureData dataFoguinho = TextureIO.newTextureData(GLProfile.getDefault(), streamFoguinho, false, "jpg");
            texturaFoguinho = TextureIO.newTexture(dataFoguinho);
            
            InputStream streamNave2 = getClass().getResourceAsStream("texturaNave2.jpg");
            TextureData dataNave2 = TextureIO.newTextureData(GLProfile.getDefault(), streamNave2, false, "jpg");
            texturaNave2 = TextureIO.newTexture(dataNave2);
            
            InputStream streamTurbina = getClass().getResourceAsStream("texturaTurbina.jpg");
            TextureData dataTurbina = TextureIO.newTextureData(GLProfile.getDefault(), streamTurbina, false, "jpg");
            texturaTurbina = TextureIO.newTexture(dataTurbina);
        } catch (IOException exc) {
            exc.printStackTrace();
            System.exit(1);
        }
    }
    
     public void formaNave(GL2 gl, GLU glu) {
        

        gl.glRotatef(0f, 0f, 2f, 0f);
        
        gl.glPushMatrix();
            corpo(gl, glu);
            gl.glPushMatrix();
                gl.glTranslatef(12f, -10f, 5f);
                turbina(gl, glu);
                gl.glPushMatrix();
                    gl.glTranslatef(0f, 0f, 20);
                    donut(gl, glu);
                    gl.glPushMatrix();
                        foguinho(gl, glu);
                    gl.glPopMatrix();
                gl.glPopMatrix();
                gl.glPushMatrix();
                    gl.glRotatef(90, -1f, 2f, 1.8f);
                    gl.glTranslatef(-17f, -7f, 6f);
                    partTurbina(gl, glu);
                gl.glPopMatrix();
            gl.glPopMatrix();
            gl.glPushMatrix();
                gl.glTranslatef(-12f, -10f, 5f);
                turbina(gl, glu);
                gl.glPushMatrix();
                    gl.glTranslatef(0f, 0f, 20);
                    donut(gl, glu);
                    gl.glPushMatrix();
                        foguinho(gl, glu);
                    gl.glPopMatrix();
                gl.glPopMatrix();
                gl.glPushMatrix();
                    gl.glRotatef(90, 1.5f, 2f, -1.3f);
                    gl.glTranslatef(-17f, -6f, 2f);
                    partTurbina(gl, glu);
                gl.glPopMatrix();
            gl.glPopMatrix();
//            gl.glPushMatrix();
//                gl.glTranslatef(6f, -4f, 5f);
//                arma();
//            gl.glPopMatrix();
        gl.glPopMatrix();
    }

    public void turbina(GL2 gl, GLU glu) {
        texturaIron.enable(gl);
        texturaIron.bind(gl);
        GLUquadric cafe = glu.gluNewQuadric();
        gl.glScalef(-.5f, -.7f, .6f);
        glu.gluQuadricTexture(cafe, true);
        glu.gluQuadricDrawStyle(cafe, GLU.GLU_FILL);
        glu.gluQuadricNormals(cafe, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(cafe, GLU.GLU_OUTSIDE);
        glu.gluCylinder(cafe, 5.5f, 5f, 20f, 10, 50);
        glu.gluDeleteQuadric(cafe);
        texturaIron.disable(gl);
        //asa direita ponta
        texturaTurbina.enable(gl);
        texturaTurbina.bind(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, 3f);
        glu.gluQuadricTexture(cafe, true);
        glu.gluQuadricDrawStyle(cafe, GLU.GLU_FILL);
        glu.gluQuadricNormals(cafe, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(cafe, GLU.GLU_OUTSIDE);
        glu.gluSphere(cafe, 5.3, 10, 50);
        glu.gluDeleteQuadric(cafe);
        gl.glPopMatrix();
        
        texturaTurbina.disable(gl);
    }

    public void corpo(GL2 gl, GLU glu) {
        texturaNave.enable(gl);
        texturaNave.bind(gl);
        //gl.glRotatef(90f, 1f, 0f, 0f);
        GLUquadric cafe = glu.gluNewQuadric();
        glu.gluQuadricTexture(cafe, true);
        glu.gluCylinder(cafe, .1f, 6.3f, 8f, 50, 50);
        glu.gluDeleteQuadric(cafe);
        texturaNave.disable(gl);
        //corpo
        texturaNave2.enable(gl);
        texturaNave2.bind(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, 13f);
        glu.gluQuadricTexture(cafe, true);
        glu.gluQuadricDrawStyle(cafe, GLU.GLU_FILL);
        glu.gluQuadricNormals(cafe, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(cafe, GLU.GLU_OUTSIDE);
        glu.gluSphere(cafe, 8, 50, 50);
        glu.gluDeleteQuadric(cafe);
        gl.glPopMatrix();
        texturaNave2.disable(gl);
        

    }

    public void partTurbina(GL2 gl, GLU glu) {
        texturaIron.enable(gl);
        texturaIron.bind(gl);
        GLUquadric cafe = glu.gluNewQuadric();
        gl.glScalef(-.1f, 1.2f, .3f);
        glu.gluQuadricTexture(cafe, true);
        glu.gluQuadricDrawStyle(cafe, GLU.GLU_FILL);
        glu.gluQuadricNormals(cafe, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(cafe, GLU.GLU_OUTSIDE);
        glu.gluCylinder(cafe, 5f, 5f, 8f, 10, 50);
        glu.gluDeleteQuadric(cafe);
        texturaIron.disable(gl);
    }

    public void donut(GL2 gl, GLU glu){
        texturaNave.enable(gl);
        texturaNave.bind(gl);
        GLUquadric cafe = glu.gluNewQuadric();
        glu.gluDisk(cafe, 4, 6, 10, 50);
        texturaNave.disable(gl);

    }
    
    public void foguinho(GL2 gl, GLU glu){
        texturaFoguinho.enable(gl);
        texturaFoguinho.bind(gl);
        
        GLUquadric cafe = glu.gluNewQuadric();
        glu.gluQuadricTexture(cafe, true);
        glu.gluQuadricDrawStyle(cafe, GLU.GLU_FILL);
        glu.gluQuadricNormals(cafe, GLU.GLU_FLAT);
        glu.gluCylinder(cafe, 3.5f, .1f, 10f, 20, 50);
        
        texturaFoguinho.disable(gl);
    }
    
    public void arma(GL2 gl, GLU glu){
        GLUquadric cafe = glu.gluNewQuadric();
        gl.glScalef(-.1f, -.1f, .3f);
        glu.gluQuadricTexture(cafe, true);
        glu.gluQuadricDrawStyle(cafe, GLU.GLU_FILL);
        glu.gluQuadricNormals(cafe, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(cafe, GLU.GLU_OUTSIDE);
        glu.gluCylinder(cafe, 5.5f, 5f, 20f, 10, 50);
        glu.gluDeleteQuadric(cafe);
        //asa direita ponta
        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, -8f);
        glu.gluQuadricTexture(cafe, true);
        glu.gluQuadricDrawStyle(cafe, GLU.GLU_FILL);
        glu.gluQuadricNormals(cafe, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(cafe, GLU.GLU_OUTSIDE);
        glu.gluCylinder(cafe, .1f, 5.3f, 8f, 10, 50);
        glu.gluDeleteQuadric(cafe);
        gl.glPopMatrix();
    }
}
