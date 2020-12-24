 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalmanager;

public class Bed{                           

    private int bedID; //Atributos de la clase
    private Room room;
    private Resident resident;

    public Bed( int id, Room r ){ //Método constructor
        bedID = id;
        room = r;
        resident = null;
    }

    public void assignRoom( Room r ){ room = r;} //Método setter del atributo habitación

    public void assignResident( Resident r ){ resident = r;} //Método setter del atributo residente

    public void release(){ resident = null;} //Método para liberar una cama

    public int getBedID(){ return bedID;} //Método para tomar el identificador de la cama

    public boolean isAvailable(){ return resident == null;} //Método para saber si una cama está disponible

    public String toString(){ return ("Bed " + bedID);} //Método que nos permite imprimir por pantalla el identificador de la cama.
}
