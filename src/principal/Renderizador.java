package principal;

import Asteroide.Asteroide;
import Inimigo.Inimigo;
import Nave.Nave;
import Nave.Projetil;
import Planeta.Planeta;
import java.util.Random;
import com.jogamp.opengl.GL;
import java.awt.event.KeyListener;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Renderizador  implements GLEventListener, KeyListener, MouseListener {

    private GL2 gl;
    private GLU glu;
    private GLUT glut;
    private GLAutoDrawable glDrawable;
    private double angulo, aspecto;
    private float rotX, rotY, obsZ, movX, movY, rotX1, movZ, rotY1;
    private boolean luz;
    private Random random, random2, random3;
    private int ctproj;
    
    JFrame x;
    FPSAnimator animator;
    public boolean pause;
    Nave nave = new Nave();
    Planeta planet = new Planeta();
    Projetil proj1 = new Projetil();
    Projetil proj2 = new Projetil();
    Projetil proj3 = new Projetil();
    Projetil proj4 = new Projetil();
    Projetil proj5 = new Projetil();
    Inimigo inimigo = new Inimigo();
    Asteroide aster = new Asteroide();
    
    public Renderizador(FPSAnimator animator, JFrame x) {
        angulo = 50;
        aspecto = 1;
        rotX =0;
        rotY = 0;
        obsZ = -200;
        movX = 0;
        movY = 0;
        rotX1 = 0;
        rotY1 = 0;
        ctproj =0;
        this.animator = animator;
        this.x = x;
        random = new Random();
        random2 = new Random();
        random3 = new Random();
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
        proj2.textura();
        proj1.textura();
        proj3.textura();
        proj4.textura();
        proj5.textura();
        inimigo.texturaInimigo();
        aster.text();
        
        try
        {
        x.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("/Nave/mira.png")).getImage(),new Point(0,0),"custom cursor"));
        }catch(Exception e){}
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
        inimigo.timer++;
        aster.timer2++;
        especificaParametrosVisualizacao();
        movimento();
         gl.glPushMatrix();
            projeteis();
        gl.glPopMatrix();

        gl.glPushMatrix();
            planet.renderizaPlaneta(gl, glu, "Terra");
            planet.renderizaPlaneta(gl, glu, "Mars");
        gl.glPopMatrix();
        gl.glPushMatrix();
            gl.glTranslatef(movX, movY, movZ);
            gl.glRotatef(15, rotY1, 0, rotX1);
                nave.formaNave(gl, glu);
        gl.glPopMatrix();

        gl.glPushMatrix();
            inimigo.renderizaNave(gl, glu);
            gl.glTranslatef(inimigo.posX, inimigo.posY, inimigo.posZ);
            inimigo.posZ += 1;
            if (inimigo.timer == 200) {
                inimigo.reiniciar((random.nextInt(200) - 100), (random.nextInt(200) - 100), (movZ - 300));
            }
        gl.glPopMatrix();
        
        gl.glPushMatrix(); 
            aster.Aster(gl, glu);  
            gl.glTranslatef(aster.X, aster.Y, aster.Z);
            aster.Z += 1;       
            if (aster.timer2 == 50) {
                aster.reinicia((random2.nextInt(200) - 100), (random2.nextInt(200) - 100), (movZ - 300));            
            }
        gl.glPopMatrix();

         
        
       
    }
     public void movimento() {
        movZ -= 2;
        obsZ += 2;
    }
     public void projeteis(){
        if(proj2.isAtivo()){
            proj2.formaProjetil(gl, glu);
        }
        if(proj1.isAtivo()){
            proj1.formaProjetil(gl, glu);
        }
         if(proj3.isAtivo()){
            proj3.formaProjetil(gl, glu);
        }
          if(proj4.isAtivo()){
            proj4.formaProjetil(gl, glu);
        }
           if(proj5.isAtivo()){
            proj5.formaProjetil(gl, glu);
        }
     }
     
     public void statusproj(int n){
         if(n==0){
             proj1.setpX(movX);
             proj1.setpY(movY);
             proj1.setpZ(movZ);
             proj1.setAtivo(true);
         }else if(n==1){
             proj2.setpX(movX);
             proj2.setpY(movY);
             proj2.setpZ(movZ);
             proj2.setAtivo(true);
         }else if(n==2){
             proj3.setpX(movX);
             proj3.setpY(movY);
             proj3.setpZ(movZ);
             proj3.setAtivo(true);
         }else if(n==3){
            proj4.setpX(movX);
             proj4.setpY(movY);
             proj4.setpZ(movZ);
             proj4.setAtivo(true);
        }else if(n==4){
             proj5.setpX(movX);
             proj5.setpY(movY);
             proj5.setpZ(movZ);
             proj5.setAtivo(true);
         }

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
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                movX -= 4;
                rotX1 = 1;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                movX += 4;
                rotX1 = -1;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                movY += 4;
                rotY1 = 1;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                movY -= 4;
                rotY1 = -1;
                break;
            case KeyEvent.VK_P:
                pause = !pause;
                if (pause) {
                    animator.pause();
                } else {
                    animator.resume();
                }
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
        }
        glDrawable.display();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                rotX1 = 0;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                rotX1 = 0;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                rotY1 = 0;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                rotY1 = 0;
                break;
        }
    }

   

    @Override
    public void mouseClicked(MouseEvent me) {
        statusproj(ctproj);
        ctproj++;
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}