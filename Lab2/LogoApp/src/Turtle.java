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
public class Turtle {
    
    private int x; //Atributos de la clase Turtle
    private int y;
    private double dirX;
    private double dirY;
    private Boolean pen;
    
    Turtle(int x, int y, double dirX, double dirY){ //Constructor de la clase Turtle
        this.x = x;
        this.y = y;
        this.dirX = dirX;
        this.dirY = dirY;
        pen = false;   //En un inicio el pen no dibuja
    }
 
    public int getX(){ //Getters de la clase turtle que devuelven la posición o la dirección
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public double dirX(){
        return dirX;
    }
    
    public double dirY(){
        return dirY;
    }
    
    public void setX(int x){ //Setters de la posición individual, de la coordenada y de la dirección
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public void setCoord(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void setDirX(double dirX){
        this.dirX = dirX;
    }
    
    public void setDirY(double dirY){
        this.dirY = dirY;
    }
    
    public void setDir(int dx, int dy){
        this.dirX = dx;
        this.dirY = dy;
    }
    
    public void forward(double distance){ //Método para avanzar la tortuga
        
        x += distance * dirX;
        y += distance * dirY;     
    }
    
    public void turn(double a){ //Método para girar la tortuga
        
        double ar = a * Math.PI/180; //Pasamos el angulo de grados a radianes
        
        double dirXanterior = dirX; //Tomamos la dirección anterior
        double dirYanterior = dirY;
        
        dirX = Math.cos(ar)*dirXanterior - Math.sin(ar)*dirYanterior; //Aplicamos las formulas correspondientes para adoptar la nueva dirección 
        dirY = Math.sin(ar)*dirXanterior + Math.cos(ar)*dirYanterior;
        
    }
    
    public void setPen(Boolean on){ //Setter del pen
        pen = on;
    }
    
    public Boolean isPenOn(){ //Getter del pen
        return pen;
    }
    
    public void draw(Graphics g){ //Método que dibujará la tortuga por pantalla
        
        int nPoints = 3; //Puntos del triangulo
        
        int[] xc = new int[3]; //Array de coordenadas x de los puntos del triangulo
        int[] yc = new int[3]; //Array de coordenadas y de los puntos del triangulo
        
        xc[0] = (int)(x+8*dirY); //Coordenadas de los puntos del triangulo
        yc[0] = (int)(y-8*dirX);
        
        xc[1] = (int)(x-8*dirY); 
        yc[1] = (int)(y+8*dirX);
        
        xc[2] = (int)(x+16*dirX); 
        yc[2] = (int)(y+16*dirY);
        
        g.drawPolygon(xc, yc, nPoints); //Llamada al método drawPolygon de la clase Graphics para dibujar el triangulo
    }
    
}
