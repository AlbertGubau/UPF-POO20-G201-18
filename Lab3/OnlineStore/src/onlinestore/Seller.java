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
public class Seller extends User { //Seller es una clase hija de User por lo tanto usamos la keyword extends y declaramos los atributos del comprador (número de cuenta, la lista de items vendidos y la lista de items disponibles)                                                                                                                                        
    
    private String accountNumber;
    private LinkedList<Item> soldItems;
    private LinkedList<Item> availableItems ;
    
    public Seller(String n,String id, String p, String a){  //Método constructor de la clase Seller                                                                                                                   
        
        super(n, id, p); //Usamos super para llamar al constructor de la clase padre e inicializamos los demás atributos
        accountNumber = a;
        soldItems = new LinkedList<Item>();
        availableItems = new LinkedList<Item>();
    }
    
    public void sell(Item i){ //Método que nos permite vender un item si se encuentra en la lista de items disponibles
        
        boolean isthere = false;
        for(Item x: availableItems){
            if(x.equals(i)){
                isthere = true;
            }
        }
        if(isthere){ //Si se encuentra en la lista de items disponibles entonces lo añadimos a la lista de items vendidos e imprimimos la venta por pantalla con su beneficio
            soldItems.add(i);
            System.out.println( getName() +  " has sold item "+ i.getName() + " and "+ (i.calculateProfit()) + " euros are the benefits obtained for the item.");
        } 
    }
    
    public void addAvailableItem(Item i){  //Método que nos permite añadir un item a la lista de items disponibles                                                                                                                                    
        availableItems.add(i);
    }
   
    private Boolean deposit(double price){ //Método que nos permite depositar dinero en la cuenta del seller (método que necesitaria acceder a la cuenta bancaria del usuario y que esta planteado de manera hipotética).
        return price > 0;
    }     
}
