/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;


public class ObjectControl {
    
    
    ArraySearch find = new ArraySearch();
   
    
    
    public void objectMenager(ArrayList<word> objects, String str)
    {
        
        if(objects.isEmpty() == true || find.IsThere(objects, str) < 0 )
        {
            word newWord = new word();
            newWord.setName(str);
            newWord.setFrequency();
            objects.add(newWord);            
        }
        
        else if(find.IsThere(objects, str) > 0)
        {
            int index = find.IsThere(objects, str);
            objects.get(index).setFrequency();
        }
    }
    
    
    
   
    
    
    
}
