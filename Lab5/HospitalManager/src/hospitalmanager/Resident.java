/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;

public class Resident extends Patient{
	
    private Room room;
    private Bed bed;

    public Resident ( int id, String name, int age ){

        super(id, name, age);
    }

    public void assignRoom( Room r ){
        room = r;
    }

    public void assignBed( Bed b ){
        bed = b;
    }

    public Doctor getDoctor(){
        return null; 
    }

    public String toString(){
        return ("Hola");
    }
}
