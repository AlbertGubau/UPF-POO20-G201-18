/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface Taxable { //Interfaz Taxable
    
    public static final double iva = 0.21; //Constante del IVA
    
    public double getPrice(); //Métodos de la interfaz
    
    public double calculateProfit();
    
    public double getPriceOnlyTax();
    
    public double getPricePlusTax();
}
