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
    
    Item(){ //ES CORRECTO COMO LO HEMOS PLANTEADO?
        
        name = "Undefined";
        type = "Undefined";
        size = new double[3];
        
        for(int i = 0; i<=2; i++){
            
            size[i] = 0;
        }
        cost = 0;        
    }
    
    Item(String n, String t, double[] s, double c){
        
        name = n;
        type = t;
        size = new double[3]; 
        
        for(int i = 0; i<=2; i++){
            
            size[i] = s[i];
        }
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
        
        for(int i = 0; i<=2; i++){
            size[i] = s[i];
        }   
    }
    
    
    public void setCost(double c){ //DONE
        cost = c;
    }
    
    
    public void assignBestPackage(LinkedList<Package> Lp){ //DONE
        
        double depth = size[2];
        
        boolean solved = false;
        
        if(depth < 3){ //SOLUCION ALTERNATIVA SERIA COMPROVAR QUE NI WIDTH NI HEIGHT NI DEPTH SON MENORES QUE 3
            
            for(Package p: Lp){
                
                if(p instanceof Envelope){
                    
                    if(((Envelope) p).isSuitable(size)){    
                        
                        if(size[0]<=((Envelope) p).getWidth() && size[1]<=((Envelope) p).getHeight()||size[1]<=((Envelope) p).getWidth() && size[0]<=((Envelope) p).getHeight()){
                            
                            pack = p;
                            
                            ((Envelope)pack).setName(((Envelope) p).getName());
                            ((Envelope)pack).setWidth(((Envelope) p).getWidth());
                            ((Envelope)pack).setHeight(((Envelope) p).getHeight());
                            solved = true;
                        }
                    }  
                }
            }
            if(solved){
                System.out.println("Envelope " + ((Envelope)pack).getName() + " assigned to item " + name + ".");
            }
            
        }if(!solved){
            
            for(Package p: Lp){
                
                if(p instanceof Box){
                    
                    if(((Box) p).isSuitable(size)){    
                        
                        Box box = (Box)p;
                        double boxwidth = box.getWidth();
                        double boxheight = box.getHeight();
                        double boxdepth = box.getDepth();
                        
                        if(size[0] <= boxwidth && size[1] <= boxheight && size[2] <= boxdepth){
                            
                            pack = p;
                            
                            ((Box)pack).setWidth(boxwidth);
                            ((Box)pack).setHeight(boxheight);
                            ((Box)pack).setDepth(boxdepth);
                            solved = true;
                            break;
                        
                        }else if(size[0] <= boxwidth && size[2] <= boxheight && size[1] <= boxdepth){
                            pack = p;
                            
                            ((Box)pack).setWidth(boxwidth);
                            ((Box)pack).setHeight(boxheight);
                            ((Box)pack).setDepth(boxdepth);
                            solved = true;
                            break;
                        
                        }else if(size[1] <= boxwidth && size[0] <= boxheight && size[2] <= boxdepth){
                            pack = p;
                            
                            ((Box)pack).setWidth(boxwidth);
                            ((Box)pack).setHeight(boxheight);
                            ((Box)pack).setDepth(boxdepth);
                            solved = true;
                            break;
                        
                        }else if(size[1] <= boxwidth && size[2] <= boxheight && size[0] <= boxdepth){
                            
                            pack = p;
                            
                            ((Box)pack).setWidth(boxwidth);
                            ((Box)pack).setHeight(boxheight);
                            ((Box)pack).setDepth(boxdepth);
                            solved = true;
                            break;
                        
                        }else if(size[2] <= boxwidth && size[1] <= boxheight && size[0] <= boxdepth){
                            pack = p;
                            
                            ((Box)pack).setWidth(boxwidth);
                            ((Box)pack).setHeight(boxheight);
                            ((Box)pack).setDepth(boxdepth);
                            solved = true;
                            break;
                        
                        }else if(size[2] <= boxwidth && size[0] <= boxheight && size[1] <= boxdepth){
                            
                            pack = p;
                            
                            ((Box)pack).setWidth(boxwidth);
                            ((Box)pack).setHeight(boxheight);
                            ((Box)pack).setDepth(boxdepth);
                            solved = true;
                            break;
                        }
                    }  
                }
            }
            if(solved){
                System.out.println("Box " + "with size {"+ ((Box)pack).getWidth() + ", " + ((Box)pack).getHeight() + ", " + ((Box)pack).getDepth() + "} assigned to item " + name + ".");
            
            }else{
                System.out.println("No package available for item "+ name + ".");
            }
        }
    }
    
    public abstract double getPrice();
    
    public abstract double calculateProfit();
}
