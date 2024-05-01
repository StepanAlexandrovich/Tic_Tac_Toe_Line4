package tic_tac_toe_0;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cycle{
    private static StartFrame startFrame;
    /////////////////////////////////////
    public static int width,height;
    public static boolean startMove;
    private static Logic logic;
    private static Frame frame;
    
    private static void action(String text){
        JOptionPane.showMessageDialog(startFrame,text);
    }
    
    private static boolean result(String result){
        if(result=="X"&&startMove)  { action("YUO LOSE"); return true; }
        if(result=="0"&&startMove)  { action("YUO WON");  return true; }
        if(result=="0"&&!startMove) { action("YUO LOSE"); return true; }
        if(result=="X"&&!startMove) { action("YUO WON");  return true; }
        if(result=="deadlock") { action("DRAW");     return true;}
        return false;
    }
    
    public static void main(String[] args) {
        startFrame = new StartFrame();
        
        while(true){
            
            startFrame.permission = true;
            while(!startFrame.start){ sleep(1); }
            startFrame.start = false;
            startFrame.permission = false;
            
            logic = new Logic(width,height,startMove);
            frame = new Frame(width,height);
        
            while(true){
                Logic.move = 0; //// врем //// 
            
                frame.pushReset();
                frame.update(logic.resetPosition());
                while(true){
                    frame.update(logic.process(frame.pushButton()));
                    if(result(logic.result())){ break; }
                    if(!frame.isShowing()){ break; }
                }
                if(!frame.isShowing()){ break; }
            } 
        
        }
        
    }
    
    private static void sleep(int value){
        try {
            Thread.sleep(value);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cycle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
