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
public class UnitItem extends Item{ //Unititem es una clase hija de la clase Item, por lo tanto, usamos la keyword extends
    
    private double unitPrice;
    private int quantity;
    private int quantityRemaining;
    
   
    UnitItem(String n, String t, double[] s, double c, double uprice, int q){ //Mètodo constructor de UnitItem
       
        super(n,t,s,c); //usamos super para llamar al constructor de la clase padre
        
        unitPrice = uprice;
        quantity = q;
        quantityRemaining = q;
    }
    
    public double getQuantityRemaining(){ //getter de la cantidad restante
        
        return quantityRemaining;
    }
    
    @Override
    public double getPrice(){ //Redefinición del método getPrice de la interfaz Taxable
        
        return unitPrice*quantityRemaining; 
    }
    
    @Override
    public double calculateProfit(){ //Redefinición del método calculateProfit de la interfaz Taxable                                                                               
        
        return (quantity-quantityRemaining)*(unitPrice-getCost())- getPackage().getPricePlusTax();
    }
    
    public double sell(int q){ //método para vender el item unitario
       
        quantityRemaining = 0;
        
        return unitPrice*quantity;
    }
    
    @Override
    public double getPriceOnlyTax(){ //Redefinición del método getPriceOnlyTax de la interfaz Taxable
        return getPrice()*iva;
    }
    
    
    @Override
    public double getPricePlusTax(){ //Redefinición del método getPricePlusTax de la interfaz Taxable
        return getPrice() + getPriceOnlyTax();
    }
}
