/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;
import java.util.LinkedList;
/**
 *
 * @author oriol
 */
public class Seller extends User { //Creamos la classe Seller con sus atributos.
    
    private String accountNumber;
    private LinkedList<Item> soldItems;
    private LinkedList<Item> availableItems ;
    
    public Seller(String n,String id, String p, String a){ //Constructor de Seller
        super(n, id, p);
        accountNumber = a;
    }
    
    
    public void sell(Item i){  //Añadimos a Seller el dinero correspondiente al objeto vendido y quitamos el elemento de la LinkedList.
        
    }
    
    
    
    public void addAvailableItem(Item i){ //Añadimos el elemento a la LinkedList
        availableItems.add(i);
        
    }
    
    
    
    private Boolean deposit(double price){
        return false;
    }
    
    
    
}
