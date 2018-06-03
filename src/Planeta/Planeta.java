package Planeta;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;

public class Planeta {

    private GL2 gl;
    private GLU glu;
    private float planetZ;
    private Texture textura, texturaTerra, texturaMars;
    private int posicaoX;

    /**
     * Construtor da classe Renderer que não recebe parâmetros.
     */   

    public void carregarTextura() {

        // Comandos de inicialização para textura da Terra
        try {
            InputStream streamTerra = getClass().getResourceAsStream("terra.jpg");
            TextureData dataTerra = TextureIO.newTextureData(GLProfile.getDefault(), streamTerra, false, "jpg");
            texturaTerra = TextureIO.newTexture(dataTerra);

            InputStream streamMars = getClass().getResourceAsStream("Mars-small.jpg");
            TextureData dataMars = TextureIO.newTextureData(GLProfile.getDefault(), streamMars, false, "jpg");
            texturaMars = TextureIO.newTexture(dataMars);
        } catch (IOException exc) {
            exc.printStackTrace();
            System.exit(1);
        }
    }

    public void renderizaPlaneta(GL2 gl, GLU glu, String txt, float Y) {
        // Habilita a textura da Terra

        habilitarTextura(txt);
        posicaoAleatoria();
        textura.enable(gl);
        textura.bind(gl);

        gl.glPushMatrix();
        // Desloca o objeto
        gl.glTranslatef(posicaoX, Y, planetZ);
        // Desenha a esfera da Terra
        GLUquadric planet = glu.gluNewQuadric();
        glu.gluQuadricTexture(planet, true);
        glu.gluQuadricDrawStyle(planet, GLU.GLU_FILL);
        glu.gluQuadricNormals(planet, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(planet, GLU.GLU_OUTSIDE);
        glu.gluSphere(planet, 20f, 50, 50);
        glu.gluDeleteQuadric(planet);
        gl.glPopMatrix();
        textura.disable(gl);
    }

    public void habilitarTextura(String text) {
        switch (text) {
            case "Terra":
                textura = texturaTerra;
                break;
            case "Mars":
                textura = texturaMars;
                break;
        }
    }

    public void posicaoAleatoria() {
        Random gerador = new Random();
        posicaoX = gerador.nextInt(200) - 100;
    }
}
