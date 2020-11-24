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
public class UnitItem extends Item{
    
    private double unitPrice;
    private int quantity;
    private int quantityRemaining;
    
   
    UnitItem(String n, String t, double[] s, double c, double uprice, int q){ //Mètodo constructor de UnitItem
       
        super(n,t,s,c);
        
        unitPrice = uprice;
        quantity = q;
        quantityRemaining = q;
    }
    
    public double getQuantityRemaining(){ //ERA NECESARIO AÑADIRLO
        
        return quantityRemaining;
    }
    
    @Override
    public double getPrice(){ //DONE
        
        return unitPrice*quantityRemaining; 
    }
    
    @Override
    public double calculateProfit(){ //DONE
        
        return (quantity-quantityRemaining)*(unitPrice-getCost());
    }
    
    public double sell(int q){ //QUE DEBO HACER EN SELL
       
        quantityRemaining = 0;
        
        return unitPrice*quantity;
    }
}
