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
    
   
    UnitItem( String n, String t, double[] s, double c, double uprice, int q){ //Mètodo constructor de UnitItem
       
        super(n,t,s,c);
        
        unitPrice = uprice;
        quantity = q;
         
    }
    
    public double getPrice(){ //DONE
        return unitPrice;
    }
    
    public double calculateProfit(){
        return 0;
    }
    
    public double sell(int q){
        return 0;
    }
}
