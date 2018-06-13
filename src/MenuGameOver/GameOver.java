
package MenuGameOver;

import com.jogamp.opengl.GL2;
import static com.jogamp.opengl.GL2ES3.GL_QUADS;
import com.jogamp.opengl.util.gl2.GLUT;

public class GameOver {
    public void TextGameOver(GL2 gl, GLUT glut, int p){
        gl.glPushMatrix();   
           String [] msgs = {
            "Sair",
            "Voltar ao Menu Principal",
            "Tentar Novamente"};
           String score = "Pontuação: ";
           String over = "Game Over";
           
           int x = -15, y=-5;
            for (int i=0; i<3;i++){
                gl.glRasterPos2i(x,y); // ajusta a posição na tela
                glut.glutBitmapString(5, msgs[i]);
                y+= 7;
            }
            gl.glRasterPos2i(-15,15);
            glut.glutBitmapString(5, score);
            
            gl.glRasterPos2i(-1,15);
            glut.glutBitmapString(5, Integer.toString(p));
                       
            gl.glRasterPos2i(-5,23);
            glut.glutBitmapString(5, over);
            
        gl.glPopMatrix();   
           
           
           
    }
}
