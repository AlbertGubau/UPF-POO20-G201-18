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
        return false;
    }
    
    
    
    public Boolean manageAuction(AuctionItem a, String date){
        return false;
    }
    
    
    
    public void printStock(LinkedList<AuctionItem> item){
        
        for (Item i: item){
            System.out.println(i);
        }
    }
    
}
