/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Graphics;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Logo {
    
    private int width;   //Atributos de la clase Logo
    private int height;
    private Turtle t;
    
    Logo(int w, int h){  //Constructor de la clase Logo en el que inicializamos width y height con los valores que entran por parámetro
        width = w;
        height = h;
        t = new Turtle(300, 350, 1,0); //Inicializamos una nueva tortuga en la posición x = 300 y = 350 y la dirección dirX = 1, dirY = 0
    }
    
    public int getWidth(){ //Getter que devuelve el atributo width de la ventana
        return width;
    }
    
    public int getHeight(){ //Getter que devuelve el atributo height de la ventana
        return height;
    }
    
    public void resetTurtle(){ //Método que resetea la tortuga en la posición inicial y con el pen en false
        t.setCoord(300,350);
        t.setPen(false);
    }
    
    public void execute(Program p, Graphics g){
        
        t.draw(g); //Dibujamos la tortuga
        
        if(p.isCorrect()){ //Si el programa es correcto               
            
            p.restart();   //Aplicamos un restart para empezar en la primera linea del programa     
            
            while(!p.hasFinished()){ //Mientras el programa no haya finalizado
                
                Instruction instr = p.getNextInstruction(); //Obtenemos la siguiente instruccion
                
                if(!instr.isRepInstruction()){ //Si la instrucción obtenida no es REP o END
                    
                    if("FWD".equals(instr.getCode())){ //Si el código de la instrucción es FWD
                        
                        int x = t.getX(); //Nos guardamos las coordenadas anteriores
                        int y = t.getY();
                        
                        t.forward(instr.getParam()); //Avanzamos la posición de la tortuga
                        
                        if(t.isPenOn()){
                            g.drawLine(x, y,t.getX(),t.getY()); //Si el pen está activado (true) dibujamos la línea desde la posición inicial hasta la que hemos avanzado
                        }
                        
                        t.draw(g); //Dibujamos la tortuga
                        
                    } else if("ROT".equals(instr.getCode())){ //Si el código de la instrucción es ROT
                            
                            t.turn(instr.getParam()); //Aplicamos la función turn de la clase Turtle con el angulo que vendrá dado por el parámetro de la instrucción
                            t.draw(g); //Dibujamos la tortuga
                    
                    }else if("PEN".equals(instr.getCode())){ //Si el código de la instrucción es PEN
                        
                        double on = instr.getParam(); //Tomamos el valor del parámetro de la instrucción
                        
                        if(on == 0){ //Si el parámetro es 0 aplicamos setPen y le asignamos el valor de false, sino, si es 1 le asignamos el valor de true
                            t.setPen(false);
                        
                        } else if(on == 1){
                            t.setPen(true);
                        }
                        
                        t.draw(g);    //Diubjamos la tortuga
                    }
                    
                    System.out.println(instr.info()); //Imprimimos la instrucción por pantalla
                }
            }
            
            resetTurtle(); //Reseteamos la tortuga
        
        }else{ //En caso de que el programa no sea correcto imprimiremos los errores con el método printErrors de la clase Program.
           p.printErrors(); 
        }
    }
}
