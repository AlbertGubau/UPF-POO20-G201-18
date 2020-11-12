/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;
import java.util.LinkedList;
/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */


public class OnlineStore {
    
    public static LinkedList< Item > itemsAvailable;
    public static LinkedList< Item > itemsSold;
    public static LinkedList< User > users;
    public static LinkedList< Package > packages;
    public static double totalPrice;
    public static double totalProfit;
    
    public static void init(){
        
        itemsAvailable = new LinkedList< Item >();
        itemsSold = new LinkedList< Item >();
        users = new LinkedList< User >();
        packages = new LinkedList< Package >();
        totalPrice = 0.0;
        totalProfit = 0.0; 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        init();
        itemsAvailable.add( new UnitItem("Sofa", "Furniture", new double[]{280.0, 120.0, 100.0}, 300, 500, 2));
        itemsAvailable.add( new WeightedItem("Rice", "Food", new double[]{12.0, 22.0, 2.0}, 1.5, 2.5, 50));
        itemsAvailable.add( new UnitItem("TV", "Appliance", new double[]{100.0, 60.0, 10.0}, 600, 1000, 4));
        
        users.add( new Buyer("John Smith", "Johnny", "heythere", "12345678"));
        users.add( new Buyer("John Smith", "Johnny", "heythere", "12345678"));
        users.add( new Buyer("John Smith", "Johnny", "heythere", "12345678"));
        users.add( new Seller("John Smith", "Johnny", "heythere", "12345678"));
        users.add( new Administrator("John Smith", "Johnny", "heythere", "12345678"));
        
        packages.add( new Envelope(11, 21, "A5"));
        packages.add( new Envelope(21, 29, "A4"));
        packages.add( new Envelope(21, 29, "A4"));
        packages.add( new Box(10, 10, 10));
        packages.add( new Box(10, 10, 100));
        packages.add( new Box(10, 100, 100));
        packages.add( new Box(100, 100, 100));
        packages.add( new Box(100, 150, 300));
        packages.add( new Box(200, 300, 500));
        
        for(int i = 0; i<itemsAvailable.size(); i++){
            itemsAvailable.get(i).assignBestPackafe(packages);        
        }
        
        
        Seller seller = (Seller)users.get(3);
        for(int i = 0; i<itemsAvailable.size(); i++){
            s.addAvailableItem(itemsAvailable.get(i));         
        }
        
        for(int i = 0; i<itemsAvailable.size(); i++){
            Item item = itemsAvailable.get(i);
            Buyer b = (Buyer)users.get(i);
            b.buy(item);
            totalPrice += item.getPrice();
            
            if(item instanceof UnitItem){
                ((UnitItem)item).sel(0.0);
            
            } else if(item instanceof WeightedItem){
                ((WeightedItem)item).sel(0.0);
            }
            s.sell(item);
            totalProfit += item.calculateProfit();
            itemsSold.add(item);
            itemsAvailable.remove(item);
            
        }
        
        LinkedList< Auctionitem > lai = new LinkedList< AuctionItem >;
        Administrator admin = (Administrator)users.get(4);
        AuctionItem auctionitem = new AuctionItem(//inicialitzar);
        lai.add(auctionitem);
        auctionitem.assignBestPackage(packages);//nose
        s.addAvailableItem(auctionitem);
        itemsAvailable.add(auctionitem);
        
        
        
        
        
    } 
}
