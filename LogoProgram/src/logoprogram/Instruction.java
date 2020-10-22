/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logoprogram;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Instruction {
    
    private String code;
    private double parameter;
    
    Instruction(String c, double p){
        
    }
    
    public String getCode(){
        return null;   
    }
    
    public double getParam(){
        return 0;
    }
    
    public Boolean isRepInstruction(){
        
        
        return false;
    }
    
    public Boolean isCorrect(){
        return false;
    }
    
    public int errorCode(){
        return 0;
    }
    
    public String info(){
        return null;
    }
    
}
