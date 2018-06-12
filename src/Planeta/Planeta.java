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
    private Texture textura, texturaTerra, texturaMars, texturaUranus, texturaSaturn,
            texturaJupter;
    public float posX, posY;
    private float posZFinal, posZ, rotation;
    private int raioP;

    /**
     * Construtor da classe Renderer que não recebe parâmetros.
     */
    public Planeta() {
        Random gerador = new Random();

        posX = 0;
        posY = 0;
        posZ = 0;
        rotation = 0;

    }

    public void carregarTextura() {

// Comandos de inicialização para textura da Terra
        try {
            InputStream streamTerra = getClass().getResourceAsStream( "terra.jpg");
            TextureData dataTerra = TextureIO.newTextureData(GLProfile.getDefault(),
                    streamTerra, false,  "jpg");
            texturaTerra = TextureIO.newTexture(dataTerra);

            InputStream streamMars = getClass().getResourceAsStream( "Mars-small.jpg");
            TextureData dataMars = TextureIO.newTextureData(GLProfile.getDefault(),
                    streamMars, false,  "jpg");
            texturaMars = TextureIO.newTexture(dataMars);

            InputStream streamSaturno = getClass().getResourceAsStream( "Saturn.jpg");
            TextureData dataSaturn = TextureIO.newTextureData(GLProfile.getDefault(),
                    streamSaturno, false, "jpg");
            texturaSaturn = TextureIO.newTexture(dataSaturn);

            InputStream streamUranus = getClass().getResourceAsStream( "Uranus.jpg");
            TextureData dataUranus = TextureIO.newTextureData(GLProfile.getDefault(),
                    streamUranus, false,  "jpg");
            texturaUranus = TextureIO.newTexture(dataUranus);

            InputStream streamJupter = getClass().getResourceAsStream( "Jupter.jpg");

            TextureData dataJupter = TextureIO.newTextureData(GLProfile.getDefault(),
                    streamJupter, false,  "jpg");
            texturaJupter = TextureIO.newTexture(dataJupter);
        } catch (IOException exc) {
            exc.printStackTrace();
            System.exit(1);
        }
    }

    public void renderizaPlaneta(GL2 gl, GLU glu, String txt) {
// Habilita a textura da Terra
        habilitarTextura(txt);
        textura.enable(gl);
        textura.bind(gl);

        gl.glPushMatrix();
// Desloca o objeto
        gl.glRotated(rotation, 1, 0, 0);
        gl.glTranslatef(posX, posY, posZ);
// Desenha a esfera da Terra
        GLUquadric planet = glu.gluNewQuadric();
        glu.gluQuadricTexture(planet, true);
        glu.gluQuadricDrawStyle(planet, GLU.GLU_FILL);
        glu.gluQuadricNormals(planet, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(planet, GLU.GLU_OUTSIDE);
        glu.gluSphere(planet, raioP, 50, 50);
        glu.gluDeleteQuadric(planet);
        gl.glPopMatrix();
        textura.disable(gl);
    }

    public void habilitarTextura(String text) {
        switch (text) {
            case  "Terra":
                textura = texturaTerra;
                posX = 250;
                posY = 50;
                posZ = getPosZFinal();
                raioP = 70;
                break;
            case "Mars":
                textura = texturaMars;
                posX = -250;
                posY = -20;
                posZ = getPosZFinal();
                raioP = 50;
                break;
            case "Jupter":
                textura = texturaJupter;
                posX = -250;
                posY = 35;
                posZ = getPosZFinal();
                raioP = 60;
                break;
            case "Uranus":
                textura = texturaUranus;
                posX = 250;
                posY = -50;
                posZ = getPosZFinal();
                raioP = 60;
                break;
            case "Saturn":
                textura = texturaSaturn;
                posX = -250;
                posY = 20;
                posZ = getPosZFinal();
                raioP = 70;
                break;

        }
    }

    /**
     * @return the posZFinal
     */
    public float getPosZFinal() {
        return posZFinal;
    }

    /**
     * @param posZFinal the posZFinal to set
     */
    public void setPosZFinal(float posZFinal) {
        this.posZFinal = posZFinal;
    }

}
