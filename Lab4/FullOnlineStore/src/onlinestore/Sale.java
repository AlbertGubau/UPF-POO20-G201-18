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
public class Sale implements Comparable{ //La clase Sale implementa la interfaz Comparable
    
    private Item item;
    private Buyer buyer;
    private Date saleDate;
    private Date shippingDate;
    private Package pack;
   
    public Sale(Item i, Buyer b, Date sd, Date shd, Package p){ //Método constructor de la clase Sale
        
        item = i;
        buyer = b;
        saleDate = sd;
        shippingDate = shd;
        pack = p;
    }
   
    public Item getItem(){ //getters y setters de la clase Sale
        return item;
    }
  
    public Buyer getBuyer(){
        return buyer;
    }
   
    public Date getDate(){
        return saleDate;
    }
   
    public Date getShippingDate(){
        return shippingDate;
    }
   
    public void setSaleDate(Date d){
        saleDate = d;
    }
   
    public void setShippingDate(Date d){
        shippingDate = d;
    }
    
    @Override
    public int compareTo(Object o){ //Redefinición del método compareTo de la interfaz Comparable que llamara al método compareTo de la clase Date.
        
        if(o instanceof Sale){
            
            Sale s = (Sale)o;
            return s.getDate().compareTo(getDate());
        }
        return 5;
    }
}
