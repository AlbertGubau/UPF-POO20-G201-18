/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myproject;

import java.util.*;
/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MyProject {
    
    public static void main(String[] args) {
        
        Person person1 = new Person( "Anna" );
        Person person2 = new Person( "Peter" );
        
        LinkedList< Person > personList;
        personList = new LinkedList< Person >();
        personList.add( person1 );
        personList.add( person2 );
        
        for( Person person : personList ) {
            person.printName();
        }
    }
}
    