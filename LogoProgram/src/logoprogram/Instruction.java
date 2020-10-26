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
        code = c;
        parameter = p;
    }
    
    public String getCode(){
        
        return code;   
    }
    
    public double getParam(){
        
        return parameter;
    }
    
    public Boolean isRepInstruction(){
        
        return code.equals("REP") || code.equals("END");
    }
    
    public Boolean isCorrect(){
        
        return errorCode() == 0;
    }
    
    public int errorCode(){
        
        if(code.equals("FWD")){
             
            if(parameter < -1000 || parameter > 1000){
                return 1;
            }
            return 0;
        
        }else if(code.equals("PEN")){
             
            if(parameter != 0 && parameter != 1){
                return 2;
            }
            return 0;
       
        }else if(code.equals("ROT")){
             
            if(parameter <= -360 || parameter >= 360){
                return 3;
            }
            return 0;
        
        }else if(code.equals("REP")){
            
            if(parameter <= 0 || parameter >= 1000){
                return 4;
            }
            return 0;
        
        }else if(code.equals("END")){
            
            if(parameter <= 0 || parameter >= 1000){
                return 5;
            }
            return 0;
        }
        
        return 6;
    }
    
    public String info(){
        
        return code+" "+Double.toString(parameter);
    }   
    
    
}
