/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Graphics;
import java.lang.Math;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Turtle {
    
    private int x;
    private int y;
    private double dirX;
    private double dirY;
    private Boolean pen;
    
    Turtle(int x, int y, double dx, double dy){
        this.x = x;
        this.y = y;
        dirX = dx;
        dirY = dy;
    }
 
    public int getX(){
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
    
    public void setX(int x){
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
    
    public void forward(double distance){
        
        x += distance * dirX;
        y += distance * dirY;     
    }
    
    public void turn(double a){ //COMPROVAR
        
        double ar = a * Math.PI/180;
        
        double dirXanterior = dirX;
        double dirYanterior = dirY;
        
        dirX = Math.cos(ar)*dirXanterior - Math.sin(ar)*dirYanterior;
        dirY = Math.sin(ar)*dirXanterior + Math.cos(ar)*dirYanterior;
        
    }
    
    public void setPen(Boolean on){
        pen = on;
    }
    
    public Boolean isPenOn(){
        return pen;
    }
    
    public void draw(Graphics g){
        
        int nPoints = 3;
        
        int[] xc = new int[3];
        int[] yc = new int[3];
        
        xc[0] = (int)(x+8*dirY);
        yc[0] = (int)(y-8*dirX);
        
        xc[1] = (int)(x-8*dirY); 
        yc[1] = (int)(y+8*dirX);
        
        xc[2] = (int)(x+16*dirX); 
        yc[2] = (int)(y+16*dirY);
        
        g.drawPolygon(xc, yc, nPoints);
    }
    
}
