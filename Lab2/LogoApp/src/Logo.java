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
    
    private int width;
    private int height;
    private Turtle t;
    
    Logo(int w, int h){
        width = w;
        height = h;
        t = new Turtle(300, 350, 1,0);
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public void resetTurtle(){
        
    }
    
    public void execute(Program p, Graphics g){
        
        t.draw(g);
        
        if(p.isCorrect()){ //Si el programa es correcto               
            
            p.restart();   //Aplicamos un restart para empezar en la primera linea del programa     
            
            while(!p.hasFinished()){ //Mientras el programa no haya finalizado
                
                Instruction instr = p.getNextInstruction(); //Obtenemos la siguiente instruccion
                
                if(!instr.isRepInstruction()){ //Si la instrucción obtenida no es REP o END
                    
                    if("FWD".equals(instr.getCode())){
                        
                        int x = t.getX();
                        int y = t.getY();
                        
                        t.forward(instr.getParam());
                        
                        if(t.isPenOn()){
                            g.drawLine(x, y,t.getX(),t.getY());
                        }
                        
                        t.draw(g);
                        
                    } else if("ROT".equals(instr.getCode())){
                            
                            t.turn(instr.getParam());
                            t.draw(g);
                    
                    }else if("PEN".equals(instr.getCode())){
                        
                        double on = instr.getParam();
                        
                        if(on == 0){
                            t.setPen(false);
                        
                        } else if(on == 1){
                            t.setPen(true);
                        }
                        
                        t.draw(g);    
                    }
                    
                    System.out.println(instr.info()); //La imprimimos por pantalla
                }
            }
        }else{ //En caso de que el programa no sea correcto imprimiremos los errores con el método printErrors de la clase Program.
           p.printErrors(); 
        }
    }
}
