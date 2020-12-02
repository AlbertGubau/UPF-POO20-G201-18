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
public class Envelope extends Package {                                        //Envelope es una clase hija de Package por lo tanto usamos el keyword extends
    
    private String name;
    private double price;
    private double cost;
    
    public Envelope(int w, int h, String n, double c, double p){                //Constructor de la clase Envelope que llama a super para utilizar el constructor de la clase padre
        super(w, h);
        name = n;
        price = p;
        cost = c;
    }
    
    public String getName(){ //getter del atributo name                                                                                               
        return name;
    }
    
    @Override
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double p){
        price = p;
    }
    
    public double getCost(){
        return cost;
    }
    
    public void setCost(double c){
        cost = c;
    }
    
    @Override
    public double calculateProfit(){
        return getPrice()-getCost();
    }
    
    public void setName(String n){ //setter del atributo name                                                                                         
        name = n;
    }
    public Boolean isSuitable(double[] size){  //Método que comprueba si un tamaño cabe en unas medidas determinadas de embalaje                                                                             
        
        return size[0] <= getWidth() && size[1] <= getHeight() || size[1] <= getWidth() && size[0] <= getHeight();
    }  
    
    @Override
    public double getPriceOnlyTax(){
        return getPrice()*iva;
    }
    
    
    @Override
    public double getPricePlusTax(){
        return getPrice() + getPriceOnlyTax();
    }  
}
