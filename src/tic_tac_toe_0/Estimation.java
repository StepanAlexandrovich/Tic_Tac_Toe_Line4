
package tic_tac_toe_0;

public class Estimation {
    private String[] array;
    private int width,height;
    private int distance;
    
    private int[] plus  = new int[]{0,1,9,81,729};
    private int[] minus = new int[]{0,3,27,243,2187};
    
    public Estimation(int width,int height,int distance){  
        this.width = width;
        this.height = height;
        this.distance = distance;
    }
    
    public int process(String[] array,String symbol1,String symbol2){
        this.array = array;
        
        int score = 0;
        for(int x = 0;x<width;x++){
            for(int y = 0;y<height;y++){
                //////////////////////////////////
                for(int a=-1;a<=1;a++){
                    for(int b=-1;b<=1;b++){
                        if(!(a==0&&b==0)){ 
                            //System.out.println(score(x,y,a,b,symbol1));
                            score +=  plus[score(x,y,a,b,symbol1)];
                            score -= minus[score(x,y,a,b,symbol2)];
                        }
                    }    
                }
                ///////////////////////////////////
            }
        }
       
        //System.out.println(score);
        
        return score;
    }
    
    private int score(int x,int y,int a,int b,String symbol){
        int score = 0;
        for(int i = 0;i<distance;i++ ){
            int index = border(x+a*i,y+b*i); 
            if(index==-1||(array[index]!=symbol&&array[index]!=null)){ return 0; }
            else{ 
                if(array[index]==symbol){ score++; }
            }
        }
        return score;
    }
    
    private int border(int x,int y){
        if(x>=0&&x<width&&y>=0&&y<height){
            return y*width + x;
        }
        return -1;
    }
    
}
