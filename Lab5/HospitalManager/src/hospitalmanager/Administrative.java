 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalmanager;

import java.util.LinkedList;


public class Administrative extends Person{ 

    private Hospital hospital;	
    
    public Administrative( int id, String name, Hospital hospital ){
        super(id, name);
        this.hospital = hospital;
    }

    public void addVisit( Date d, String s, Doctor doc, Patient p ){
       hospital.addVisit(new Visit(d, s, doc, p));
       p.addVisit(new Visit(d, s, doc, p));
    }

    public boolean assignBed( Resident resident  ){
        
        LinkedList< Room > rooms = hospital.getRooms();
        
        Boolean solved = false;
        
        for(Room r: rooms){
            
            if(r.isAvailable()){
                
                Bed b = r.getAvailableBed();
                
                resident.assignRoom(r);
                resident.assignBed(b);
                
                b.assignResident(resident);
                    
                System.out.println(toString() + " has assigned bed to\n" + resident.toString());
                
                solved = true;
                break;
            }
        }
        
        if(!solved){
            
            System.out.println(toString() + "has not found bed for\n"+ resident.toString());
        }
        return solved;
    }

    public String toString(){ 
        return ("Administrative " + name + "(ID " + id + ")");		
    }
}
