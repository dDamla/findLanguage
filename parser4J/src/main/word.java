/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Comparator;

/**
 *
 * @author Damla
 */
public class word {
    private String name;
    private int frequency = 0;

    
    public int getFrequency()
    {
        return frequency;
    }
    public void setFrequency()
    {
        frequency++;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public static Comparator<word> wnameComparator=new Comparator<word>() {
    //Diziyi siralamak icin
        
        
        @Override
        public int compare(word w1,word w2){
        int tekrar=w1.getFrequency();
        int tekrar2=w2.getFrequency();
        
        return tekrar2-tekrar;
    }
    };
    
}
