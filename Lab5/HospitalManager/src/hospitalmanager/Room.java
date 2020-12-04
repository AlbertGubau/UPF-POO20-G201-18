/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;

import java.util.LinkedList;

public class Room{
    
    private LinkedList< Bed > beds;
    private int roomID;

    public Room( int room ){
        roomID = room;
        beds = new LinkedList< Bed >();
    }

    public void addBed( int bedID ){
        
        beds.add(new Bed(bedID, this));
    }

    public Bed getBed( int idx ){
        return beds.get(idx);
    }

    public Bed getAvailableBed(){
        
        for(Bed b : beds){
            
            if(b.isAvailable()){
                return b;   
            }           
        }
        return null;
    }

    public boolean isAvailable(){
        
        for(Bed b : beds){
            if(b.isAvailable()){
                return true;
            }
        }
        return false;
    }

    public void listBeds(){ //Pase de String a void
        
        System.out.println("Room with ID: " + roomID + " has the following beds: "); //FALTA ACABAR
        for(Bed b: beds){
            System.out.println(b);
        }
    }

    public String toString(){ 
        return ("More beeeeds");
    }
}
