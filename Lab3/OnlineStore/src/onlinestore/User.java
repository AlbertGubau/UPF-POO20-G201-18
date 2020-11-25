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
    
    public User(String n, String id, String pass){ //Método constructor de la clase User
        
        name = n;
        identifier = id;
        password = pass;
    }
    
    
    public String getName(){ //getters y setters de la clase User                                               
        return name;
    }
    
    
    public String getId(){                                                   
        return identifier;
    }
    
    
    public String getPassword(){                                             
        return password;
    } 
    
    
    public void setName(String n){                                              
        name = n;
    }
    
    
    public Boolean login(String p){ //Método login para logear a un usuario                                          
        return password.equals(p);
    }
}



