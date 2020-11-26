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
    
    public static LinkedList< Item > itemsAvailable; //Declaramos las listas de items, usuarios y empaquetados junto a las variables totalPrice y totalProfit
    public static LinkedList< Item > itemsSold;
    public static LinkedList< User > users;
    public static LinkedList< Package > packages;
    public static LinkedList<Sale> sales;
    public static Date currentDate;
    public static double totalPrice;
    public static double totalProfit;
    
    public static void init(){ //Método que inicializa las listas y las variables
        
        itemsAvailable = new LinkedList< Item >();
        itemsSold = new LinkedList< Item >();
        users = new LinkedList< User >();
        packages = new LinkedList< Package >();
        sales = new LinkedList< Sale >();
        currentDate = new Date(2,11,2020);
        totalPrice = 0.0;
        totalProfit = 0.0; 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        init();
        
        //AÑADIMOS ITEMS
        itemsAvailable.add(new UnitItem("Gaming Chair", "Furniture", new double[]{53.0, 110.0, 160.0}, 300, 500, 2));     
        itemsAvailable.add(new WeightedItem("Rice", "Food", new double[]{12.0, 22.0, 2.0}, 1.5, 2.5, 50));                
        itemsAvailable.add(new UnitItem("TV", "Appliance", new double[]{100.0, 60.0, 10.0}, 600, 1000, 4));
        
        //AÑADIMOS COMPRADORES VENDEDORES Y UN ADMINISTRADOR
        users.add(new Buyer("Marcos Navajas", "Markito", "aylutequiero", "12345678"));
        users.add(new Buyer("Oscar Bujía", "Oscaaaaaaaar", "pollo", "123456789"));
        users.add(new Buyer("Didac Sitjas", "DidacTempo", "6969", "12345678910"));
        users.add(new Seller("Daniel Leorri", "Wade", "elbaileesmivida67", "1234567891011"));
        users.add(new Administrator("Albert Gubau", "Albert", "contraseña"));
        
        //AÑADIMOS LOS PAQUETES DISPONIBLES
        packages.add(new Envelope(29, 42, "A3"));
        packages.add(new Envelope(21, 29, "A4"));
        packages.add(new Envelope(21, 11, "A5"));
        packages.add(new Box(10, 10, 10));
        packages.add(new Box(10, 10, 100));
        packages.add(new Box(10, 100, 100));
        packages.add(new Box(100, 100, 100));
        packages.add(new Box(100, 150, 300));
        packages.add(new Box(200, 300, 500));
        
        
        System.out.println("PACKAGE ASSIGNMENT FOR THE ITEMS AVAILABLE:\n");
        
        //ASIGNAMOS EL MEJOR PAQUETE PARA CADA ITEM
        for(int i = 0; i<itemsAvailable.size(); i++){
            itemsAvailable.get(i).assignBestPackage(packages);        
        }
        
        //TOMAMOS EL TERCER USUARIO COMO UN SELLER
        Seller seller = (Seller)users.get(3);
        
        //LLENAMOS LA LISTA DEL SELLER CON LOS ITEMS QUE HEMOS AÑADIDO
        for(int i = 0; i<itemsAvailable.size(); i++){
            seller.addAvailableItem(itemsAvailable.get(i));         
        }
        
        System.out.println("\nUSERS SHOPPING:\n");
        
        for(int i = 0; i<itemsAvailable.size(); i++){
            
            Item item = itemsAvailable.get(i); //TOMAMOS UN ITEM Y UN COMPRADOR
            Buyer b = (Buyer)users.get(i);
            
            b.buy(item);      //HACEMOS QUE COMPRE EL ITEM
            
            totalPrice += item.getPrice();     //INCREMENTAMOS EL PRECIO TOTAL Y APLICAMOS EL SELL SEGUN LA INSTANCIA DEL ITEM 
            
            if(item instanceof UnitItem){ 
                ((UnitItem)item).sell(0);
            
            }else if(item instanceof WeightedItem){
                ((WeightedItem)item).sell(0.0);
            }
            
            seller.sell(item); //APLICAMOS SELL DEL SELLER PARA VENDER EL ITEM
            
            
            //Crear y añadir venta!!!!!!!!!
            
            
            totalProfit += item.calculateProfit(); //AUMENTAMOS EL BENFICIO TOTAL CON EL BENEFICIO QUE OBTENEMOS DE LA VENTA DEL ITEM
            
            itemsSold.add(item); //AÑADIMOS EL ITEM A LA LISTA DE ITEMS VENDIDOS
        }
        
        for(int i=0; i<itemsAvailable.size();i++){ //BORRAMOS LOS ITEMS VENDIDOS DE LA LISTA DE ITEMS DISPONIBLES
            
            itemsAvailable.remove(i);   
        }
        
        System.out.println("\nCOMIENZO DE LA PUJA:\n");
        
        //COMIENZO DE LA PUJA
        LinkedList<AuctionItem> lai = new LinkedList<AuctionItem>(); //Creamos una lista de items para subasta
        Administrator admin = (Administrator)users.get(4); //Asignamos el rol de Administrador al quinto usuario
        Date deadline = new Date(11,11,2020);
        AuctionItem auctionitem = new AuctionItem("Armario", "Furniture", new double[]{250, 160, 450}, 10000.0, 10000.0, deadline); //Creamos un item de subasta y lo añadimos a la lista de items para subasta
        lai.add(auctionitem);
        
        System.out.println("PACKAGE ASSIGNMENT FOR THE AUCTION ITEM:\n");
        
        auctionitem.assignBestPackage(packages); //Asignamos el empaquetado del item de subasta y añadimos el item a la lista de items disponibles de la tienda y del Seller
        seller.addAvailableItem(auctionitem);
        itemsAvailable.add(auctionitem);
        
        System.out.println("\nPRESENTATION AND START OF THE AUCTION:\n");
        
        admin.printStock(lai); //Hacemos que el administrador imprima el stock de items para subasta
        
        System.out.println("\nSTART OF THE AUCTION:\n"); 
        
        if(!auctionitem.frozen(new Date(6,11,2020))){                     //Simulamos las pujas de los usuarios en diferentes fechas comprobando que estamos en una fecha en la que se puede pujar con el método frozen
            auctionitem.makeBid((Buyer)users.get(1), 10500.0);
        }
        
        if(!auctionitem.frozen(new Date(7,11,2020))){
            auctionitem.makeBid((Buyer)users.get(0), 11000.0);
        }
        
        if(!auctionitem.frozen(new Date(10,11,2020))){
            auctionitem.makeBid((Buyer)users.get(2), 12000.0);
        }
        
        admin.manageAuction(auctionitem, new Date(10,11,2020)); //Hacemos que el administrador maneje la puja el día en el que finaliza
        if(!auctionitem.frozen(new Date(10,11,2020))){
            auctionitem.makeBid((Buyer)users.get(1), 13000.0);
        }
        
        admin.expel(users.get(0)); //Hacemos que el administrador expulse a un usuario
        users.remove(users.get(0)); //Quitamos al usuario expulsado de la lista de usuarios de la tienda online
        
        Buyer buyer = auctionitem.getBuyer(); //Tomamos el comprador final del item de subasta
        buyer.buy(auctionitem); //Aplicamos buy y sell por parte del Buyer y el Seller al item de subasta
        seller.sell(auctionitem);
        
        totalPrice += auctionitem.getPrice(); //Aumentamos el precio total con el precio del item para subasta
        totalProfit += auctionitem.calculateProfit(); //Aumentamos el beneficio total con el beneficio obtenido por el item
        
        System.out.println("Total price: " + totalPrice); //Imprimimos por pantalla el precio y el beneficio total.
        System.out.println("Total profit: " + totalProfit);
    } 
}
