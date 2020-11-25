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
public class Administrator extends User{
   
    public Administrator(String n, String id, String p){
        super(n, id, p);
    }
    
    public Boolean expel(User u){      
        
        System.out.println(getName() + " has expelled the user " + u.getName() + ".");
        return true;
    }
    
    public Boolean manageAuction(AuctionItem a, String date){                                                           
        
        if(!a.frozen(date)){
            System.out.println(getName() + " is managing the item " + a.getName() + " at " + date + ".");
            return true;
        }
        return false;
    }
    
    public void printStock(LinkedList<AuctionItem> item){
        
        System.out.println("The administrator "+ getName() + " is going to show the auction items: ");
        
        for (Item i: item){
            System.out.println(i.getName() + " has current price of " + i.getPrice()+ " and deadline " + ((AuctionItem)i).getDeadline() + ".");
        }
    }
}
