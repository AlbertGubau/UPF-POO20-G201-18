/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myproject;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Person {
    private String name;

    public Person( String initName ){
        name = initName;
    }
    
    public void printName(){
        System.out.println( name );
    }
}
