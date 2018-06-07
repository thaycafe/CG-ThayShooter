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
    private Texture asteroide;
    private GLU glu;
    private int t, p3, p2;
    private Random random;
    public int timer2, timer3;
    public float Z, X, Y;
    
    
    public Asteroide(){
        random = new Random();
        timer2 = 0;
        timer3 = 0;
        X = ((random.nextFloat() * 200) - (float) 100);
        Y = ((random.nextFloat() * 200) - (float) 100);
        Z = -200;
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
    
    public void reinicia(int x, int y, float z) {
        X = x;
        Y = y;
        Z = z;
        timer2 = 0;
        timer3 = 0;
    }
    
}