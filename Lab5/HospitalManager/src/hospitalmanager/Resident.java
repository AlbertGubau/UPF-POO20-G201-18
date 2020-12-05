/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;

public class Resident extends Patient{
	
    private Room room;
    private Bed bed;

    public Resident ( int id, String name, int age ){
        super(id, name, age);
        room = null;
        bed = null;
    }

    public void assignRoom( Room r ){
        room = r;
    }

    public void assignBed( Bed b ){
        bed = b;
    }

    public Doctor getDoctor(){
        return visits.get(0).getDoctor(); //Serà el primer doctor que lo visitó
    }

    public String toString(){
        
        
        if((visits.size() == 0)){
            
            if(room == null){
                
                return ("Resident "+ name + "(ID "+ id +", age "+ age + ") and has no\nroom neither bed and has no doctor.");
            }
            return ("Resident "+ name + "(ID "+ id +", age "+ age + ") who is assigned to\n" + bed.toString() + " " + room.toString() + " and has no doctor.");
        }
        
        return ("Resident "+ name + "(ID "+ id +", age "+ age + ") who is assigned to\n" + bed.toString() +" "+room.toString() + " and " + getDoctor().toString());
    }
}
