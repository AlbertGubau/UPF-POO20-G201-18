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
public class WeightedItem extends Item{ //WeightedItem es una clase hija de la clase Item, por lo tanto, usamos la keyword extends
    
    private double pricePerWeight;
    private double weight;
    private double weightRemaining;
    
    public WeightedItem(String n, String t, double[] s, double c, double wprice, double w){ //Mètodo constructor de WeightedItem
    
        super(n, t, s, c); //usamos super para llamar al constructor de la clase padre
        
        pricePerWeight = wprice;
        weight = w;
        weightRemaining = w;
    }
    
    public double getWeightRemaining(){ //getter del peso restante
        
        return weightRemaining;
    }
    
    @Override
    public double getPrice(){ //Redefinición del método getPrice de la interfaz Taxable
        
        return pricePerWeight*weightRemaining;
    }
    
    
    @Override
    public double calculateProfit(){ //Redefinición del método calculateProfit de la interfaz Taxable
        
        return (weight-weightRemaining)*(pricePerWeight-getCost()) -getPackage().getPricePlusTax();
    }
    
    
    public double sell(double w){ //Método que vende el item de tipo pesado
        
        weightRemaining = 0;
        
        return pricePerWeight*weight;
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
