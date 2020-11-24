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
    public static final int fee = 5;
    public static final double percent = 0.05;
    
    AuctionItem(String n, String t, double[] s, double c, double startingPrice, String d){  
        
        super(n,t,s,c);
        
        currentPrice = startingPrice;
        deadline = d;
    }
    
    @Override
    public double getPrice(){ //DONE
        
        return currentPrice;     
    }
   
    @Override
    public double calculateProfit(){ //COMO LO HACEMOS, LO HEMOS INTENTADO PLANTEAR PERO NO LO VEMOS CLARO, NECESITAMOS EL FEE Y EL PERCENT?
        
        if(bidder == null ){
            
            return fee;
        }
        return fee + getPrice()*percent;
    }
    
    public void makeBid(Buyer b, double p){ //ES CORRECTO O FALTARIA ALGO MÁS?
        
        if(p > currentPrice){
            
            bidder = b;
            currentPrice = p;
            
            System.out.println(bidder.getName() + " has bid " + currentPrice + " for the " + getName() + ". Who gives more? I heard "+ (currentPrice+1000) + " euros?");
        }
    }
    
    public Boolean frozen(String d){ //DONE
        
        int actualday = Integer.parseInt(d.substring(0, 2));
        int actualmonth = Integer.parseInt(d.substring(2, 4));
        int actualyear = Integer.parseInt(d.substring(4, 8));
        
        int lastday = Integer.parseInt(deadline.substring(0, 2));
        int lastmonth = Integer.parseInt(deadline.substring(2, 4));
        int lastyear = Integer.parseInt(deadline.substring(4, 8));
        
        if(actualyear == lastyear){
            
            if(actualmonth == lastmonth){
                
                if(actualday <= lastday){
                    
                    return false;
                }
            
            }else if(actualmonth<lastmonth){
                
                return false;
            }
        
        }else if (actualyear<lastyear){
            
            return false;
        }
        
        return true;
    }
    
    public Buyer getBuyer(){ //DONE
        
        return bidder;
    }
    
    public String getDeadline(){ //DONE
        return deadline;
    }
}
