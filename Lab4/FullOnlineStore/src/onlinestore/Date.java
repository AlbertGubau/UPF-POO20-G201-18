/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlinestore;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Date implements Comparable{ //La clase Date implementará la interfaz Comparable
    
    private int day;
    private int month;
    private int year;
    
    Date(int d, int m, int y){ //Método constructor de la clase Date
        day = d;
        month = m;
        year = y;
    }
    
    public int getDay(){ //getters y setters de sus atributos
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public void setDay(int d){
       day = d; 
    }
    public void setMonth(int m){
        month = m;
    }
    public void setYear(int y){
        year = y;
    }
    
    @Override
    public int compareTo(Object o){ //Redefinición del método compareTo de la interfaz Comparable en la que se devolverá -1 si la fecha con la que comparamos es posterior, 1 si es anterior y 0 si es la misma fecha
        
        if(o instanceof Date){
            
            Date date = (Date)o;
            
            if(year < date.getYear()){
                return -1;
            }
            else if(year > date.getYear()){
                return 1;
            }
            else if(month < date.getMonth()){
                return -1;
            }
            else if (month > date.getMonth()){
                return 1;
            }
            else if(day < date.getDay()){
                return -1;
            }
            else if (day > date.getDay()){
                return 1;
            }
        }
        return 0;
    }
}
