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
public class Package implements Taxable{
    
    private double width;
    private double height;
    
    public Package(double w, double h){ //Método constructor de la clase Package
        width = w;
        height = h;
    }
    

    public double getWidth(){  //getters y setters de la clase Package                        
        return width;
    }
   
    
    public double getHeight(){                        
        return height;
    }
    
    
    public void setWidth(double w){                    
        width = w;
    }
    
    
    public void setHeight(double h){                   
        height = h;
    }
    
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
}
