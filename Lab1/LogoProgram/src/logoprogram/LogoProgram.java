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
public class LogoProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Program p = new Program("Square"); //Creamos una nueva instancia de la clase Program, el nombre del programa será Square
        p.addInstruction("REP", 4);        //Añadimos las instrucciones del programa
        p.addInstruction("FWD", 100);
        p.addInstruction("ROT", 90);
        p.addInstruction("END", 1);
        
        if(p.isCorrect()){ //Si el programa es correcto               
            p.restart();   //Aplicamos un restart para empezar en la primera linea del programa     
            
            while(!p.hasFinished()){ //Mientras el programa no haya finalizado
                Instruction instr = p.getNextInstruction(); //Obtenemos la siguiente instruccion
                
                if(!instr.isRepInstruction()){ //Si la instrucción obtenida no es REP o END
                    
                    System.out.println(instr.info()); //La imprimimos por pantalla
                }
            }
        }else{ //En caso de que el programa no sea correcto imprimiremos los errores con el método printErrors de la clase Program.
           p.printErrors(); 
        }
    }
}
