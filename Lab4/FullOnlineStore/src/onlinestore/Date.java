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
public class Date implements Comparable{
    
    private int day;
    private int month;
    private int year;
    
    Date(int d, int m, int y){
        day = d;
        month = m;
        year = y;
    }
    
    public int getDay(){
        return day;
    }
    
    public int getMonth(){
        return month;
    }
    
    public int getYear(){
        return year;
    }
    
    @Override
    public int compareTo(Object o){
        
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
