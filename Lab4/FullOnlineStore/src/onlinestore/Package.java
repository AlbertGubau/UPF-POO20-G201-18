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
public abstract class Package implements Taxable{ //Declaramos la clase Package como abstracta dado que tiene los métodos de Taxable como abstractos
    
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
    public abstract double getPrice(); //Declaración de los métodos de la interfaz Taxable para poderlos redefinir en las subclases de Package
    
    
    @Override
    public abstract double calculateProfit();
    
    
    @Override
    public abstract double getPriceOnlyTax();
        
    
    @Override
    public abstract double getPricePlusTax(); 
}
