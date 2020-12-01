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
public class Buyer extends User{ //Buyer es una clase hija de User por lo tanto usamos la keyword extends y declaramos los atributos del comprador (número de cuenta y lista de items comprados)                                                                                                             
    
    private String accountNumber;
    private LinkedList<Item> boughtItems; 
    
    public Buyer(String n, String id, String p, String a){ //Método constructor de la clase Buyer
        
        super(n, id, p); //Usamos super para llamar al constructor de la clase padre e inicializamos los demás atributos
        accountNumber = a;
        boughtItems = new LinkedList<Item>();
    }
    
    public void buy(Item i){   //Método que permite comprar al Buyer en el caso de que pay devuelva true (implementación en la que necesitariamos una cantidad de dinero como atributo de nuestro usuario)                                                                                                           
        
        if(pay(i.getPrice())){ //Si tiene el dinero para pagarlo entonces se añade el item a la lista de items comprados y se imprime por pantalla la compra realizada
            
            boughtItems.add(i);
        
            System.out.println( getName() +" is buying item "+ i.getName() + " for "+ i.getPrice() + " (price without IVA) and the price with IVA is  "+ i.getPricePlusTax() + " euros.");
            System.out.println("Price "+ i.getPricePlusTax() +" is getting charged into account " + accountNumber + " from user "+ getName() + ".");
        }   
    }
    
    private Boolean pay(double price){ //Método que comprueba que puede pagar el usuario (faltaría el atributo de la cantidad de dinero de la que dispone el usuario para implementarla de manera correcta).                                                                                                   
        
        return price>0;
    }
}
