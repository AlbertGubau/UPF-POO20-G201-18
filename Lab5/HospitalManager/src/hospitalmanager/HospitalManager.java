/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;
import java.util.*;
/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class HospitalManager {

    public static LinkedList<Hospital> hospitals;
    public static LinkedList<Doctor> doctors;
    public static LinkedList<Administrative>  administratives;
    public static LinkedList<Patient> patients;
    
    
    HospitalManager(LinkedList<Hospital> h, LinkedList<Doctor> d, LinkedList<Administrative> a, LinkedList<Patient> p){
        hospitals = h;
        doctors = d;
        administratives = a;
        patients = p;
    }
    
    public void addHospital(Hospital h){
        hospitals.add(h);
    }
    
    public void removeHospital(Hospital h){
        hospitals.remove(h);
    }
    
    public void addDoctor(Doctor d){
        doctors.add(d);
    }
    
    public void removeDoctor(Doctor d){
        doctors.remove(d);
    }
    
    public void addAdministrative(Administrative a){
        administratives.add(a);
    }
    
    public void removeAdministrative(Administrative a){
        administratives.remove(a);
    }
    
    public void addPatient(Patient p){
        patients.add(p);
    }
    
    public void removePatient(Patient p){
        patients.remove(p);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //METODES PER AFEGIR A LES LLISTES NO PODEN SER ADD I REMOVE? ELS HEM DE CREAR NOSALTRES?
        
        
        
        
        
        
    }
    
}
