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
    }

    public void addBed( int bedID ){
        //beds.add(bed);
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

    public String listBeds(){
        
        /*for(int i: beds){
            
            System.out.println("Bet :"+getBed(i));
        }*/
        return "Beeeed";
    }

    public String toString(){ 
        return ("More beeeeds");
    }
}
