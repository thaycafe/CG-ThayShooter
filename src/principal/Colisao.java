package principal;

import Asteroide.Asteroide;
import Inimigo.Inimigo;
import Nave.Explosao;
import Nave.Nave;
import Nave.Projetil;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;

public class Colisao {

    public boolean over = false;

    public void bateu(GL2 gl, GLU glu, Nave varNave, Asteroide varAsteroide, Explosao varExplosao) {
        if (varNave.nZ+10 == varAsteroide.Z) {
            if (varNave.nX + 8 >= varAsteroide.X - 5.5 && varNave.nX + 8 <= varAsteroide.X + 5.5
                    || varNave.nX - 8f >= varAsteroide.X - 5.5 && varNave.nX - 8 <= varAsteroide.X + 5.5
                    || varNave.nX >= varAsteroide.X - 5.5 && varNave.nX <= varAsteroide.X + 5.5) {
                if (varNave.nY + 8 >= varAsteroide.Y - 5.5 && varNave.nY + 8 <= varAsteroide.Y + 5.5
                        || varNave.nY - 8 >= varAsteroide.Y - 5.5 && varNave.nY - 8 <= varAsteroide.Y + 5.5
                        || varNave.nY >= varAsteroide.Y - 5.5 && varNave.nY <= varAsteroide.Y + 5.5) {
                    over = true;
                }
            }
        }
        if (varNave.nZ == varAsteroide.Z2) {
            if (varNave.nX + 8 >= varAsteroide.X2 - 5.5 && varNave.nX + 8 <= varAsteroide.X2 + 5.5
                    || varNave.nX - 8f >= varAsteroide.X2 - 5.5 && varNave.nX - 8 <= varAsteroide.X2 + 5.5
                    || varNave.nX >= varAsteroide.X2 - 5.5 && varNave.nX <= varAsteroide.X2 + 5.5) {
                if (varNave.nY + 8 >= varAsteroide.Y2 - 5.5 && varNave.nY + 8 <= varAsteroide.Y2 + 5.5
                        || varNave.nY - 8 >= varAsteroide.Y2 - 5.5 && varNave.nY - 8 <= varAsteroide.Y2 + 5.5
                        || varNave.nY >= varAsteroide.Y2 - 5.5 && varNave.nY <= varAsteroide.Y2 + 5.5) {
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
                    over = true;
                }
            }
        }
    }
    
    public void acertou(Projetil varProjetil, Asteroide varAsteroide){
        if (varProjetil.pZ == varAsteroide.Z) {
            if (varProjetil.pX >= varAsteroide.X - 5.5 && varProjetil.pX <= varAsteroide.X + 5.5) {
                if (varProjetil.pY >= varAsteroide.X - 5.5 && varProjetil.pY <= varAsteroide.Y + 5.5) {
                    System.out.println("acertou");
                }
            }
        }
    }
    
    public void acertou(Projetil varProjetil, Inimigo varInimigo){
        if (varProjetil.pZ == varInimigo.posZ) {
            if (varProjetil.pX >= varInimigo.posX - 9.5 && varProjetil.pX <= varInimigo.posX + 9.5) {
                if (varProjetil.pY >= varInimigo.posX - 9.5 && varProjetil.pY <= varInimigo.posY + 9.5) {
                    System.out.println("acertou");
                    
                }
            }
        }
    }
    
}
