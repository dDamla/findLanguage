/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GetTextFromWeb {
    
    ObjectControl control = new ObjectControl();
    
    public String GetTextFW(String str)
    {
        String content;
        String control = str.substring(0,8);
        if(control.compareToIgnoreCase("https://") == 0)
        {
        Document doc = null;
        try {
            doc = Jsoup.connect(str).get();
        } catch (IOException ex) {
            Logger.getLogger(GetTextFromWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        String title = doc.title();
        content = doc.select("div#mw-content-text").text();
        }
        else
            content = str;
        
        
        
        return content;
        
    }
    
    public void Parse(ArrayList<word> arr, String str)
    {
        GetTextFromWeb gtfw = new GetTextFromWeb();
        String text = gtfw.GetTextFW(str);
        StringTokenizer t1 = new StringTokenizer(text);
        //ArraySearch find = new ArraySearch();
        
        String[] delChar = {" ",".",",",";","?","!","0","1","2","3","4","5","6","7","8","9",":","(",")","-","[","]","^","|"};
                                   
        while(t1.hasMoreTokens())
          {           
             String parseWord = t1.nextToken();
             
             for(String s : delChar)
             parseWord = parseWord.replace(s, "");//., gibi karakterleri cikardik
             
             String x ="";
             String y = " ";
             if(parseWord.equalsIgnoreCase(x) || parseWord.equalsIgnoreCase(y))continue;             
             control.objectMenager(arr, parseWord);//Flyweight icin
             
              
          }
        
    }
    
    public void putUnderscore(ArrayList<word> arr)
    {//listedeki kelimelerin basina ve sonuna alt tire koyuyor.
        for(word w : arr)
        {
            String x = w.getName(); //kelimeyi aldik
            x = "_" + x + "_";
            w.setName(x);
        }
    }
    
    
    public void make3Gram(ArrayList<word> trigram, String string)          
    {
        //Bu string string de kullanicinin girdigi sey
       
        //withUnderscore listesi alt tire koymak icin yapilmis gecici liste
      
        ArrayList<word> withUnderscore = new ArrayList<word>();
        ArraySearch find = new ArraySearch();
        GetTextFromWeb gtfw = new GetTextFromWeb();
        String str = gtfw.GetTextFW(string);//Metni al
        gtfw.Parse(withUnderscore, str);
        
        
        gtfw.putUnderscore(withUnderscore); //alt tire koy
         
        for(word w : withUnderscore)
        {
             for(int i = 0; i<w.getName().length()-2; i++)
          {
              String x = w.getName().substring(i,i+3);
              
              if(w.getName().isEmpty() == true || find.IsThere(trigram, x) < 0)
              {
                  word newWord = new word();
                  newWord.setName(x);
                  newWord.setFrequency();
                  trigram.add(newWord);
              }
              
              else if(find.IsThere(trigram, x)>0)
              {
                  int index = find.IsThere(trigram, x);
                  trigram.get(index).setFrequency();                  
              }
              
          }
         
        }
        
        
    }
    
    
    
    }
    

