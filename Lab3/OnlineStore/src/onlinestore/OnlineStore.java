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
        
        itemsAvailable.add( new UnitItem("Gaming Chair", "Furniture", new double[]{280.0, 120.0, 100.0}, 300, 500, 2));
        itemsAvailable.add( new WeightedItem("Rice", "Food", new double[]{12.0, 22.0, 2.0}, 1.5, 2.5, 50));
        itemsAvailable.add( new UnitItem("TV", "Appliance", new double[]{100.0, 60.0, 10.0}, 600, 1000, 4));
        
        users.add( new Buyer("Marcos Navajas", "Markito", "aylutequiero", "12345678"));
        users.add( new Buyer("Oscar Bujía", "Oscaaaaaaaar", "pollo", "123456789"));
        users.add( new Buyer("Didac Sitjas", "DidacTempo", "6969", "12345678910"));
        
        users.add( new Seller("Daniel Leorri", "Wade", "elbaileesmivida67", "1234567891011"));
        
        users.add( new Administrator("Albert Gubau", "Albert", "contraseña"));
        
        packages.add( new Envelope(11, 21, "A5"));
        packages.add( new Envelope(21, 29, "A4"));
        packages.add( new Envelope(29, 42, "A3"));
        packages.add( new Box(10, 10, 10));
        packages.add( new Box(10, 10, 100));
        packages.add( new Box(10, 100, 100));
        packages.add( new Box(100, 100, 100));
        packages.add( new Box(100, 150, 300));
        packages.add( new Box(200, 300, 500));
        
        for(int i = 0; i<itemsAvailable.size(); i++){
            itemsAvailable.get(i).assignBestPackage(packages);        
        }
        
        Seller seller = (Seller)users.get(3);
        
        for(int i = 0; i<itemsAvailable.size(); i++){
            seller.addAvailableItem(itemsAvailable.get(i));         
        }
        
        for(int i = 0; i<itemsAvailable.size(); i++){
            Item item = itemsAvailable.get(i);
            Buyer b = (Buyer)users.get(i);
            b.buy(item);
            totalPrice += item.getPrice();
            
            if(item instanceof UnitItem){
                ((UnitItem)item).sell(0);
            
            } else if(item instanceof WeightedItem){
                ((WeightedItem)item).sell(0.0);
            }
            seller.sell(item);
            totalProfit += item.calculateProfit();
            itemsSold.add(item);
            itemsAvailable.remove(item);
        }
        
        LinkedList< AuctionItem > lai = new LinkedList< AuctionItem >();
        Administrator admin = (Administrator)users.get(4);
        AuctionItem auctionitem = new AuctionItem("pene", "Furniture", new double[]{250, 160, 450}, 25000.0, 25000.0, "12345678");
        lai.add(auctionitem);
        auctionitem.assignBestPackage(packages);//nose
        seller.addAvailableItem(auctionitem);
        itemsAvailable.add(auctionitem);
        
        if(!auctionitem.frozen("12345678")){
            auctionitem.makeBid((Buyer)users.get(1), 11000.0);
        }
        admin.printStock(lai);
        
        if(!auctionitem.frozen("12345678")){
            auctionitem.makeBid((Buyer)users.get(0), 10500.0);
        }
        if(!auctionitem.frozen("12345678")){
            auctionitem.makeBid((Buyer)users.get(2), 13000.0);
        }
        admin.manageAuction(auctionitem, "12345678");
        
        if(!auctionitem.frozen("12345678")){
            auctionitem.makeBid((Buyer)users.get(1), 13500.0);
        }
        admin.expel(users.get(1));
        users.remove(users.get(1));
        Buyer buyer = auctionitem.getBuyer();
        buyer.buy(auctionitem);
        seller.sell(auctionitem);
        
        totalPrice += auctionitem.getPrice();
        totalProfit += auctionitem.calculateProfit();
        
        System.out.println("Total price: " + totalPrice);
        System.out.println("Total profit: " + totalProfit);
    } 
}
