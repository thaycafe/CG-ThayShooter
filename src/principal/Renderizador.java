package principal;

import Asteroide.Asteroide;
import Estrelas.Estrelas;
import Inimigo.Inimigo;
import MenuGameOver.GameOver;
import MenuStart.MenuStart;
import Nave.Explosao;
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
    private float rotX, rotY, obsZ, rotX1, rotY1;
    private boolean luz, menupause, menuGameOver;
    private Random random, random2, random3, random4, random5, randomEst;
    private int ctproj, timerP;
    Asteroide aster = new Asteroide();
    MenuStart menu = new MenuStart();
    MenuPrincipal princ = new MenuPrincipal();
    GameOver gameover = new GameOver();
    Explosao explosao = new Explosao();
    private int pont;
    Colisao colisao = new Colisao();
    JFrame x;
    FPSAnimator animator;
    public boolean pause;
    Nave nave = new Nave();
    Estrelas est1 = new Estrelas();
    Estrelas est2 = new Estrelas();
    Estrelas est3 = new Estrelas();
    Estrelas est4 = new Estrelas();
    Estrelas est5 = new Estrelas();
    Estrelas est6 = new Estrelas();
    Estrelas est7 = new Estrelas();
    Estrelas est8 = new Estrelas();
    Estrelas est9 = new Estrelas();
    Estrelas est10 = new Estrelas();
    Estrelas est11 = new Estrelas();
    Estrelas est12 = new Estrelas();
    Estrelas est13 = new Estrelas();
    Estrelas est14 = new Estrelas();
    Estrelas est15 = new Estrelas();
    Estrelas est16 = new Estrelas();
    Estrelas est17 = new Estrelas();
    Estrelas est18 = new Estrelas();
    Estrelas est19 = new Estrelas();
    Estrelas est20 = new Estrelas();
    Estrelas est21 = new Estrelas();
    Estrelas est22 = new Estrelas();
    Estrelas est23 = new Estrelas();
    Estrelas est24 = new Estrelas();
    Estrelas est25 = new Estrelas();
    Estrelas est26 = new Estrelas();
    Estrelas est27 = new Estrelas();
    Estrelas est28 = new Estrelas();
    Estrelas est29 = new Estrelas();
    Estrelas est30 = new Estrelas();
    Estrelas est31 = new Estrelas();
    Estrelas est32 = new Estrelas();
    Estrelas est33 = new Estrelas();
    Estrelas est34 = new Estrelas();
    Estrelas est35 = new Estrelas();
    Estrelas est36 = new Estrelas();
    Estrelas est37 = new Estrelas();
    Estrelas est38 = new Estrelas();
    Estrelas est39 = new Estrelas();

    Planeta planet = new Planeta();
    Projetil proj1 = new Projetil();
    Projetil proj2 = new Projetil();
    Projetil proj3 = new Projetil();
    Projetil proj4 = new Projetil();
    Projetil proj5 = new Projetil();
    Projetil proj6 = new Projetil();
    Projetil proj7 = new Projetil();
    Projetil proj8 = new Projetil();
    Projetil proj9 = new Projetil();
    Projetil proj10 = new Projetil();

    Inimigo inimigo = new Inimigo();

    public Renderizador(FPSAnimator animator, JFrame x) {
        angulo = 50;
        aspecto = 1;
        rotX = 0;
        rotY = 0;
        obsZ = -200;
        nave.nX = 0;
        nave.nY = 0;
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
        explosao.textColisao();
        nave.texturaNave();
        planet.carregarTextura();
        proj2.textura();
        proj1.textura();
        proj3.textura();
        proj4.textura();
        proj5.textura();
        proj6.textura();
        proj7.textura();
        proj8.textura();
        proj9.textura();
        proj10.textura();
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
        colisao.bateu(gl, glu, nave, aster, explosao);
        colisao.bateu(gl, glu, nave, inimigo, explosao);
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

        est1.formaEstrela(gl, glu);
        est2.formaEstrela(gl, glu);
        est3.formaEstrela(gl, glu);
        est4.formaEstrela(gl, glu);
        est5.formaEstrela(gl, glu);
        est6.formaEstrela(gl, glu);
        est7.formaEstrela(gl, glu);
        est8.formaEstrela(gl, glu);
        est9.formaEstrela(gl, glu);
        est10.formaEstrela(gl, glu);
        est11.formaEstrela(gl, glu);
        est12.formaEstrela(gl, glu);
        est13.formaEstrela(gl, glu);
        est14.formaEstrela(gl, glu);
        est15.formaEstrela(gl, glu);
        est16.formaEstrela(gl, glu);
        est17.formaEstrela(gl, glu);
        est18.formaEstrela(gl, glu);
        est19.formaEstrela(gl, glu);
        est20.formaEstrela(gl, glu);
        est21.formaEstrela(gl, glu);
        est22.formaEstrela(gl, glu);
        est23.formaEstrela(gl, glu);
        est24.formaEstrela(gl, glu);
        est25.formaEstrela(gl, glu);
        est26.formaEstrela(gl, glu);
        est27.formaEstrela(gl, glu);
        est28.formaEstrela(gl, glu);
        est29.formaEstrela(gl, glu);
        est30.formaEstrela(gl, glu);
        est31.formaEstrela(gl, glu);
        est32.formaEstrela(gl, glu);
        est33.formaEstrela(gl, glu);
        est34.formaEstrela(gl, glu);
        est35.formaEstrela(gl, glu);
        est36.formaEstrela(gl, glu);
        est37.formaEstrela(gl, glu);
        est38.formaEstrela(gl, glu);
        est39.formaEstrela(gl, glu);

        gl.glPopMatrix();

        gl.glPushMatrix();
        menuGameOver = colisao.over;
        if (menuGameOver == true) {
            animator.pause();
            gl.glPushMatrix();
            gl.glTranslatef(0, 0, nave.nZ + 100);
            gameover.TextGameOver(gl, glut, pont);
            gl.glPopMatrix();
            gl.glBegin(GL_QUADS);

            gl.glEnd();
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, 0, nave.nZ);
        gl.glRasterPos2i(80, 80);
        glut.glutBitmapString(5, "Pontuação: ");
        gl.glRasterPos2i(110, 80);
        glut.glutBitmapString(5, Integer.toString(pont));
        gl.glPopMatrix();

        gl.glPushMatrix();
        if (menupause == true) {
            gl.glPushMatrix();
            gl.glTranslatef(0, 0, nave.nZ + 100);
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
        gl.glTranslatef(nave.nX, nave.nY, nave.nZ);
        gl.glRotatef(15, rotY1, 0, rotX1);
        nave.formaNave(gl, glu);
        gl.glPopMatrix();

        gl.glPushMatrix();
        inimigo.renderizaNave(gl, glu);
        gl.glTranslatef(inimigo.posX, inimigo.posY, inimigo.posZ);
        if (inimigo.timer == 200) {
            inimigo.reiniciar((random.nextInt(200) - 100), (random.nextInt(200) - 100), (nave.nZ - 300));
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
            aster.reinicia((random2.nextInt(200) - 100), (random2.nextInt(200) - 100), (nave.nZ - 300));
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        aster.Aster2(gl, glu);
        gl.glTranslatef(aster.X2, aster.Y2, aster.Z2);
        aster.Z2 += 3;
        if (aster.timer3 == 135) {
            aster.reinicia2((random3.nextInt(200) - 100), (random3.nextInt(200) - 100), (nave.nZ - 300));
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        aster.Aster3(gl, glu);
        gl.glTranslatef(aster.X3, aster.Y3, aster.Z3);
        aster.Z3 += 1;
        if (aster.timer4 == 125) {
            aster.reinicia3((random4.nextInt(200) - 100), (random4.nextInt(200) - 100), (nave.nZ - 300));
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        aster.Aster4(gl, glu);
        gl.glTranslatef(aster.X4, aster.Y4, aster.Z4);
        aster.Z4 += 2;
        if (aster.timer5 == 120) {
            aster.reinicia4((random5.nextInt(200) - 100), (random5.nextInt(200) - 100), (nave.nZ - 300));
        }
        gl.glPopMatrix();
        gl.glPopMatrix();
        gl.glPopMatrix();
        gl.glPopMatrix();

    }

    public void movimento() {
        nave.nZ -= 2;
        est1.setZ(est1.getZ() - 2);
        est2.setZ(est2.getZ() - 2);
        est3.setZ(est3.getZ() - 2);
        est4.setZ(est4.getZ() - 2);
        est5.setZ(est5.getZ() - 2);
        est6.setZ(est6.getZ() - 2);
        est7.setZ(est7.getZ() - 2);
        est8.setZ(est8.getZ() - 2);
        est9.setZ(est9.getZ() - 2);
        est10.setZ(est10.getZ() - 2);
        est11.setZ(est11.getZ() - 2);
        est12.setZ(est12.getZ() - 2);
        est13.setZ(est13.getZ() - 2);
        est14.setZ(est14.getZ() - 2);
        est15.setZ(est15.getZ() - 2);
        est16.setZ(est16.getZ() - 2);
        est17.setZ(est17.getZ() - 2);
        est18.setZ(est18.getZ() - 2);
        est19.setZ(est19.getZ() - 2);
        est20.setZ(est20.getZ() - 2);
        est21.setZ(est21.getZ() - 2);
        est22.setZ(est22.getZ() - 2);
        est23.setZ(est23.getZ() - 2);
        est24.setZ(est24.getZ() - 2);
        est25.setZ(est25.getZ() - 2);
        est26.setZ(est26.getZ() - 2);
        est27.setZ(est27.getZ() - 2);
        est28.setZ(est28.getZ() - 2);
        est29.setZ(est29.getZ() - 2);
        est30.setZ(est30.getZ() - 2);
        est31.setZ(est31.getZ() - 2);
        est32.setZ(est32.getZ() - 2);
        est33.setZ(est33.getZ() - 2);
        est34.setZ(est34.getZ() - 2);
        est35.setZ(est35.getZ() - 2);
        est36.setZ(est36.getZ() - 2);
        est37.setZ(est37.getZ() - 2);
        est38.setZ(est38.getZ() - 2);
        est39.setZ(est39.getZ() - 2);
        obsZ += 2;
    }

    public void projeteis() {
        if (proj1.isAtivo()) {
            proj1.formaProjetil(gl, glu);
            proj1.pZ -= 5;
        }
        if (proj2.isAtivo()) {
            proj2.formaProjetil(gl, glu);
            proj2.pZ -= 5;
        }
        if (proj3.isAtivo()) {
            proj3.formaProjetil(gl, glu);
            proj3.pZ -= 5;
        }
        if (proj4.isAtivo()) {
            proj4.formaProjetil(gl, glu);
            proj4.pZ -= 5;
        }
        if (proj5.isAtivo()) {
            proj5.formaProjetil(gl, glu);
            proj5.pZ -= 5;
        }
        if (proj6.isAtivo()) {
            proj6.formaProjetil(gl, glu);
            proj6.pZ -= 5;
        }
        if (proj7.isAtivo()) {
            proj8.formaProjetil(gl, glu);
            proj8.pZ -= 5;
        }
        if (proj8.isAtivo()) {
            proj8.formaProjetil(gl, glu);
            proj8.pZ -= 5;
        }
        if (proj9.isAtivo()) {
            proj9.formaProjetil(gl, glu);
            proj9.pZ -= 5;
        }
        if (proj10.isAtivo()) {
            proj10.formaProjetil(gl, glu);
            proj10.pZ -= 5;
        }
    }

    public void statusproj(int n) {
        if (n == 0) {
            proj1.setpX(nave.nX);
            proj1.setpY(nave.nY);
            proj1.setpZ(nave.nZ);
            proj1.setAtivo(true);
        } else if (n == 1) {
            proj2.setpX(nave.nX);
            proj2.setpY(nave.nY);
            proj2.setpZ(nave.nZ);
            proj2.setAtivo(true);
        } else if (n == 2) {
            proj3.setpX(nave.nX);
            proj3.setpY(nave.nY);
            proj3.setpZ(nave.nZ);
            proj3.setAtivo(true);
        } else if (n == 3) {
            proj4.setpX(nave.nX);
            proj4.setpY(nave.nY);
            proj4.setpZ(nave.nZ);
            proj4.setAtivo(true);
        } else if (n == 4) {
            proj5.setpX(nave.nX);
            proj5.setpY(nave.nY);
            proj5.setpZ(nave.nZ);
            proj5.setAtivo(true);
        } else if (n == 5) {
            proj6.setpX(nave.nX);
            proj6.setpY(nave.nY);
            proj6.setpZ(nave.nZ);
            proj6.setAtivo(true);
        } else if (n == 6) {
            proj7.setpX(nave.nX);
            proj7.setpY(nave.nY);
            proj7.setpZ(nave.nZ);
            proj7.setAtivo(true);
        } else if (n == 7) {
            proj8.setpX(nave.nX);
            proj8.setpY(nave.nY);
            proj8.setpZ(nave.nZ);
            proj8.setAtivo(true);
        } else if (n == 8) {
            proj9.setpX(nave.nX);
            proj9.setpY(nave.nY);
            proj9.setpZ(nave.nZ);
            proj9.setAtivo(true);
        } else if (n == 9) {
            proj10.setpX(nave.nX);
            proj10.setpY(nave.nY);
            proj10.setpZ(nave.nZ);
            proj10.setAtivo(true);
        }
    }

    public void mostrarPlanets(int timer) {
        if (timer < 250) {
            if (timer == 1) {
                planet.setPosZFinal(nave.nZ - 400);
            }
            planet.renderizaPlaneta(gl, glu, "Terra");
        } else {
            if (timer >= 250 && timer < 500) {
                if (timer == 250) {
                    planet.setPosZFinal(nave.nZ - 400);
                }
                planet.renderizaPlaneta(gl, glu, "Mars");
            } else {
                if (timer >= 500 && timer < 750) {
                    if (timer == 500) {
                        planet.setPosZFinal(nave.nZ - 400);
                    }
                    planet.renderizaPlaneta(gl, glu, "Saturn");
                } else {
                    if (timer >= 750 && timer < 1000) {
                        if (timer == 750) {
                            planet.setPosZFinal(nave.nZ - 400);
                        }
                        planet.renderizaPlaneta(gl, glu, "Uranus");
                    } else {
                        if (timer >= 1000 && timer < 1250) {
                            if (timer == 1000) {
                                planet.setPosZFinal(nave.nZ - 400);
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
                    if (nave.nX <= -150) {
                        nave.nX = -150;
                    }
                    nave.nX -= 6;
                    rotX1 = 1;
                }
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (menupause == false) {
                    if (nave.nX >= 150) {
                        nave.nX = 150;
                    }
                    nave.nX += 6;
                    rotX1 = -1;
                }
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                if (menupause == false) {
                    if (nave.nY >= 80) {
                        nave.nY = 80;
                    }
                    nave.nY += 6;
                    rotY1 = 1;
                }
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if (menupause == false) {
                    if (nave.nY <= -75) {
                        nave.nY = -75;
                    }
                    nave.nY -= 6;
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
        if (ctproj == 9) {
            ctproj = 0;
        }
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
