/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;

import java.util.LinkedList;

public class Room{
    
    private LinkedList< Bed > beds; //Atributos de la clase
    private int roomID;

    public Room( int room ){ //Método constructor
        roomID = room;
        beds = new LinkedList< Bed >();
    }

    public void addBed( int bedID ){ beds.add(new Bed(bedID, this));} //Método para añadir camas a la lista

    public Bed getBed( int idx ){ return beds.get(idx);} //Método para tomar una cama de la lista mediante el indice en esta

    public Bed getAvailableBed(){ //Método para tomar la cama disponible
        
        for(Bed b : beds){
            if(b.isAvailable()){ //Aplicamos el método isAvailable de la clase Bed que devuelve true si está disponible y false si no lo está
                return b;   
            }           
        }
        return null; //Si no hay camas disponibles devolvemos null
    }

    public boolean isAvailable(){ return getAvailableBed()!=null;} //Método que nos devuelve true si la habitación esta disponible (almenos una cama esta libre)

    public String listBeds(){ //Método que nos permite imprimir por pantalla las camas
        
        String beds2 = ""; //Creamos un string en el que concatenamos todas las camas de la lista
        for(Bed b: beds){
            beds2 = (beds2+b+"\n");
        }
        return beds2;
    }

    public String toString(){ //Método que nos permite imprimir por pantalla el identificador de la habitación.
        return ("Room "+ roomID);
    }
}
