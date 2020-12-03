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
	
	public void addAdmin( Administrative a ){	
            admins.add(a);
	}

	public Administrative getAdmin( int idx ){
            return admins.get(idx);
	}
	
	public void addDoctor( Doctor d ){
            doctors.add(d);
	}

	public Doctor getDoctor( int idx ){
           return doctors.get(idx);
	}

	public void addRoom(int id){
            rooms.add(new Room(id));
	}

	public Room getRoom( int idx ){
            return rooms.get(idx);
	}	
	
	public LinkedList< Room > getRooms(){
            return rooms;
	}
	
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
		// Add code here
	}

	public void sortPatients(){
		// Add code here
	}
	
	public String toString(){
            return ("Hola");
	}

}
