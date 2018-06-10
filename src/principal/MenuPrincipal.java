
package principal;

import java.awt.Color;
import static java.awt.Color.white;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MenuPrincipal extends JFrame{
    
    private boolean volt = false;
    private JLabel titulo,inst;
    private JTextArea txt, txt2;
    private JButton play,instrucoes,sair,voltar, cred;
    
    public MenuPrincipal(){
        setLayout(null);
        
        inst = new JLabel("Instruções");
        inst.setForeground(Color.white);
        inst.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 25));
        inst.setBounds(185, 91, 400, 35);
        add(inst);
        inst.setVisible(false);
        
        titulo = new JLabel("ThayShooter");
        titulo.setForeground(Color.white);
        titulo.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 40));
        titulo.setBounds(120, 40, 400, 45);
        add(titulo);
        
        play = new JButton("Jogar");
        play.setBackground(Color.white);
        play.setBounds(215, 100, 71, 25);
        add(play);
        
        instrucoes = new JButton("Instruções");        
        instrucoes.setBackground(Color.white);       
        instrucoes.setBounds(195, 140, 109, 25);
        add(instrucoes);
        
        cred = new JButton("Créditos");
        cred.setBackground(Color.white);        
        cred.setBounds(201, 180, 96, 25);
        add(cred);
        
        sair = new JButton("Sair");
        sair.setBackground(Color.white);        
        sair.setBounds(215, 220, 71, 25);
        add(sair);
        
        voltar = new JButton("Voltar");
        voltar.setBackground(Color.white);
        voltar.setBounds(215, 255, 80, 25);
        add(voltar);
        voltar.setVisible(false);
            
        txt = new JTextArea("1) Desvie dos meteoritos\n"
                + "2) Destrua as naves\n"
                + "3) Não deixe as naves te acertarem\n"
                + "4) Desvie dos Planetas\n"
                + "5) É possivel destruir os meteoritos\n"
                + "6) Os Planetas são indestrutiveis"); 
        txt.setForeground(Color.white);
        txt.setBackground(Color.black);
        txt.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 16));
        txt.setBounds(115,130, 500, 115);
        add(txt);
        txt.setVisible(false);
        
        txt2 = new JTextArea("Thaynara Mendes\n"
                + "Victor França\n"
                + "Ronan Fernandes\n"
                + "João Paulo Cossi"); 
        txt2.setForeground(Color.white);
        txt2.setBackground(Color.black);
        txt2.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 18));
        txt2.setBounds(165,120, 500, 115);
        add(txt2);
        txt2.setVisible(false);
        
        

        ButtonHandler handler = new ButtonHandler();
        play.addActionListener(handler);
        instrucoes.addActionListener(handler);
        sair.addActionListener(handler);
        voltar.addActionListener(handler);
        cred.addActionListener(handler);
    }
        
    private class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == play){
                JogoCGv2 app = new JogoCGv2();
                dispose();
            }
            if(e.getSource() == instrucoes){
                play.setVisible(false);
                sair.setVisible(false);
                instrucoes.setVisible(false);
                txt2.setVisible(false);
                cred.setVisible(false);
                voltar.setVisible(true);
                txt.setVisible(true);
                inst.setVisible(true);        
            }
            if(e.getSource() == sair){
                System.exit(0);
            }
            if(e.getSource() == voltar){
                play.setVisible(true);
                instrucoes.setVisible(true);
                sair.setVisible(true); 
                cred.setVisible(true);
                voltar.setVisible(false);
                txt.setVisible(false);
                txt2.setVisible(false);
                inst.setVisible(false);
            }
            if(e.getSource() == cred){
                play.setVisible(false);
                sair.setVisible(false);
                instrucoes.setVisible(false);
                voltar.setVisible(true);
                txt2.setVisible(true); 
                cred.setVisible(false);
            }
            
        }      
        
    }
    
    
    
    
}
