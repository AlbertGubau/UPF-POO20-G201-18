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
public class Envelope extends Package {
    
    private String name;
    
    
    public Envelope(int w, int h, String n){
        super(w, h);
        name = n;
    }
    
    
    public String getName(){ //DONE
        return name;
    }
   
    
    public void setName(String n){ //DONE
        name = n;
    }
    
    
    public Boolean isSuitable(double[] size){ //SUPOSANT QUE EL TAMANY MAXIM D'EMBALAT ES 29x42
        
        return size[0]<=29 && size[1]<=42 || size[1]<=29 && size[0]<=42;
    }
    
}
