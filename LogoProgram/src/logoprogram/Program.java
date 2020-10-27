/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logoprogram;
import java.util.LinkedList;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Program {
    
    private LinkedList<Instruction> instructions;
    private int currentLine;
    private int loopIteration;
    private String programName;

    Program(String name){ 
        
        instructions = new LinkedList<Instruction>();
        currentLine = 0;
        loopIteration = 0;
        programName = name;
    }
    
    public String getName(){
        
        return programName;
    }
    
    public Boolean addInstruction(String c, double p){   //COMPROVAR
        
        Instruction instruction = new Instruction(c, p);
        instructions.add(instruction);
        
        return instruction.isCorrect();     
    }

    public void restart(){   //COMPROVAR
        
        currentLine = 0;
    }
    
    public Boolean hasFinished(){  //COMPROVAR
        
        return (currentLine >= instructions.size());
    }
    
    public Instruction getNextInstruction(){ //ARREGLAR
        
        Instruction instruction = instructions.get(currentLine);
        
        if(instruction.isRepInstruction()){
            
            if(instruction.getCode() == "REP"){
                
                loopIteration = (int)instruction.getParam();
            
            }else{
                
                loopIteration--; //Hemos llegado a end por tanto hemos hecho una iteracion
                
                if(loopIteration>0){
                    
                    goToStartLoop();
                    currentLine--;
                }
            }  
            
        }
        
        currentLine++;
        
        if(!hasFinished()){
            instruction = instructions.get(currentLine);
        }
        
        if(!instruction.isRepInstruction()){
            System.out.println(instruction.info());
        }
        
        return instruction;
    }
   
    public boolean isCorrect(){ //COMPROVAR
        
        int repcounter = 0; //Contador de instrucciones correctas
        
        for(Instruction instruction: instructions){ 
            
            if(!instruction.isCorrect()){
                
                return false;
            }    
                
            if(instruction.getCode() =="REP"){
                        
                repcounter++;
            }
                
            if(instruction.getCode() == "END"){
                
                repcounter--;
            }
        }
        
        return (repcounter == 0); //Comprovamos que todas las instrucciones son correctas
    }
   
    public void printErrors(){
       
        if(!isCorrect()){
            System.out.println("Hay un error.");
        }
        
        for(Instruction instruction: instructions){
            
            if(!instruction.isCorrect()){
                
                int errorcode = instruction.errorCode();
                
                if(errorcode == 1){
                    System.out.println("Error in FWD parameter");
            
        
                }else if(errorcode == 2){
                    System.out.println("Error in PEN parameter");
           
        
                }else if(errorcode == 3){
                    System.out.println("Error in ROT parameter");
            
        
                }else if(errorcode == 4){
                    System.out.println("Error in REP parameter");
            
        
                }else if(errorcode == 5){
                    System.out.println("Error in END parameter");
            
        
                }else if(errorcode == 6){
                    System.out.println("Error: there is a not valid instruction added.");
            
        
                }else if(errorcode == 0){
                    System.out.println("All correct!");
                }
            }
        }
    }
    
    private void goToStartLoop(){ //La hicimos contigo, comprovar que sea correcta
        
        int counter = 0;
        
        for(Instruction instruction: instructions){
            
            if(instruction.getCode() == "REP"){
                
                currentLine = counter + 1;
                break;
            }
            
            counter++;
        }
    }
}
