package Asteroide;

import java.util.Random;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;
import java.io.IOException;
import java.io.InputStream;


public class Asteroide {
    public Texture asteroide;
    private GLU glu;
    private int t, p3, p2;
    private Random random;
    public int timer2, timer3, timer4, timer5;
    public float Z, X, Y, Z2, X2, Y2, X3,X4, Y3, Y4, Z3, Z4;
    
    
    public Asteroide(){
        random = new Random();
        timer2 = 0;
        timer3 = 0;
        X = ((random.nextFloat() * 200) - (float) 100);
        X2 = ((random.nextFloat() * 200) - (float) 100);
        X3 = ((random.nextFloat() * 200) - (float) 100);
        X4 = ((random.nextFloat() * 200) - (float) 100);
        Y = ((random.nextFloat() * 200) - (float) 100);
        Y2 = ((random.nextFloat() * 200) - (float) 100);
        Y3 = ((random.nextFloat() * 200) - (float) 100);
        Y4 = ((random.nextFloat() * 200) - (float) 100);
        Z = -200;
        Z2 = -200;
        Z3 = -200;
        Z4 = -200;
        
    }
    
    
    public void text(){
        try {
            InputStream streamAsteroide = getClass().getResourceAsStream("asteroide.jpg");
            TextureData dataAsteroide = TextureIO.newTextureData(GLProfile.getDefault(), streamAsteroide, false, "jpg");
            asteroide = TextureIO.newTexture(dataAsteroide);
            
        } catch (IOException exc) {
            exc.printStackTrace();
            System.exit(1);
        }
    }
    
    public void Aster(GL2 gl, GLU glu){
        asteroide.enable(gl);
        asteroide.bind(gl);
        
        Random alt = new Random();
        t = alt.nextInt(5) + 5;
        p2 = alt.nextInt(120) - 60;
        p3 = alt.nextInt(120) - 60;
        
        
        gl.glPushMatrix();
            gl.glTranslatef(X, Y, Z);
            GLUquadric aster = glu.gluNewQuadric();
            glu.gluQuadricTexture(aster, true);
            glu.gluQuadricDrawStyle(aster, GLU.GLU_FILL);
            glu.gluQuadricNormals(aster, GLU.GLU_FLAT);
            glu.gluQuadricOrientation(aster, GLU.GLU_OUTSIDE);
            glu.gluSphere(aster, 6, 10, 10);
            glu.gluDeleteQuadric(aster);
            gl.glPopMatrix();
            asteroide.disable(gl);
        gl.glPopMatrix();
        
                
    }
    
    public void Aster2(GL2 gl, GLU glu){
        asteroide.enable(gl);
        asteroide.bind(gl);
        
        Random alt = new Random();
        t = alt.nextInt(5) + 5;
        p2 = alt.nextInt(120) - 60;
        p3 = alt.nextInt(120) - 60;
        
        
        gl.glPushMatrix();
            gl.glTranslatef(X2, Y2, Z2);
            GLUquadric aster = glu.gluNewQuadric();
            glu.gluQuadricTexture(aster, true);
            glu.gluQuadricDrawStyle(aster, GLU.GLU_FILL);
            glu.gluQuadricNormals(aster, GLU.GLU_FLAT);
            glu.gluQuadricOrientation(aster, GLU.GLU_OUTSIDE);
            glu.gluSphere(aster, 6, 10, 10);
            glu.gluDeleteQuadric(aster);
            gl.glPopMatrix();
            asteroide.disable(gl);
        gl.glPopMatrix();
        
                
    }
    
    public void Aster3(GL2 gl, GLU glu){
        asteroide.enable(gl);
        asteroide.bind(gl);
        
        Random alt = new Random();
        t = alt.nextInt(5) + 5;
        p2 = alt.nextInt(120) - 60;
        p3 = alt.nextInt(120) - 60;
               
        gl.glPushMatrix();
            gl.glTranslatef(X3, Y3, Z3);
            GLUquadric aster = glu.gluNewQuadric();
            glu.gluQuadricTexture(aster, true);
            glu.gluQuadricDrawStyle(aster, GLU.GLU_FILL);
            glu.gluQuadricNormals(aster, GLU.GLU_FLAT);
            glu.gluQuadricOrientation(aster, GLU.GLU_OUTSIDE);
            glu.gluSphere(aster, 6, 10, 10);
            glu.gluDeleteQuadric(aster);
            gl.glPopMatrix();
            asteroide.disable(gl);
        gl.glPopMatrix();                     
    }
    
    public void Aster4(GL2 gl, GLU glu){
        asteroide.enable(gl);
        asteroide.bind(gl);
        
        Random alt = new Random();
        t = alt.nextInt(5) + 5;
        p2 = alt.nextInt(120) - 60;
        p3 = alt.nextInt(120) - 60;
                
        gl.glPushMatrix();
            gl.glTranslatef(X4, Y4, Z4);
            GLUquadric aster = glu.gluNewQuadric();
            glu.gluQuadricTexture(aster, true);
            glu.gluQuadricDrawStyle(aster, GLU.GLU_FILL);
            glu.gluQuadricNormals(aster, GLU.GLU_FLAT);
            glu.gluQuadricOrientation(aster, GLU.GLU_OUTSIDE);
            glu.gluSphere(aster, 6, 10, 10);
            glu.gluDeleteQuadric(aster);
            gl.glPopMatrix();
            asteroide.disable(gl);
        gl.glPopMatrix();                        
    }
    
    
    public void reinicia(int x, int y, float z) {
        X = x;
        Y = y;
        Z = z;       
        timer2 = 0;
    }
    
    public void reinicia2(int x, int y, float z) {
        X2 = x;
        Y2 = y;
        Z2 = z;     
        timer3 = 0;
    }
    
    public void reinicia3(int x, int y, float z) {
        X3 = x;
        Y3 = y;
        Z3 = z;     
        timer4 = 0;
    }
    
    public void reinicia4(int x, int y, float z) {
        X4 = x;
        Y4 = y;
        Z4 = z;     
        timer5 = 0;
    }
    
}