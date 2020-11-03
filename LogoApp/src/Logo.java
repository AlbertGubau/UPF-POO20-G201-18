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
        t = new Turtle();
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
        
    }
}
