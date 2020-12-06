/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;
import java.util.LinkedList;
import java.util.Date;

public class Patient extends Person implements Comparable<Patient>{
	
    protected Date admissionDate;
    protected Integer age;
    protected LinkedList< Visit > visits;

    public Patient( int id, String name, int age ){
        super(id, name);
        this.age = age;
        visits = new LinkedList< Visit >();
    }

    public void addVisit( Visit v ){
        visits.add(v);
    }

    public void setAdmissionDate( Date d ){
        admissionDate = d;
    }

    public Date getAdmissionDate(){
        return admissionDate;
    }

    public void setAge( Integer age ){
        this.age = age;
    }

    public Integer getAge(){
        return age;
    }

    public int compareTo( Patient p ){
           
        if(p.getAge() - getAge() > 0){
            return -1;
        }
        if(p.getAge() - getAge() < 0){
            return 1;
        }
        return 0;
    }

    public String toString(){
        return ("Patient "+ name + "(ID "+ id +", age "+ age + ").");
    }
}
