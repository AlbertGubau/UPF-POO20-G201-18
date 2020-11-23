/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

/**
 *
 * @author oriol
 */
public class User {
    
    private String name;
    private final String identifier;
    private final String password;
    
    public User(String n, String id, String pass){
        
        name = n;
        identifier = id;
        password = pass;
    }
    
    
    public String getName(){                                                   //DONE
        return name;
    }
    
    
    public String getId(){                                                     //DONE
        return identifier;
    }
    
    
    public String getPassword(){                                               //DONE
        return password;
    } 
    
    
    public void setName(String n){                                              //DONE
        name = n;
    }
    
    
    public Boolean login(String p){                                             //COMPROVAR
        return password.equals(p);
    }
}



