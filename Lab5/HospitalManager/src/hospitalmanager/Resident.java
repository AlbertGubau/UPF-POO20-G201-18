/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;

public class Resident extends Patient{ //La clase Resident hereda de la clase Patient
	
    private Room room; //Atributos de la clase
    private Bed bed;

    public Resident ( int id, String name, int age ){ //Método constructor
        super(id, name, age);
        room = null;
        bed = null;
    }

    public void assignRoom( Room r ){ room = r;} //Método que nos permite asignar una habitación al residente
    
    public void assignBed( Bed b ){ bed = b;} //Método que nos permite asignar una cama al residente
    
    public Doctor getDoctor(){ return visits.get(0).getDoctor();} //Método que nos permite tomar el doctor del Residente
    
    public String toString(){ //Método que nos permite imprimir por pantalla la información del residente
        
        if((visits.size() == 0)){ //Si no hay visitas no tiene doctor asignado
            
            if(room == null){ //Si no tiene habitación asignada
                return ("Resident "+ name + "(ID "+ id +", age "+ age + ") and has no\nroom neither bed and has no doctor."); //Si no tiene ni cama ni doctor asignado
            }
            return ("Resident "+ name + "(ID "+ id +", age "+ age + ") who is assigned to\n" + room.toString() + " " + bed.toString() + " and has no doctor."); //Si no tiene doctor asignado pero si cama
        }
        return ("Resident "+ name + "(ID "+ id +", age "+ age + ") who is assigned to\n" + room.toString() +" "+ bed.toString() + " and " + getDoctor().toString()); //Si tiene cama y doctor asignados.
    }
}
