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
    
    private double depth;
    
    public Box(int w, int h, int d){
        super(w,h);
        depth = d;
    }
    
    
    public double getDepth(){                                                  //DONE
        return depth;
    }
    
    
    public void setDepth(double d){                                            //DONE
        depth = d;
    }
    
    
    public Boolean isSuitable(double[] size){                                  //SUPONIENDO QUE HAY UN SET PREDEFINIDO DE CAJAS Y QUE EL TAMAÑO MAXIMO ES 200x300x500
       
        if(size[0] <= getHeight() && size[1] <= getWidth() && size[2]<=getDepth()){ //getHeight = 200, getWidth = 300, getDepth = 500
            
            return true;
        
        }else if(size[0] <= getHeight() && size[1] <= getDepth() && size[2] <= getWidth()){
            
            return true;
        
        }else if(size[0] <= getWidth() && size[1] <= getHeight() && size[2] <= getDepth()){
             
            return true;
        
        }else if(size[0] <= getWidth() && size[1] <= getDepth() && size[2] <= getHeight()){
            
            return true;
        
        } else if(size[0] <= getDepth() && size[1] <= getWidth() && size[2] <= getHeight()){
            
            return true;
        
        }else if(size[1] <= getDepth() || size[1] <= getHeight() || size[1] <= getWidth()){
            
            return true;
        }
        return false;
    }
}