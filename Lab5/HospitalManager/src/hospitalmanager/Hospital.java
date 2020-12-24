 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalmanager;

import java.util.LinkedList;
import java.util.Collections;

public class Hospital{
	
    private LinkedList< Administrative > admins; //Atributos de la clase
    private LinkedList< Doctor > doctors;
    private LinkedList< Patient > patients;
    private LinkedList< Room > rooms;
    private LinkedList< Visit > visits;
    private String name;

    public Hospital( String name ){ //Método constructor
        
        this.name = name;
        admins = new LinkedList< Administrative >();
        doctors = new LinkedList< Doctor >();
        patients = new LinkedList< Patient >();
        rooms = new LinkedList< Room >();
        visits = new LinkedList< Visit >();
    }

    public void addAdmin( Administrative a ){ admins.add(a);} //Método para añadir administrativos

    public Administrative getAdmin( int idx ){ return admins.get(idx);} //Método para tomar un administrativo de la lista dado su indice en ella

    public void addDoctor( Doctor d ){ doctors.add(d);} //Método para añadir doctores

    public Doctor getDoctor( int idx ){ return doctors.get(idx);} //Método para tomar un doctor de la lista dado su indice en ella

    public void addRoom(int id){ rooms.add(new Room(id));} //Método para añadir habitaciones

    public Room getRoom( int idx ){ return rooms.get(idx);} //Método para tomar una  habitación de la lista dado su indice en ella	

    public LinkedList< Room > getRooms(){ return rooms;} //Método para tomar la lista de habitaciones

    public void addResident(  int id, String name, int age ){ //Método para añadir residentes
        patients.add(new Resident(id, name, age)); 
    }
    public void addVisitor( int id, String name, int age ){ //Método para añadir visitantes
        patients.add(new Visitor(id, name, age));
    }
    public void addVisit( Visit v ){ //Método para añadir visitas
        visits.add(v);
    }
    public Visit getVisit( int idx ){ //Método para tomar una visita de la lista dado su indice en ella
        return visits.get(idx);
    }
    public Patient getPatient( int idx ){ //Método para tomar un paciente de la lista dado su indice en ella
        return patients.get(idx);
    }
    public void deletePatient( int idx ){ //Método para borrar a un paciente de la lista dado su indice en ella
        patients.remove(idx);
    }

    public void assignBeds( int adminIdx ){ //Método para asignar camas a los pacientes de tipo residente
        
        for(Patient p: patients){
            
            if(p instanceof Resident){
                
                Resident r = (Resident)p;
                Administrative a = getAdmin(adminIdx); //Asignamos la cama al residente
                a.assignBed(r);
            } 
        }
    }

    public void sortPatients(){ //Método para ordenar los pacientes por edad
        Collections.sort(patients);
    }
    
    public String toString(){ //Método para poder imprimir la información de los pacientes de manera correcta
        
        String admins2 = ""; //Creamos strings en los que almacenamos los elementos concatenados
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
        
        return (name +"\n"+"Administratives: \n"+admins2+"\nDoctors:\n"+doctors2+"\nPatients sorted by age:\n"+patients2+"\nRooms:\n"+rooms2); //Devolvemos los strings creados
    }
}

