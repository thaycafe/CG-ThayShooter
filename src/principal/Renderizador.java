package principal;

import Asteroide.Asteroide;
import Inimigo.Inimigo;
import MenuGameOver.GameOver;
import MenuStart.MenuStart;
import Nave.Nave;
import Nave.Projetil;
import Planeta.Planeta;
import java.util.Random;
import com.jogamp.opengl.GL;
import java.awt.event.KeyListener;
import com.jogamp.opengl.GL2;
import static com.jogamp.opengl.GL2ES3.GL_QUADS;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;
import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Renderizador implements GLEventListener, KeyListener, MouseListener {

    private GL2 gl;
    private GLU glu;
    private GLUT glut;
    private GLAutoDrawable glDrawable;
    private double angulo, aspecto;
    private float rotX, rotY, obsZ, movX, movY, rotX1, movZ, rotY1;
    private boolean luz, menupause, menuGameOver;
    private Random random, random2, random3, random4, random5;
    private int ctproj, timerP;
    Asteroide aster = new Asteroide();
    Asteroide aster2 = new Asteroide();
    MenuStart menu = new MenuStart();
    MenuPrincipal princ = new MenuPrincipal();
    GameOver gameover = new GameOver();
    private int pont;

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

    public Renderizador(FPSAnimator animator, JFrame x) {
        angulo = 50;
        aspecto = 1;
        rotX = 0;
        rotY = 0;
        obsZ = -200;
        movX = 0;
        movY = 0;
        rotX1 = 0;
        rotY1 = 0;
        ctproj = 0;
        this.animator = animator;
        this.x = x;
        random = new Random();
        random2 = new Random();
        random3 = new Random();
        random4 = new Random();
        random5 = new Random();
        pont = 0;
        luz = true;
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

        try {
            x.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("/Nave/mira.png")).getImage(), new Point(0, 0), "custom cursor"));
        } catch (Exception e) {
        }
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
        defineIluminacao();
        inimigo.timer++;
        timerP++;
        aster.timer2++;
        aster.timer3++;
        aster.timer4++;
        aster.timer5++;
        pont++;
        especificaParametrosVisualizacao();
        movimento();

        gl.glPushMatrix();
        if (menuGameOver == true) {
            gl.glPushMatrix();
            gl.glTranslatef(0, 0, movZ + 100);
            gameover.TextGameOver(gl, glut, pont);
            gl.glPopMatrix();
            gl.glBegin(GL_QUADS);

            gl.glEnd();
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, 0, movZ);
        gl.glRasterPos2i(80, 80);
        glut.glutBitmapString(5, "Pontuação: ");
        gl.glRasterPos2i(110, 80);
        glut.glutBitmapString(5, Integer.toString(pont));
        gl.glPopMatrix();

        gl.glPushMatrix();
        if (menupause == true) {
            gl.glPushMatrix();
            gl.glTranslatef(0, 0, movZ + 100);
            menu.TextPause(gl, glut, pont);
            gl.glPopMatrix();
            gl.glBegin(GL_QUADS);

            gl.glEnd();
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        projeteis();
        gl.glPopMatrix();

        gl.glPushMatrix();
        mostrarPlanets(timerP);
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
        gl.glPushMatrix();
        gl.glPushMatrix();
        gl.glPushMatrix();
        aster.Aster(gl, glu);
        gl.glTranslatef(aster.X, aster.Y, aster.Z);
        aster.Z += 2;
        if (aster.timer2 == 105) {
            aster.reinicia((random2.nextInt(200) - 100), (random2.nextInt(200) - 100), (movZ - 300));
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        aster.Aster2(gl, glu);
        gl.glTranslatef(aster.X2, aster.Y2, aster.Z2);
        aster.Z2 += 3;
        if (aster.timer3 == 135) {
            aster.reinicia2((random3.nextInt(200) - 100), (random3.nextInt(200) - 100), (movZ - 300));
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        aster.Aster3(gl, glu);
        gl.glTranslatef(aster.X3, aster.Y3, aster.Z3);
        aster.Z3 += 1;
        if (aster.timer4 == 125) {
            aster.reinicia3((random4.nextInt(200) - 100), (random4.nextInt(200) - 100), (movZ - 300));
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        aster.Aster4(gl, glu);
        gl.glTranslatef(aster.X4, aster.Y4, aster.Z4);
        aster.Z4 += 2;
        if (aster.timer5 == 120) {
            aster.reinicia4((random5.nextInt(200) - 100), (random5.nextInt(200) - 100), (movZ - 300));
        }
        gl.glPopMatrix();
        gl.glPopMatrix();
        gl.glPopMatrix();
        gl.glPopMatrix();

    }

    public void movimento() {
        movZ -= 2;
        obsZ += 2;
    }

    public void projeteis() {
        if (proj2.isAtivo()) {
            proj2.formaProjetil(gl, glu);
        }
        if (proj1.isAtivo()) {
            proj1.formaProjetil(gl, glu);
        }
        if (proj3.isAtivo()) {
            proj3.formaProjetil(gl, glu);
        }
        if (proj4.isAtivo()) {
            proj4.formaProjetil(gl, glu);
        }
        if (proj5.isAtivo()) {
            proj5.formaProjetil(gl, glu);
        }
    }

    public void statusproj(int n) {
        if (n == 0) {
            proj1.setpX(movX);
            proj1.setpY(movY);
            proj1.setpZ(movZ);
            proj1.setAtivo(true);
        } else if (n == 1) {
            proj2.setpX(movX);
            proj2.setpY(movY);
            proj2.setpZ(movZ);
            proj2.setAtivo(true);
        } else if (n == 2) {
            proj3.setpX(movX);
            proj3.setpY(movY);
            proj3.setpZ(movZ);
            proj3.setAtivo(true);
        } else if (n == 3) {
            proj4.setpX(movX);
            proj4.setpY(movY);
            proj4.setpZ(movZ);
            proj4.setAtivo(true);
        } else if (n == 4) {
            proj5.setpX(movX);
            proj5.setpY(movY);
            proj5.setpZ(movZ);
            proj5.setAtivo(true);
        }

    }

    public void mostrarPlanets(int timer) {
        if (timer < 250) {
            if (timer == 1) {
                planet.setPosZFinal(movZ - 400);
            }
            planet.renderizaPlaneta(gl, glu, "Terra");
        } else {
            if (timer >= 250 && timer < 500) {
                if (timer == 250) {
                    planet.setPosZFinal(movZ - 400);
                }
                planet.renderizaPlaneta(gl, glu, "Mars");
            } else {
                if (timer >= 500 && timer < 750) {
                    if (timer == 500) {
                        planet.setPosZFinal(movZ - 400);
                    }
                    planet.renderizaPlaneta(gl, glu, "Saturn");
                } else {
                    if (timer >= 750 && timer < 1000) {
                        if (timer == 750) {
                            planet.setPosZFinal(movZ - 400);
                        }
                        planet.renderizaPlaneta(gl, glu, "Uranus");
                    } else {
                        if (timer >= 1000 && timer < 1250) {
                            if (timer == 1000) {
                                planet.setPosZFinal(movZ - 400);
                            }
                            planet.renderizaPlaneta(gl, glu, "Jupter");
                        } else {
                            timerP = 0;
                        }

                    }
                }
            }
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
                if (menupause == false) {
                    movX -= 4;
                    rotX1 = 1;
                }
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (menupause == false) {
                    movX += 4;
                    rotX1 = -1;
                }
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                if (menupause == false) {
                    movY += 4;
                    rotY1 = 1;
                }
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if (menupause == false) {
                    movY -= 4;
                    rotY1 = -1;
                }
                break;
            case KeyEvent.VK_P:
                pause = !pause;
                if (pause) {
                    animator.pause();
                    menupause = true;
                } else {
                    menupause = false;
                    animator.resume();
                }
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            case KeyEvent.VK_0:
                menuGameOver = true;
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
        System.out.printf("X: %d", me.getX());
        System.out.printf("Y: %d", me.getY());
        System.out.println("");
        if (menupause == true) {
            if (me.getX() >= 604 && me.getX() <= 704 && me.getY() >= 227 && me.getY() <= 258) {
                animator.resume();
                menupause = false;
            }

            if (me.getX() >= 585 && me.getX() <= 708 && me.getY() >= 291 && me.getY() <= 316) {
                System.gc();
                for (Window window : Window.getWindows()) {
                    window.dispose();
                }
                JogoCGv2 app = new JogoCGv2();
            }

            if (me.getX() >= 580 && me.getX() <= 634 && me.getY() >= 369 && me.getY() <= 396) {;
                System.exit(0);
            }
        }

        if (menuGameOver == true) {
            animator.pause();
            if (me.getX() >= 509 && me.getX() <= 704 && me.getY() >= 206 && me.getY() <= 237) {
                System.gc();
                for (Window window : Window.getWindows()) {
                    window.dispose();
                }
                System.out.println("deu certo");
                JogoCGv2 app = new JogoCGv2();
            }
            if (me.getX() >= 503 && me.getX() <= 563 && me.getY() >= 367 && me.getY() <= 400) {;
                System.out.println("deu certo 2");
                System.exit(0);
            }
            if (me.getX() >= 522 && me.getX() <= 788 && me.getY() >= 305 && me.getY() <= 343) {;
                System.gc();
                for (Window window : Window.getWindows()) {
                    window.dispose();
                }
                MenuPrincipal obj = new MenuPrincipal();
                obj.setSize(500, 300);
                obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                obj.setVisible(true);
                obj.getContentPane().setBackground(Color.black);
                obj.setLocationRelativeTo(null);
            }

        }

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

    public void defineIluminacao() {

        gl.glShadeModel(GL2.GL_FLAT);

        float luzAmbiente[] = {1.0f, 1.0f, 1.0f, 0.5f};
        gl.glLightModelfv(GL2.GL_LIGHT_MODEL_TWO_SIDE, luzAmbiente, 0);
        gl.glColorMaterial(GL2.GL_FRONT, GL2.GL_DIFFUSE);

        float posicaoLuz[] = {-150, 50, 100, 0};
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, luzAmbiente, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, posicaoLuz, 0);

        float especularidade[] = {1.0f, 0.5f, 1.0f, 1.0f};
        int especMaterial = 10;
        gl.glMaterialfv(GL.GL_FRONT, GL2.GL_SPECULAR, especularidade, 0);
        gl.glMateriali(GL.GL_FRONT, GL2.GL_SHININESS, especMaterial);

        if (luz) {
            gl.glEnable(GL2.GL_LIGHT0);
            gl.glEnable(GL2.GL_LIGHT1);
            gl.glEnable(GL2.GL_LIGHTING);
            gl.glEnable(GL2.GL_COLOR_MATERIAL);
        } else {
            gl.glDisable(GL2.GL_LIGHT0);
            gl.glDisable(GL2.GL_LIGHT1);
            gl.glDisable(GL2.GL_LIGHTING);
            gl.glDisable(GL2.GL_COLOR_MATERIAL);
        }
    }

}
