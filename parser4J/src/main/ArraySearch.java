/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;

public class ArraySearch {
    public int IsThere(ArrayList<word> a, String value) //Listede kelime var mı
    {
        for(word w : a)
        {
            if(w.getName().equalsIgnoreCase(value))
            {
                int index = a.indexOf(w);
                return index ;
            }
        }
        return -1;
    }
    
    public float Jaccard(ArrayList<word> list1, ArrayList<word> list2)
    {//list1 kullanicinin, list2 cektigimiz metinlerin
        int intersection = 0;
        int union = 0;
        float jaccard;
        
        for(word w1 : list1)
        {
            for(word w2 : list2)
            {
                if(w1.getName().equalsIgnoreCase(w2.getName()))
                    intersection++;
            }      
            union += w1.getFrequency();
        }
        
                    
        for(word w : list2)
            union += w.getFrequency();
       
        union = union - intersection;
       
        jaccard = (float) intersection/union;
        
        return jaccard;
    }
    
    
            
}
