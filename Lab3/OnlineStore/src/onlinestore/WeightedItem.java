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
public class WeightedItem extends Item{
    
    private double pricePerWeight;
    private double weight;
    private double weightRemaining;
    
    public WeightedItem(String n, String t, double[] s, double c, double wprice, double w){
    
        super(n, t, s, c);
        
        pricePerWeight = wprice;
        weight = w;
    }
    
    
    @Override
    public double getPrice(){
        return pricePerWeight;
    }
    
    
    @Override
    public double calculateProfit(){
        return 0;
    }
    
    
    public double sell(double w){
        return 0;
    }
}
