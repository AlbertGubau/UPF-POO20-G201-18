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
public class AuctionItem extends Item{ //AcutionItem es una clase hija de Item, por lo tanto, usamos el keyword extends
    
    private double currentPrice;
    private Buyer bidder;
    private Date deadline;
    public static final int fee = 5;
    public static final double percent = 0.05;
    
    AuctionItem(String n, String t, double[] s, double c, double startingPrice, Date d){  //Método constructor de la clase AuctionItem
        
        super(n,t,s,c); //Usamos super para llamar al constructor de la clase padre
        
        currentPrice = startingPrice;
        deadline = d;
    }
    
    @Override
    public double getPrice(){                                                                                   //getter del precio del item
        return currentPrice;     
    }
   
    @Override
    public double calculateProfit(){                                                                                                //método que calcula el beneficio del item
        
        if(bidder == null ){
            
            return fee;
        }
        return fee + getPrice()*percent - getPackage().getPricePlusTax();                                                                               //en el caso de que no tenga comprador se devuelve el fee y en el caso de que tenga comprador se devuelve el fee más el precio por el porcentajec
    }
    
    public void makeBid(Buyer b, double p){                                                                                                                                             //Método que permite realizar una puja, si la puja es mayor que el precio actual asignamos un nuevo comprador, un nuevo precio y lo imprimimos por pantalla
        
        if(p > currentPrice){
            
            bidder = b;
            currentPrice = p;
            
            System.out.println(bidder.getName() + " has bid " + currentPrice + " for the " + getName() + ". Who gives more? I heard "+ (currentPrice+1000) + " euros?");
        }
    }
    
    public Boolean frozen(Date d){                                                                                              //Método que comprueba si una la subasta se ha terminado en la fecha que entra por parámetro
        
        if(d.compareTo(deadline)<0){
            return false;
        }
        return true;
    }
    
    public Buyer getBuyer(){                                                            //getter del comprador
        
        return bidder;
    }
    
    public Date getDeadline(){                                                                          //getter de la fecha de finalización de la subasta
        
        return deadline;
    }
    
    @Override
    public double getPriceOnlyTax(){
        return getPrice()*iva;
    }
    
    
    @Override
    public double getPricePlusTax(){
        return getPrice() + getPriceOnlyTax();
    }
}
