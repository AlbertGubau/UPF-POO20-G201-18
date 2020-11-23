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
public class Buyer extends User{                                                                                                                //creamos la classe Buyer con los atributos accountNumber y bpughtItems
    
    private String accountNumber;
    private LinkedList<Item> boughtItems; 
    
    public Buyer(String n, String id, String p, String a){
        
        super(n, id, p);
        accountNumber = a;
        boughtItems = new LinkedList<Item>();
    }
    
    public void buy(Item i){                                                                                                                     //COMPROVAR
        
        boughtItems.add(i);
        System.out.println( getName() +" is buying item "+ i.getName() + " for "+ i.getPrice() + " euros.");
        System.out.println("Price "+ i.getPrice() +" is getting charged into account " + accountNumber + " from user "+ getName() + ".");
    }
    
    
    private Boolean pay(double price){                                                                                                           //DONE
        
        return price>0;
    }
}
