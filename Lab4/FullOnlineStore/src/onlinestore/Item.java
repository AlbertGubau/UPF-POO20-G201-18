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
public abstract class Item implements Taxable, Comparable{ //Declaramos Item como una clase abstracta porque contiene 2 métodos abstractos
    
    private String name;
    private String type;
    private double[] size;
    private double cost;
    private Package pack;
    
    Item(){ //Constructor vacío de la clase Item
        
        name = "Undefined";
        type = "Undefined";
        size = new double[3];
        for(int i = 0; i<=2; i++){
            size[i] = 0;
        }
        cost = 0;        
    }
    
    Item(String n, String t, double[] s, double c){ //Constructor de la clase Item
        
        name = n;
        type = t;
        size = new double[3]; 
        for(int i = 0; i<=2; i++){
            size[i] = s[i];
        }
        cost = c;
    }
    
    public String getName(){ //getters y setters de la clase Item
        return name;
    }
   
    public String getType(){ 
        return type;
    }
    
    public double[] getSize(){ 
        return size;
    }
    
    public double getCost(){ 
        return cost;        
    }
    
    public Package getPackage(){ 
        return pack;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public void setType(String t){ 
        type = t;
    }
   
    public void setSize(double[] s){ 
        for(int i = 0; i<=2; i++){
            size[i] = s[i];
        }   
    }
    
    public void setCost(double c){ 
        cost = c;
    }
    
    
    public void assignBestPackage(LinkedList<Package> Lp){ //Método que comprueba asigna el mejor empaquetado para un item determinado
        
        double depth = size[2];
        
        boolean solved = false; //booleano que controla si hemos encontrado un empaquetado para nuestro item
        
        if(depth < 3){  //Si la profundidad es menor que 3 cm entonces intentaremos asignarle un embalaje (Envelope)                                                                                                        
            for(Package p: Lp){
                
                if(p instanceof Envelope){
                    
                    if(((Envelope) p).isSuitable(size)){    //En el caso de que quepa en el embalaje en el que nos encontramos se lo asignamos al item
                          
                        pack = p;
                            
                        ((Envelope)pack).setName(((Envelope) p).getName());
                        ((Envelope)pack).setWidth(((Envelope) p).getWidth());
                        ((Envelope)pack).setHeight(((Envelope) p).getHeight());
                        solved = true;  
                    }  
                }
            }
            if(solved){
                System.out.println("Envelope " + ((Envelope)pack).getName() + " assigned to item " + name + "."); //Si hemos encontrado el empaquetado para el item lo imprimimos por pantalla
            }
            
        }if(!solved){ //Si no hemos encontrado un empaquetado aun intentamos asignarle una caja como empaquetado
            
            for(Package p: Lp){
                
                if(p instanceof Box){
                    
                    if(((Box) p).isSuitable(size)){   //Si el item cabe en la caja se la asignamos 
                        
                        Box box = (Box)p;
                        double boxwidth = box.getWidth();
                        double boxheight = box.getHeight();
                        double boxdepth = box.getDepth();
                        
                        pack = p;
                            
                        ((Box)pack).setWidth(boxwidth);
                        ((Box)pack).setHeight(boxheight);
                        ((Box)pack).setDepth(boxdepth);
                        solved = true;
                        break;
                    }  
                }
            }
            if(solved){ //Si hemos encontrado una caja en la que el item cabe lo imprimimos por pantalla
                System.out.println("Box " + "with size {"+ ((Box)pack).getWidth() + ", " + ((Box)pack).getHeight() + ", " + ((Box)pack).getDepth() + "} assigned to item " + name + ".");
            
            }else{ //En el caso de que no hemos encontrado ningún empaquetado para nuestro item lo imprimimos por pantalla
                System.out.println("No package available for item "+ name + ".");
            }
        }
    }
    
    /*public abstract double getPrice(); //Métodos abtractos que redefinen en UnitItem, WeightedItem y AuctionItem.
    
    public abstract double calculateProfit();*/
    
    
    @Override
    public double getPrice(){
        return 0;
    }
    
    
    @Override
    public double calculateProfit(){
        return 0;
    }
    
    
    @Override
    public double getPriceOnlyTax(){
        return 0;
    }
    
    
    @Override
    public double getPricePlusTax(){
        return 0;
    }
    
    @Override
    public double sumTotalTax( Taxable t ){
        return 0;
    }
    
    @Override
    public int compareTo(Object o){
        
        if(o instanceof UnitItem){
            
            UnitItem i = (UnitItem)o;
            
            if(i.getPrice() - getPrice() > 0){
                return -1;
            }
            if(i.getPrice() - getPrice() == 0){
                return 0;
            }
            if(i.getPrice() - getPrice() < 0){
                return 1;
            }
        }
        
        if(o instanceof WeightedItem){
            
            WeightedItem i = (WeightedItem)o;
            
            if(i.getPrice() - getPrice() > 0){
                return -1;
            }
            if(i.getPrice() - getPrice() == 0){
                return 0;
            }
            if(i.getPrice() - getPrice() < 0){
                return 1;
            }
        }
        return 5;
    }
}

