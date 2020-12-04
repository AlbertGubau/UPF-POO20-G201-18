 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalmanager;

import java.util.LinkedList;
import java.util.Date;

public class Administrative extends Person{ 

    private Hospital hospital;	

    public Administrative( int id, String name, Hospital hospital ){
        super(id, name);
        this.hospital = hospital;
    }

    public void addVisit( Date d, String s, Doctor doc, Patient p ){
        
    }

    public boolean assignBed( Resident resident  ){
        
        LinkedList< Room > rooms = hospital.getRooms();
        
        for(Room r: rooms){
            
            if(r.isAvailable()){
                
                if(r.getAvailableBed() != null){
                
                resident.assignRoom(r);
                resident.assignBed(r.getAvailableBed());
                r.getAvailableBed().assignResident(resident);
                
                return true;
                }
            }
        }
        return false;
    }

    public String toString(){ 
        return ("Administrative " + name + "(ID " + id + ").");		
    }
}
