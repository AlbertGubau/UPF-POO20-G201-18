/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;

public class Visit{
    
    Date date; //Atributos de la clase
    String summary;
    Doctor doctor;
    Patient patient;

    public Visit( Date d, String s, Doctor doc, Patient p ){ //Método constructor de la clase
        date = d;
        summary = s;
        doctor = doc;
        patient = p;
    }

    public Date getDate(){ return date;} //getters y setters de los atributos
    
    public String getSummary(){ return summary;}
    
    public Doctor getDoctor(){ return doctor;}
    
    public Patient getPatient(){ return patient;	}

    public String toString(){ return("Visit with doc: " + doctor.toString());} //Método toString para poder imprimir por pantalla
}
    