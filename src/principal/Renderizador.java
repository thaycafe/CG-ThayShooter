
package principal;

import Inimigo.Inimigo;
import Nave.Nave;
import Nave.Projetil;
import Planeta.Planeta;
import com.jogamp.opengl.GL;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import java.awt.event.KeyEvent;

public class Renderizador extends MouseAdapter implements GLEventListener, KeyListener {
    
    private GL2 gl;
    private GLU glu;
    private GLUT glut;
    private GLAutoDrawable glDrawable;
    private double angulo, aspecto;
    private float rotX, rotY, obsZ, movX, movY, rotX1, movZ, rotY1;
    private boolean luz;
    Nave nave = new Nave();
    Planeta planet = new Planeta();
    Projetil projetil = new Projetil();
    Inimigo inimigo = new Inimigo();
    
  
    
    public Renderizador() {
        angulo = 50;
        aspecto = 1;
        rotX = 0;
        rotY = 0;
        obsZ = -200;
        movX=0;
        movY=0;
        rotX1 = 0;
        rotY1 = 0;
    }

    @Override
    public void init(GLAutoDrawable glad) {
        glDrawable = glad;
        gl = glad.getGL().getGL2();
        glu = new GLU();
        glut = new GLUT();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glEnable(GL.GL_DEPTH_TEST);
        
        
        
         nave.texturaNave();
         planet.carregarTextura();
         projetil.textura();
         inimigo.texturaInimigo();
         
        
    }
    
    public void posicionaObservador() {
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glTranslatef(0, 0, obsZ);
        gl.glRotatef(rotX, 1, 0, 0);
        gl.glRotatef(rotY, 0, 1, 0);
    }
    public void especificaParametrosVisualizacao() {
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(angulo, aspecto, 0.2, 500);

        posicionaObservador();
    }


    @Override
    public void dispose(GLAutoDrawable glad) {
    }

    @Override
    public void display(GLAutoDrawable glad) {
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        especificaParametrosVisualizacao();
        movimento();
        planet.renderizaPlaneta(gl, glu, "Terra", 20f);
        planet.renderizaPlaneta(gl, glu, "Mars", 20f);
        inimigo.renderizaNave(gl, glu);
        gl.glTranslatef(movX, movY, movZ);
        gl.glRotatef(15,rotY1,0,rotX1);
        nave.formaNave(gl, glu);
        projetil.formaProjetil(gl, glu);
        
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        gl.glViewport(0, 0, width, height);
        aspecto = (float) width / (float) height;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()){
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                movX-=.5;
                rotX1=1;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                movX+=.5;
                rotX1=-1;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                movY+=.5;
                rotY1=1;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                movY-=.5;
                rotY1=-1;
                break;
        }
        glDrawable.display();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        switch (ke.getKeyCode()){
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                rotX1=0; 
               break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                rotX1=0;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:

                rotY1=0;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:    
                rotY1=0;
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
        }
    }
    
    public void movimento(){
        movZ -=2;
        obsZ+=2;
    }
    
    
}
/*
public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                rotY--;
                break;
            case KeyEvent.VK_RIGHT:
                rotY++;
                break;
            case KeyEvent.VK_UP:
                rotX++;
                break;
            case KeyEvent.VK_DOWN:
                rotX--;
                break;
            case KeyEvent.VK_HOME:
                obsZ++;
                break;
            case KeyEvent.VK_END:
                obsZ--;
                break;
            case KeyEvent.VK_F1:
                luz = !luz;
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
        }
        glDrawable.display();
    }

*/