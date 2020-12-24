/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalmanager;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Date{
    
    private int day;
    private int month;
    private int year;
    
    Date(int d, int m, int y){ 
        day = d;
        month = m;
        year = y;
    }
    
    public int getDay(){ return day;}
    
    public int getMonth(){ return month;}
    
    public int getYear(){ return year;}
    
    public void setDay(int d){ day = d; }
    
    public void setMonth(int m){ month = m;}
    
    public void setYear(int y){ year = y;} 
}
