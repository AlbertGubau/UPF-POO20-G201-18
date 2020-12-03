/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalmanager;

import java.util.LinkedList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Hospital {

    private String name;
    private LinkedList<Doctor> doctors;
    private LinkedList<Administrative> administratives;
    private LinkedList<Patient> patients;
    private LinkedList<Room> rooms;
    
    Hospital(String n, LinkedList<Doctor> d, LinkedList<Administrative> a, LinkedList<Patient> p, LinkedList<Room> r){
        name = n;
        doctors = d;
        administratives = a;
        rooms = r;
    }
    
    public String getName(){
        return name;
    }
    
    
}
