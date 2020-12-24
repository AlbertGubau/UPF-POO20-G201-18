/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalmanager;

import java.util.LinkedList;

public class Doctor extends Person{ //La clase Doctor hereda de Person

    private LinkedList< String > specialities; //Atributos de la clase
    private LinkedList< Visit > visits;

    public Doctor( int id, String name ){ //Método constructor
        super(id, name);
        specialities = new LinkedList<String>();
        visits = new LinkedList<Visit>();
    }

    public void addSpeciality( String s ){ specialities.add(s);} //Método para añadir especialidades del Doctor

    public void addVisit( Visit v ){ visits.add(v);} //Método para añadir visitas del Doctor
    
    public void removeVisit( Visit v ){ visits.remove(v);} //Método para borrar visitas del Doctor

    public LinkedList<Visit> getVisits(){ return visits;} //Método para tomar la lista de visitas del Doctor
    
    public void listSpecialities(){ //Método para imprimir por pantalla las especialidades del Doctor
        
        System.out.println("Doctor "+ name + "(ID " + id + ") has specialities:");
        
        for(String s: specialities){
            System.out.println(s);
        }
    }
    public void listVisits(){ //método para imprimir por pantalla las visitas del Doctor
        
        System.out.println("Doctor "+ name + "(ID " + id + ") has the following visits:\n");
        
        for(Visit v: visits){
            System.out.println(v);
        }
    }
    public String toString(){ //Método que nos permite imprimir por pantalla el nombre y el identificador del Doctor.
        return ("Doctor "+ name + "(ID " + id + ")");
    }
}
