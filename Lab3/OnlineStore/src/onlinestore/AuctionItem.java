/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

/**
 *
 * @author oriol
 */
public class AuctionItem extends Item{
    
    private double currentPrice;
    private Buyer bidder;
    private String deadline;
    static final int fee = 5;
    static final double percent = 0.05;
    
    AuctionItem(String n, String t, double[] s, double c, double startingPrice, String d){  
        
        super(n,t,s,c);
        
        currentPrice = startingPrice;
        deadline = d;
    }
    
    @Override
    public double getPrice(){
        return currentPrice;     
    }
   
    @Override
    public double calculateProfit(){
        return 0;
    }
    
    public void makeBid(Buyer b, double p){ 
        
        if(p > currentPrice){
            bidder = b;
            currentPrice = p;
        }
    }
    
    public Boolean frozen(String d){ 
        
        int actualday = Integer.parseInt(d.substring(0, 2));
        int actualmonth = Integer.parseInt(d.substring(2, 4));
        int actualyear = Integer.parseInt(d.substring(4, 8));
        
        int lastday = Integer.parseInt(deadline.substring(0, 2));
        int lastmonth = Integer.parseInt(deadline.substring(2, 4));
        int lastyear = Integer.parseInt(deadline.substring(4, 8));
        
        return !(actualyear <= lastyear && actualmonth<=lastmonth && actualday<=lastday);
    }
    
    public Buyer getBuyer(){
        return bidder;
    }
    
    public String getDeadline(){ //DONE
        return deadline;
    }
}
