/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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

    Program(String name){       //Método constructor de la clase Program en el que inicializamos los atributos de la clase Program y asignamos el nombre del programa mediante el parámetro de entrada del método
        
        instructions = new LinkedList<Instruction>(); //Creamos una nueva LinkedList en la que sus elementos sean instrucciones
        currentLine = 0;
        loopIteration = 0;
        programName = name;
    }
    
    public Instruction getCurrentLine(){ //NUEVO METODO COMPROBAR
        return instructions.get(currentLine);
    }
    
    public String getName(){
        
        return programName;   //Devolvemos el nombre del programa
    }
    
    public Boolean addInstruction(String c, double p){   
        
        Instruction instruction = new Instruction(c, p);  //Creamos una instancia de la clase Instruction para crear una instruccion que tiene como code y parameter los parámetros de entrada del método addInstruction
        instructions.add(instruction); //Añadimos la instrucción a la LinkedList de instrucciones
        
        return instruction.isCorrect(); //Devolvemos si la instruccion es correcta mediante el método isCorrect de la clase Instruction
    }

    public void restart(){   
        
        currentLine = 0;   //Asignamos a currentLine el valor de 0, es decir, volvemos al inicio del programa
    }
    
    public Boolean hasFinished(){  
        
        return (currentLine >= instructions.size()); //Devolvemos true si la linea en la que nos encontramos es mayor o igual que el tamaño de la lista de instrucciones, es decir, si ha acabado el programa
    }
    
    public Instruction getNextInstruction(){
        
        Instruction instruction = instructions.get(currentLine);  //Obtenemos la instruccion correspondiente a la currenLine y la almacenamos en instruction
        
        if(instruction.isRepInstruction()){  //Comprobamos si el code de la instruccion es REP o END
                
            if(instruction.getCode() == "REP"){ //Si el code es REP entonces tomaremos su parameter puesto que este será nuestro atributo loopIteration, es decir, las iteraciones que nos quedan
                    
                loopIteration = (int)instruction.getParam();
                       
            }else { //Si el code de la instruccion no es REP será END puesto que hemos aplicaco isRepInstruction, por lo tanto, deberemos restar una iteración porque hemos llegado al final
                
                loopIteration--; 
                    
                if(loopIteration>0){  //Comprobamos si aun quedan iteraciones, si quedan iremos al inicio del loop con goToStartLoop y restaremos en la currentLine para no interferir en las siguientes lineas de codigo
                        
                    goToStartLoop();
                    currentLine--;
                }
            }  
        }
          
        currentLine++; //Avanzamos en uno la linea en la que nos encontramos
        return instruction; //Devolvemos la instrucción que se deberá imprimir por pantalla
    }
   
    public boolean isCorrect(){ 
        
        int repcounter = 0; //Inicializamos un contador de instrucciones con codigo REP a 0
        
        for(Instruction instruction: instructions){ //Iteramos por la lista de instrucciones en busca de una instruccion con codigo REP
            
            if(!instruction.isCorrect()){ //Si de inicio hay una instrucción incorrecta devolvemos false      
                
                return false;
            }    
                
            if(instruction.getCode() == "REP"){ //Si no hay una instrucción incorrecta y encontramos una instruccion con codigo REP entonces aumentamos el contador en una unidad
                        
                repcounter++;
            }
                
            if(instruction.getCode() == "END"){ //Si encontramos una instruccion con codigo END podemos restar el contador de REP porque ya hemos encontrado la instruccion con codigo END correspondiente al REP anterior
                
                repcounter--;
            }
        }
        
        return (repcounter == 0); //El programa sera correcto si para cada instruccion con codigo REP hay una instruccion con codigo END, es decir, repcounter = 0.
    }
   
    public void printErrors(){
       
        if(!isCorrect()){                               //En primer lugar comprobaremos si el programa es correcto con isCorrect, si no lo és imprimiremos por pantalla que hay un error.
            System.out.println("Hay un error.");
        }
        
        for(Instruction instruction: instructions){ //Iteramos en la lista de instrucciones en busca de una instruccion incorrecta
            
            if(!instruction.isCorrect()){ //Si una instruccion es incorrecta
                
                int errorcode = instruction.errorCode(); //Inicializamos un entero llamado errorcode con el resultado de aplicar el método errorCode a la instrucción incorrecta
                
                if(errorcode == 1){                                 //Según el valor de errorcode imprimiremos el error que ha habido
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
        
        int counter = 0; //Inicializamos un contador de lineas a 0
        
        for(Instruction instruction: instructions){ //Iteramos en la lista de instrucciones
            
            if(instruction.getCode() == "REP"){ //Si encontramos una instrucción con código REP
                
                currentLine = counter + 1; //Asignaremos a currentLine el valor de la linea en la que la hemos encontrado +1 para ir a la primera instruccion despues de REP
                break; //Aplicamos un break porque no tendremos que seguir iterando
            }
            
            counter++; //Si no la encontramos aumentamos el contador de lineas en una unidad.
        }
    }
}
