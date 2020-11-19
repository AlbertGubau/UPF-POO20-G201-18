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
    
    @Override
    public double getPrice(){ //DONE
        
        return unitPrice*quantity; //HACE FALTA LA CANTIDAD?
    }
    
    @Override
    public double calculateProfit(){ //COMO LO HAGO
        return 0;
    }
    
    public double sell(int q){ //COMPROVAR
        
        if(quantityRemaining >= q){
            
            return quantityRemaining -= q;
        }
        return 0;
    }
}
