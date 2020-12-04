 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalmanager;

public class Bed{ //COMPROVAR

    private int bedID;
    private Room room;
    private Resident resident;

    public Bed( int id, Room r ){
        bedID = id;
        room = r;
    }

    public void assignRoom( Room r ){
        room = r;
    }

    public void assignResident( Resident r ){
        resident = r;
    }

    public void release(){
        bedID = 0;
        room = null;
        resident = null;
    }

    public int getBedID(){
        return bedID;
    }

    public boolean isAvailable(){
        return (room == null && resident == null);
    }	

    public String toString(){
        return ("Bed: ");
    }
}
