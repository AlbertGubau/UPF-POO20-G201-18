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
    
    
    public double getDepth(){ //DONE
        return depth;
    }
    
    
    public void setDepth(double d){ //DONE
        depth = d;
    }
    
    
    public Boolean isSuitable(double[] size){ //SUPONIENDO QUE HAY UN SET PREDEFINIDO DE CAJAS Y QUE EL TAMAÑO MAXIMO ES 200x300x500
       
        if(size[0] <= 200 && size[1] <= 300 && size[2]<=500){
            
            return true;
        
        }else if(size[0] <= 200 && size[1] <= 500 && size[2] <= 300){
            
            return true;
        
        }else if(size[0] <= 300 && size[1] <= 200 && size[2] <= 500){
             
            return true;
        
        }else if(size[0] <= 300 && size[1] <= 500 && size[2] <= 200){
            
            return true;
        
        } else if(size[0] <= 500 && size[1] <= 300 && size[2] <= 200){
            
            return true;
        
        }else if(size[1] <= 500 || size[1] <= 200 || size[1] <= 300){
            
            return true;
        }
        return false;
    }
}