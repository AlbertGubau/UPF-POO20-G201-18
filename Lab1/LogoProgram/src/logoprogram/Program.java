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
        instructions.add(instruction);
        
        return instruction.isCorrect();     
    }

    public void restart(){   
        
        currentLine = 0;
    }
    
    public Boolean hasFinished(){  
        
        return (currentLine >= instructions.size());
    }
    
    public Instruction getNextInstruction(){
        
        Instruction instruction = instructions.get(currentLine);
        
        if(instruction.isRepInstruction()){
                
            if(instruction.getCode() == "REP"){
                    
                loopIteration = (int)instruction.getParam();
                       
            }else {
                
                loopIteration--; 
                    
                if(loopIteration>0){
                        
                    goToStartLoop();
                    currentLine--;
                }
            }  
        }
        
          
        currentLine++;
        return instruction;
    }
   
    public boolean isCorrect(){ 
        
        int repcounter = 0; 
        
        for(Instruction instruction: instructions){ 
            
            if(!instruction.isCorrect()){
                
                return false;
            }    
                
            if(instruction.getCode() == "REP"){
                        
                repcounter++;
            }
                
            if(instruction.getCode() == "END"){
                
                repcounter--;
            }
        }
        
        return (repcounter == 0); 
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
    
    private void goToStartLoop(){ 
        
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
