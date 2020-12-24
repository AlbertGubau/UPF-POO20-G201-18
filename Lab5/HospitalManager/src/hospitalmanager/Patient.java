/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;
import java.util.LinkedList;
import java.util.Date;

public class Patient extends Person implements Comparable<Patient>{ //La clase Patient hereda de Person e implementa la interfaz Comparable con objetos de tipo Patient
	
    protected Date admissionDate; //Atributos de la clase
    protected Integer age;
    protected LinkedList< Visit > visits;

    public Patient( int id, String name, int age ){ //Método constructor
        super(id, name);
        this.age = age;
        visits = new LinkedList< Visit >();
    }

    public void addVisit( Visit v ){ visits.add(v);} //Método para añadir visitas a la lista

    public void setAdmissionDate( Date d ){ admissionDate = d;} //Método setter para el atributo de la fecha de admisión

    public Date getAdmissionDate(){ return admissionDate;} //Método getter para el atributo de la fecha de admisión

    public void setAge( Integer age ){ this.age = age;} //Método setter para el atributo edad

    public Integer getAge(){ return age;} //Método getter para el atributo edad

    public int compareTo( Patient p ){ //Método compareTo que devuelve -1, 0 o 1 si el objeto dado por parámetro es menor, igual o mayor que la instancia que aplica el método
           
        if(p.getAge() - getAge() > 0){
            return -1;
        }
        if(p.getAge() - getAge() < 0){
            return 1;
        }
        return 0;
    }

    public String toString(){ //Método que nos permite imprimir el nombre, el identificador y la edad del paciente.
        return ("Patient "+ name + "(ID "+ id +", age "+ age + ").");
    }
}
