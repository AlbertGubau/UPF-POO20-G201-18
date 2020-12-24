/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;

public class Visitor extends Patient{ //La clase Visitor hereda de la clase Patient
	
    public Visitor( int id, String name, int age ){ //Método constructor
        super(id, name, age);
    }

    public String toString(){ //Método que nos permite imprimir por pantalla el nombre, identificador y edad del visitante.
        return ("Visitor "+ name + "(ID "+ id +", age "+ age + ")");
    }
}
