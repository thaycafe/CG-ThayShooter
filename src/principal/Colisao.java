package principal;

import Asteroide.Asteroide;
import Inimigo.Inimigo;
import Nave.Explosao;
import Nave.Nave;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;

public class Colisao {

    public boolean over = false;

    public void bateu(GL2 gl, GLU glu, Nave varNave, Asteroide varAsteroide, Explosao varExplosao) {
        if (varNave.nZ == varAsteroide.Z) {
            if (varNave.nX + 8 >= varAsteroide.X - 5.5 && varNave.nX + 8 <= varAsteroide.X + 5.5
                    || varNave.nX - 8f >= varAsteroide.X - 5.5 && varNave.nX - 8 <= varAsteroide.X + 5.5
                    || varNave.nX >= varAsteroide.X - 5.5 && varNave.nX <= varAsteroide.X + 5.5) {
                if (varNave.nY + 8 >= varAsteroide.Y - 5.5 && varNave.nY + 8 <= varAsteroide.Y + 5.5
                        || varNave.nY - 8 >= varAsteroide.Y - 5.5 && varNave.nY - 8 <= varAsteroide.Y + 5.5
                        || varNave.nY >= varAsteroide.Y - 5.5 && varNave.nY <= varAsteroide.Y + 5.5) {
                   fudeu(gl, glu, varNave, varExplosao);
                    over = true;
                }
            }
        }
        if (varNave.nZ == varAsteroide.Z2) {
            if (varNave.nX + 8 >= varAsteroide.X2 - 5.5 && varNave.nX + 8 <= varAsteroide.X2 + 5.5
                    || varNave.nX - 8f >= varAsteroide.X - 5.5 && varNave.nX - 8 <= varAsteroide.X + 5.5
                    || varNave.nX >= varAsteroide.X2 - 5.5 && varNave.nX <= varAsteroide.X2 + 5.5) {
                if (varNave.nY + 8 >= varAsteroide.Y2 - 5.5 && varNave.nY + 8 <= varAsteroide.Y2 + 5.5
                        || varNave.nY - 8 >= varAsteroide.Y2 - 5.5 && varNave.nY - 8 <= varAsteroide.Y2 + 5.5
                        || varNave.nY >= varAsteroide.Y2 - 5.5 && varNave.nY <= varAsteroide.Y2 + 5.5) {
                    fudeu(gl, glu, varNave, varExplosao);
                    over = true;
                }
            }
        }
        if (varNave.nZ == varAsteroide.Z3) {
            if (varNave.nX + 8 >= varAsteroide.X3 - 5.5 && varNave.nX + 8 <= varAsteroide.X3 + 5.5
                    || varNave.nX - 8f >= varAsteroide.X3 - 5.5 && varNave.nX - 8 <= varAsteroide.X3 + 5.5
                    || varNave.nX >= varAsteroide.X3 - 5.5 && varNave.nX <= varAsteroide.X3 + 5.5) {
                if (varNave.nY + 8 >= varAsteroide.Y3 - 5.5 && varNave.nY + 8 <= varAsteroide.Y3 + 5.5
                        || varNave.nY - 8 >= varAsteroide.Y3 - 5.5 && varNave.nY - 8 <= varAsteroide.Y3 + 5.5
                        || varNave.nY >= varAsteroide.Y3 - 5.5 && varNave.nY <= varAsteroide.Y3 + 5.5) {
                   fudeu(gl, glu, varNave, varExplosao);
                    over = true;
                }
            }
        }
        if (varNave.nZ == varAsteroide.Z4) {
            if (varNave.nX + 8 >= varAsteroide.X4 - 5.5 && varNave.nX + 8 <= varAsteroide.X4 + 5.5
                    || varNave.nX - 8f >= varAsteroide.X4 - 5.5 && varNave.nX - 8 <= varAsteroide.X4 + 5.5
                    || varNave.nX >= varAsteroide.X4 - 5.5 && varNave.nX <= varAsteroide.X4 + 5.5) {
                if (varNave.nY + 8 >= varAsteroide.Y4 - 5.5 && varNave.nY + 8 <= varAsteroide.Y4 + 5.5
                        || varNave.nY - 8 >= varAsteroide.Y4 - 5.5 && varNave.nY - 8 <= varAsteroide.Y4 + 5.5
                        || varNave.nY >= varAsteroide.Y4 - 5.5 && varNave.nY <= varAsteroide.Y4 + 5.5) {
                    fudeu(gl, glu, varNave, varExplosao);
                    over = true;
                }
            }
        }
    }

    public void bateu(GL2 gl, GLU glu, Nave varNave, Inimigo varInimigo, Explosao varExplosao) {
        if (varNave.nZ == varInimigo.posZ) {
            if (varNave.nX + 8 >= varInimigo.posX - 9.5 && varNave.nX + 8 <= varInimigo.posX + 9.5
                    || varNave.nX - 8f >= varInimigo.posX - 9.5 && varNave.nX - 8 <= varInimigo.posX + 9.5
                    || varNave.nX >= varInimigo.posX - 9.5 && varNave.nX <= varInimigo.posX + 9.5) {
                System.out.println("bateux");
                if (varNave.nY + 8 >= varInimigo.posY - 9.5 && varNave.nY + 8 <= varInimigo.posY + 9.5
                        || varNave.nY - 8 >= varInimigo.posY - 9.5 && varNave.nY - 8 <= varInimigo.posY + 9.5
                        || varNave.nY >= varInimigo.posY - 9.5 && varNave.nY <= varInimigo.posY + 9.5) {
                    fudeu(gl, glu, varNave, varExplosao);
                    over = true;
                }
            }
        }
    }

    public void fudeu(GL2 gl, GLU glu, Nave varNave, Explosao varExplosao) {
        varExplosao.eX = varNave.nX;
        varExplosao.eY = varNave.nY;
        varExplosao.eZ = varNave.nZ + 10;
        varExplosao.ExplosaoColisao(gl, glu);
    }
}
