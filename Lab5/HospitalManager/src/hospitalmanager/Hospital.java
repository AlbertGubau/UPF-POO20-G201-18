 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalmanager;

import java.util.LinkedList;
import java.util.Collections;

public class Hospital{
	
    private LinkedList< Administrative > admins;
    private LinkedList< Doctor > doctors;
    private LinkedList< Patient > patients;
    private LinkedList< Room > rooms;
    private LinkedList< Visit > visits;
    private String name;

    public Hospital( String name ){
        
        this.name = name;
        admins = new LinkedList< Administrative >();
        doctors = new LinkedList< Doctor >();
        patients = new LinkedList< Patient >();
        rooms = new LinkedList< Room >();
        visits = new LinkedList< Visit >();
    }

    public void addAdmin( Administrative a ){ admins.add(a);}

    public Administrative getAdmin( int idx ){ return admins.get(idx);}

    public void addDoctor( Doctor d ){ doctors.add(d);}

    public Doctor getDoctor( int idx ){ return doctors.get(idx);}

    public void addRoom(int id){ rooms.add(new Room(id));}

    public Room getRoom( int idx ){ return rooms.get(idx);}	

    public LinkedList< Room > getRooms(){ return rooms;}

    public void addResident(  int id, String name, int age ){
        patients.add(new Resident(id, name, age)); 
    }
    public void addVisitor( int id, String name, int age ){
        patients.add(new Visitor(id, name, age));
    }
    public void addVisit( Visit v ){
        visits.add(v);
    }
    public Visit getVisit( int idx ){
        return visits.get(idx);
    }
    public Patient getPatient( int idx ){
        return patients.get(idx);
    }
    public void deletePatient( int idx ){
        patients.remove(idx);
    }

    public void assignBeds( int adminIdx ){
        
        for(Patient p: patients){
            
            if(p instanceof Resident){
                
                Resident r = (Resident)p;
                Administrative a = getAdmin(adminIdx);
                a.assignBed(r);
            } 
        }
    }

    public void sortPatients(){
        Collections.sort(patients);
    }
    
    public String toString(){
        
        String admins2 = "";
        String doctors2 = "";
        String patients2 = "";
        String rooms2 = "";
        
        for(Administrative a: admins){
            admins2 = (admins2+a+"\n");
        }
        for(Doctor d: doctors){
            doctors2 = (doctors2+d+"\n");
        }
        for(Patient p: patients){
            patients2 = (patients2+p+"\n");
        }
        for(Room r: rooms){
            rooms2 = (rooms2+r+"\n");
            rooms2 = (rooms2+r.listBeds()+"\n");
        }
        
        return (name +"\n"+"Administratives: \n"+admins2+"\nDoctors:\n"+doctors2+"\nPatients sorted by age:\n"+patients2+"\nRooms:\n"+rooms2);
    }
}

