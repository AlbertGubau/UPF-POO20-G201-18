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
        weightRemaining = w;
    }
    
    public double getWeightRemaining(){
        
        return weightRemaining;
    }
    
    @Override
    public double getPrice(){ 
        
        return pricePerWeight*weightRemaining;
    }
    
    
    @Override
    public double calculateProfit(){ 
        
        return (weight-weightRemaining)*(pricePerWeight-getCost());
    }
    
    
    public double sell(double w){ 
        
        weightRemaining = 0;
        
        return pricePerWeight*weight;
    }
}
