package tic_tac_toe_0;

import javax.swing.JOptionPane;

public class Logic {
    public static int move;
    
    //// параметры
    public int width,height,distance = 4,depth = 12;
    private int length;
    //// игровая платформа
    private String[] array;
    private Result result;
    private boolean next,startMove;
    private String symbolPC,symbolUser;
    // счётчик  
    private Counter counter;
    
    public Logic(int width,int height,boolean startMove){
        this.width = width;
        this.height = height;
        this.startMove = startMove;
        length = width*height;
        array = new String[length];
        result = new Result(width,height,distance);
        counter = new Counter(width,height,distance,depth);
    }
    
    //// геттеры 
    public String result(){ return result.process(array); }
    
    private boolean write(int index,String symbol){
        if(index>=0&&array[index]==null){
            array[index] = symbol;
        }else{ return false; }
        return true;
    }
    
    public String[] resetPosition(){
        for(int i = 0;i<length;i++){ array[i] = null; }
        next = startMove;
        if(next){ symbolPC = "X"; symbolUser = "0"; }
        else    { symbolPC = "0"; symbolUser = "X"; }
        return array.clone();
    }
    
    public String[] process(int indexUser){
        if(next){
            int indexPC = 0;
            
            if(move==0){ indexPC = result.center(); }
            else{ indexPC = counter.process(array,symbolPC); }
            
            if(write(indexPC,symbolPC))     { next = !next; move++; }
        }else{
            if(write(indexUser,symbolUser)) { next = !next; move++; }
        } 
        return array.clone();
    } 
    
}
