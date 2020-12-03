 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalmanager;

import java.util.LinkedList;
import java.util.Date;

public class Administrative extends Person{ //EXTENDS?

	private Hospital hospital;	
	
	public Administrative( int id, String name, Hospital hospital ){
            super(id, name);
            this.hospital = hospital;
	}
	
	public void addVisit( Date d, String s, Doctor doc, Patient p ){

	}

	public boolean assignBed( Resident resident  ){
            return false;
	}
	
	public String toString(){ 
            return ("hola");		
 	}
}
