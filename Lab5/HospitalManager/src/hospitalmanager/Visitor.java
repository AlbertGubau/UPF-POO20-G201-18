/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;

public class Visitor extends Patient{
	
    public Visitor( int id, String name, int age ){
        super(id, name, age);
    }

    public String toString(){ 
        return ("Hola");
    }
}
