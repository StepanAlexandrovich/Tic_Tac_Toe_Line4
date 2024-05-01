package tic_tac_toe_0;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Button extends JButton{
    private int index;
    
    public Button(int x,int y,int side,int index){
        this.index = index; 
        this.setBounds(x*side,y*side,side,side);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 30);//Тут все про шрифт)
        this.setBackground(Color.WHITE);
        this.setFont(BigFontTR);//применяем шрифт к кнопке
        this.addActionListener(new MyKeyAdapter());
    }
     
    private class MyKeyAdapter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) { 
            Frame.index = index;
        }
    }
}
