/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalmanager;

import java.util.LinkedList;

public class Doctor extends Person{

    private LinkedList< String > specialities;
    private LinkedList< Visit > visits;

    public Doctor( int id, String name ){
        super(id, name);
        specialities = new LinkedList<String>();
        visits = new LinkedList<Visit>();
    }

    public void addSpeciality( String s ){
        specialities.add(s);
    }

    public void addVisit( Visit v ){
        visits.add(v);
    }

    public void listSpecialities(){
        System.out.println("Doctor "+ name + "(ID " + id + ") has specialities"); //FALTA ACABAR
        for(String s: specialities){
            System.out.println(s);
        }
    }

    public void listVisits(){
        System.out.println("Doctor "+ name + "(ID " + id + ") has the following visits: "); //FALTA ACABAR
        for(Visit v: visits){
            System.out.println(v);
        }
    }

    public String toString(){ 
        return ("Doctor "+ name + "(ID " + id + ").");
    }
}
