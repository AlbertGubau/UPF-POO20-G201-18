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
public class Administrator extends User{ //Administrator es una clase hija de User por lo tanto usamos la keyword extends
   
    public Administrator(String n, String id, String p){
        super(n, id, p); //Usamos super para llamar al constructor de la clase padre e inicializamos los demás atributos
    }
    
    public Boolean expel(User u){ //Método hipotético que expulsa un usuario (imprime la acción por pantalla y devuelve true)  
        
        System.out.println(getName() + " has expelled the user " + u.getName() + ".");
        return true;
    }
    
    public Boolean manageAuction(AuctionItem a, Date date){ //Método que permite manejar la subasta siempre que nos encontremos en una fehc vàlida, i.e, que no hayamos pasado el deadline                                                          
        
        if(!a.frozen(date)){
            System.out.println(getName() + " is managing the item " + a.getName() + " at " + date.getDay()+"/"+ date.getMonth()+"/"+ date.getYear() + "."); //Imprime por pantalla quien esta a carga de la subasta y devuelve true si estamos en una fecha válida
            return true;
        }
        return false; //Si no estamos en una fecha válida devuelve false
    }
    
    public void printStock(LinkedList<AuctionItem> item){ //Método que nos permite imprimir el Stock de items para subasta
        
        System.out.println("The administrator "+ getName() + " is going to show the auction items: "); //Se imprime el nombre del administrador que está a cargo de la subasta
        
        for (Item i: item){
            Date date = ((AuctionItem)i).getDeadline();
            System.out.println(i.getName() + " has current price without IVA of " + i.getPrice()+ " and deadline " + date.getDay()+"/"+ date.getMonth()+"/"+ date.getYear() + "."); //Se imprimen los items disponibles para subasta y su Deadline.
        }
    }
}
