package tic_tac_toe_0;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{
    private Button[] buttons;
    public static int index = -1;
    
    public Frame(int width, int height){ 
        this.setTitle("BOMBACOD");
        int sideButton = 80; 
        this.setVisible(true);
        this.setSize(width*sideButton+50,height*sideButton+50);
        this.setResizable(false);
        this.setLocation(340,20);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        
        buttons = new Button[width*height];
        
        int index = 0;
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                panel.add(buttons[index] = new Button(x,y,sideButton,index));
                index++;
            }
        } 
    }
    
    private void sleep(int value){
        try {
            Thread.sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cycle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pushReset(){ index = -1; }
    
    public int pushButton(){ 
        sleep(5);
        return index; 
    }
    
    public void update(String[] array){
        for(int i = 0;i<buttons.length;i++){
            buttons[i].setText(array[i]);
        }
    }
    
}
