/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Instruction {
    
    private String code;
    private double parameter;
    
    Instruction(String c, double p){  //Método constructor de la clase Instruction en el que asignamos a los atributos los valores que entran por parámetro en el constructor
        code = c;
        parameter = p;
    }
    
    public String getCode(){
        
        return code; //Devolvemos el atributo code de la instruccion
    }
    
    public double getParam(){
        
        return parameter;  //Devolvemos el atributo parameter de la instrucción
    }
    
    public Boolean isRepInstruction(){
        
        return code.equals("REP") || code.equals("END"); //Si el code de la instrucción es REP o END devolvemos true, sino false
    }
    
    public Boolean isCorrect(){
        
        return errorCode() == 0; //Devolvemos true si la funcion errorCode nos devuelve 0
    }
    
    public int errorCode(){
        
        if(code.equals("FWD")){                         //Si el code de la instruccion es FWD miramos si su parameter esta mal
             
            if(parameter < -1000 || parameter > 1000){  //Si su parameter es <-1000 o >1000 estará su paramater es incorrecto y devolvemos 1 como codigo de error
                return 1;
            }
            return 0;                                   //Si la instruccion es correcta devolvemos 0
        
        }else if(code.equals("PEN")){
             
            if(parameter != 0 && parameter != 1){
                return 2;                               //En este caso devolvemos 2 como codigo de error
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
        
        return 6;                                       //En caso de que no haya entrado en ningun if querrá decir que no es una instrucción válida, por lo tanto, devolvemos 6 como codigo de error.
    }
    
    public String info(){
        
        return code+" "+Double.toString(parameter);     //Devolvemos la instrucción al completo en forma de string
    }   
}
