package tic_tac_toe_0;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NewFrame extends JFrame{
    private Button[] buttons;
    
    public NewFrame(int width, int height, String[] array, String text){ 
        super(text);
        this.setVisible(true);
        this.setSize(width*100+50,height*100+50);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        
        buttons = new Button[width*height];
        
        int index = 0;
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                panel.add(buttons[index] = new Button(x,y,80,index));
                index++;
            }
        } 
        
        update(array);
        sleep(1000);
    }
    
    private void sleep(int value){
        try {
            Thread.sleep(value);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cycle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(String[] array){
        for(int i = 0;i<buttons.length;i++){
            buttons[i].setText(array[i]);
        }
    }
    
}
