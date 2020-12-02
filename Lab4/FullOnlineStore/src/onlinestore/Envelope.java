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
public class Envelope extends Package { //Envelope es una clase hija de Package por lo tanto usamos el keyword extends
    
    private String name;
    private double price; //Nuevos atributos price y cost
    private double cost;
    
    public Envelope(int w, int h, String n, double c, double p){ //Constructor de la clase Envelope que llama a super para utilizar el constructor de la clase padre
        super(w, h);
        name = n;
        price = p;
        cost = c;
    }
    
    public String getName(){ //getters y setters de la clase Envelope                                                                                              
        return name;
    }
    
    @Override
    public double getPrice(){ //Redefinición del método getPrice de la interfaz Taxable
        return price;
    }
    
    public void setPrice(double p){ //setter del atributo price
        price = p;
    }
    
    public double getCost(){ //getter del atributo cost
        return cost;
    }
    
    public void setCost(double c){ //setter del atributo cost
        cost = c;
    }
    
    @Override
    public double calculateProfit(){ //Redefinición del método calculateProfit de la interfaz Taxable
        return getPrice()-getCost();
    }
    
    public void setName(String n){ //setter del atributo name                                                                                         
        name = n;
    }
    public Boolean isSuitable(double[] size){  //Método que comprueba si un tamaño cabe en unas medidas determinadas de embalaje                                                                             
        
        return size[0] <= getWidth() && size[1] <= getHeight() || size[1] <= getWidth() && size[0] <= getHeight();
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
