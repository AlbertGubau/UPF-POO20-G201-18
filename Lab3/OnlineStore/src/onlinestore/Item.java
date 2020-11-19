/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

import java.util.LinkedList;
/**
 *
 * @author oriol
 */
public abstract class Item{ //Abstract?
    
    private String name;
    private String type;
    private double[] size;
    private double cost;
    private Package pack;
    
    Item(){ //Comprovar o revisar
        
        name = "Undefined";
        type = "Undefined";
        size = new double[3];
        cost = 0;        
    }
    
    Item(String n, String t, double[] s, double c){
        
        name = n;
        type = t;
        size = s;
        cost = c;
    }
    
    
    public String getName(){ //DONE
        return name;
    }
    
    
    public String getType(){ //DONE
        return type;
    }
    
    
    public double[] getSize(){ //DONE
        return size;
    }
    
    
    public double getCost(){ //DONE
        return cost;        
    }
    
    
    public Package getPackage(){ //DONE
        return pack;
    }
    
    
    public void setName(String n){//DONE
        name = n;
    }
    
    
    public void setType(String t){ //DONE
        type = t;
    }
   
    
    public void setSize(double[] s){ //DONE
        size = s;
    }
    
    
    public void setCost(double c){ //DONE
        cost = c;
    }
    
    
    public void assignBestPackage(LinkedList<Package> Lp){ //EN PROCES
        
        double depth = size[2];
        
        if(depth < 3){
            
            for(Package p: Lp){
                
                if(p instanceof Envelope){
                    
                    if(((Envelope) p).isSuitable(size)){
                        
                        pack = p;
                        
                        if(size[0]<=21 && size[1]<=11){
                            
                            ((Envelope)pack).setName("A5");
                            ((Envelope)pack).setWidth(21);
                            ((Envelope)pack).setHeight(11);
                            
                        } else if(size[0]<= 21 && size[1]<= 29){
                            
                            ((Envelope)pack).setName("A4");
                            ((Envelope)pack).setWidth(21);
                            ((Envelope)pack).setHeight(29);
                        
                        } else if(size[0]<= 29 && size[1]<= 42){
                            
                            ((Envelope)pack).setName("A3");
                            ((Envelope)pack).setWidth(29);
                            ((Envelope)pack).setHeight(42);
                        }    
                    }  
                }
            }
        }else{
            
            for(Package p: Lp){
                //COMPROVAR SI HI HA UN ALTRE ON EL PUGUI COLOCAR
            }
        }
    }
    
    public abstract double getPrice();
    
    public abstract double calculateProfit();
    
}
