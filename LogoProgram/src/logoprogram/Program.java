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
    
    public Boolean addInstruction(String c, double p){
        
        Instruction instruction = new Instruction(c, p);
        
        if(instruction.isCorrect()){
            
            instructions.add(instruction);
            return true;
        
        }else{
            
            printErrors();            
            return false;
        }     
    }
    
    public void restart(){
        
    }
    
    public Boolean hasFinished(){
        
        return false;
    }
    
    public Instruction getNextInstruction(){
        
        Instruction instruction = instructions.get(currentLine +1);
        if(instruction.isRepInstruction()){
            
            if(instruction.getCode() == "REP"){
                
                loopIteration = (int)instruction.getParam(); 
            
            }else{
                
                loopIteration--;
            }
        }
        
        
        
        
        
        currentLine++;
        return instruction; 
    }
    
    public boolean isCorrect(){
        return false; //for de todas las instrucciones de linkedList y verificar si rep o end estan para tener su valor      for (Instruction instruction: instructions)
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
            
        
                }else if(errorCode() == 2){
                    s = "Error in PEN parameter";
           
        
                }else if(errorCode() == 3){
                    s = "Error in ROT parameter";
            
        
                }else if(errorCode() == 4){
                    s = "Error in REP parameter";
            
        
                }else if(errorCode() == 5){
                    s = "Error in END parameter";
            
        
                }else if(errorCode() == 6){
                    s = "Error, the instruction is not valid.";
            
        
                }else if(errorCode() == 0){
                    s = "All correct!";
                }
            }
        }
    }
    
    private void goToStartLoop(){
        
        int counter = 0;
        
        for(Instruction instruction: instructions){
            
            if(instruction.getCode() == "REP"){
                
                currentLine = counter++;
                break;
            }
            
            counter++;
        }
    }
}
