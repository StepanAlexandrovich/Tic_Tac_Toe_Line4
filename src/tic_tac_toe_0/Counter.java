package tic_tac_toe_0;

public class Counter {  
    private Result result;
    private Estimation estimation;
    private int index,depth;
    
    public Counter(int width,int height,int distance,int depth){
        estimation = new Estimation(width,height,distance);
        result = new Result(width,height,distance);
        this.depth = depth;
    }
    
    public int process(String[] array,String symbol){
        ///////////////// ВРЕМЕННО ///////////////////////
        if(Logic.move>5){
            if(symbol=="X"){ recursion("0",array,-1,5); }
            if(symbol=="0"){ recursion("X",array,-1,5); }
        }else{   
        //////////////////////////////////////////////////
        
        if(symbol=="X"){ recursion("0",array,-1,depth); }
        if(symbol=="0"){ recursion("X",array,-1,depth); }
        
        }
        return index;
    }
    
    private int recursion(String symbol,String[] arrayOut,int position,int depth){
        String[] array = arrayOut.clone();
        if(position>=0){ array[position] = symbol; }
        
        //new NewFrame(5,5,array,"frame");
        if(result.process(array)==symbol){ return 2; }
        
        //////////////////////
        CounterHelper counterHelper = new CounterHelper(estimation);
        if(symbol=="0"){ counterHelper.process(array,"X"); }
        if(symbol=="X"){ counterHelper.process(array,"0"); }
        //////////////////////    
        
        int score = 0,maxScore = -1,index = 0,maxEst = 2000000000;
        
        for(int step = 0;step<2;step++){
            if(step==0||(step>0&&maxScore==0)){
                maxEst = counterHelper.maxScore(maxEst);
                for(int i = 0;i<array.length;i++){
                    if(array[i]==null&&depth>0&&counterHelper.okay(i)){
                        if(symbol=="0"){ score = recursion("X",array,i,depth-1); }
                        if(symbol=="X"){ score = recursion("0",array,i,depth-1); }
                        if(score>maxScore){ maxScore = score; index = i;}
                    }
                }  
            }
        }
        
        this.index = index;
        if(maxScore == -1){ return 1; }
        else{ return 2 - maxScore; }
    }
    
    
    
}
