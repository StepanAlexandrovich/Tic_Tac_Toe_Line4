package tic_tac_toe_0;

public class CounterHelper {  
    private Estimation estimation;
    private int index,maxScore;
    public int[] arrayValue;
    
    public int value = 0;
    
    public CounterHelper(Estimation estimation){ this.estimation = estimation; }
    
    public void process(String[] arrayOut,String symbol){
        String[] array = arrayOut.clone(); 
        arrayValue = arrayValueInit(array.length);
        
        for(int i = 0;i<array.length;i++){
            if(array[i]==null){
                array[i] = symbol;
                if(symbol=="X"){ arrayValue[i] = estimation.process(array,"X","0"); }
                if(symbol=="0"){ arrayValue[i] = estimation.process(array,"0","X"); }
                array[i] = null;
            }
        }   
        
    }
    
    public int maxScore(int border){
        maxScore = -2000000000;
        for(int i = 0;i<arrayValue.length;i++){
            if(arrayValue[i]>maxScore&&arrayValue[i]<border){ maxScore = arrayValue[i]; }
        }
        return maxScore;
    }
    
    public boolean okay(int index){
        if(arrayValue[index]==maxScore){ return true; }
        else{ return false; }
    }
    
    public int[] arrayValueInit(int length){
        int[] array = new int[length];
        for(int i = 0;i<length;i++){   
            array[i] = -2000000000;
        }
        return array;
    }
    
}
