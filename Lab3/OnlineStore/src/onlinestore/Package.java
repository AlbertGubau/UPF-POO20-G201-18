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
public class Package {
    
    private double width;
    private double height;
    
    public Package(double w, double h){ //DONE
        width = w;
        height = h;
    }
    

    public double getWidth(){ //DONE
        return width;
    }
   
    
    public double getHeight(){ //DONE
        return height;
    }
    
    
    public void setWidth(double w){ //DONE
        width = w;
    }
    
    
    public void setHeight(double h){ //DONE
        height = h;
    }
}
