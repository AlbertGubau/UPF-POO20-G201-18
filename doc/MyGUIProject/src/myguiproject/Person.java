/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myguiproject;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Person {
    private String name;
    private String age;

    public Person( String initName, String initAge ){
        name = initName;
        age = initAge;
    }
    
    public void printName(){
        System.out.println( name );
    }
    
    public void printAge(){
        System.out.println( age );
    }
}