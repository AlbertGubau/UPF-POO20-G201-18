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
        return getAvailableBed()!=null;
    }

    public String listBeds(){ 
        
        String beds2 = "";
        for(Bed b: beds){
            beds2 = (beds2+b+"\n");
        }
        return beds2;
    }

    public String toString(){ 
        return ("Room "+ roomID);
    }
}
