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
    
    private int width;
    private int height;
    
    public Package(int w, int h){ //DONE
        width = w;
        height = h;
    }
    

    public int getWidth(){ //DONE
        return width;
    }
   
    
    public int getHeight(){ //DONE
        return height;
    }
    
    
    public void setWidth(int w){ //DONE
        width = w;
    }
    
    
    public void setHeight(int h){ //DONE
        height = h;
    }
}
