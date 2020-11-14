/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

/**
 *
 * @author oriol
 */
public class Box extends Package{
    
    private int depth;
    
    public Box(int w, int h, int d){
        super(w,h);
        depth = d;
    }
    
    
    public int getDepth(){ //DONE
        return depth;
    }
    
    
    public void setDepth(int d){ //DONE
        depth = d;
    }
    
    
    public Boolean isSuitable(int[] size){
       return false;
    }
    
}
