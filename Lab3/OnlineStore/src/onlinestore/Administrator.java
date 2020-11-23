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
    
    
    public Boolean expel(User u){ //TIENE QUE HACER ALGO???
        System.out.println(getName() + " has expelled the user " + u.getName() + ".");
        return true;
    }
    
    
    public Boolean manageAuction(AuctionItem a, String date){ //TODO
        System.out.println(getName() + " is managing the item " + a.getName() + ".");
        return true;
    }
    
    
    public void printStock(LinkedList<AuctionItem> item){ //DONE
        
        System.out.println("The administrator "+ getName() + " is going to show the auction items: ");
        
        for (Item i: item){
            
            System.out.println(i.getName() + " has current price of " + i.getPrice()+ " and deadline " + ((AuctionItem)i).getDeadline() + ".");
        }
    }
}
