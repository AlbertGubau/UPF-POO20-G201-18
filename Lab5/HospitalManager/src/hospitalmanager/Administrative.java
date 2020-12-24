 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalmanager;

import java.util.LinkedList;


public class Administrative extends Person{ //Administrative hereda de Person

    private Hospital hospital; //Atributo de la clase
    
    public Administrative( int id, String name, Hospital hospital ){ //Método constructor
        super(id, name);
        this.hospital = hospital;
    }

    public void addVisit( Date d, String s, Doctor doc, Patient p ){ //Método que nos permite añadir visitas a un doctor y un paciente
       hospital.addVisit(new Visit(d, s, doc, p));
       p.addVisit(new Visit(d, s, doc, p));
    }

    public boolean assignBed( Resident resident  ){ //Método que nos permite asignar una cama a un residente
        
        LinkedList< Room > rooms = hospital.getRooms();
        
        Boolean solved = false; //booleano que controla si hemos solucionado el problema (hemos asignado una cama al residente)
        
        for(Room r: rooms){ 
            
            if(r.isAvailable()){ //Si hay una habitación disponible
                
                Bed b = r.getAvailableBed(); //Tomamos la cama disponible y la asignamos al residente
                
                resident.assignRoom(r);
                resident.assignBed(b);
                
                b.assignResident(resident);
                    
                System.out.println(toString() + " has assigned bed to\n" + resident.toString());
                
                solved = true; //Hemos solucionado el probnlema por lo tanto solved = true
                break;
            }
        }
        
        if(!solved){ //Si no hemos encontrado una cama para el residente lo imprimimos por pantalla
            
            System.out.println(toString() + "has not found bed for\n"+ resident.toString());
        }
        return solved; //Devolvemos el resultado del algoritmo
    }

    public String toString(){ //Método que nos permite imprimir por pantalla el nombre y el identificador del Administrativo.
        return ("Administrative " + name + "(ID " + id + ")");		
    }
}
