/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author Damla
 */
public class FindLanguage {
    
    //Linkleri almasi icin
    
    public ArrayList<String> linksTr = new ArrayList<String>();
    public ArrayList<String> linksEng = new ArrayList<String>();
    public ArrayList<String> linksDe = new ArrayList<String>();
    
      
    //Cok kullanilan kelimeler icin
    public ArrayList<word> oftusedTr = new ArrayList<word>();
    public ArrayList<word> oftusedEng = new ArrayList<word>();
    public ArrayList<word> oftusedDe = new ArrayList<word>();
    
   
    
    //Trigram Listesi icin
    public ArrayList<word> trigramTr = new ArrayList<word>();
    public ArrayList<word> trigramEng = new ArrayList<word>();
    public ArrayList<word> trigramDe = new ArrayList<word>();
    
    //Gerekli islemleri yapabilmek icin
    public GetTextFromWeb gtfw = new GetTextFromWeb();
    
    //Karsilastirma icin jaccard fonksiyonunu kullanmak icin
    public ArraySearch forJaccard = new ArraySearch();
    
    //Sonuclari karsilastirmak icin
    public float resultTr, resultEng, resultDe;
    
    //Kullanicinin girdigi metinden elde edecegimiz listeler icin
    public ArrayList<word> oftusedUser = new ArrayList<word>();
    public ArrayList<word> trigramUser = new ArrayList<word>();
    
     //ilk 50 sini bir listeye koymak icin   
    public ArrayList<word> oftusedTr50 = new ArrayList<word>();
    public ArrayList<word> oftusedEng50 = new ArrayList<word>();
    public ArrayList<word> oftusedDe50 = new ArrayList<word>();
    public ArrayList<word> trigramTr50 = new ArrayList<word>();
    public ArrayList<word> trigramEng50 = new ArrayList<word>();
    public ArrayList<word> trigramDe50 = new ArrayList<word>();
    public ArrayList<word> oftusedUser50 = new ArrayList<word>();
    public ArrayList<word> trigramUser50 = new ArrayList<word>();
    
    
    
    public String findLang(String str)//Turkce, English, Deutch olarak döndürecek.
    {//Burada karsilastirmalari felan yapacak
        //Button sadece bu fonksiyonu cagiracak
        
        //Linkler alindi
        KeepLinks.getObject().LinksofTr(linksTr);
        KeepLinks.getObject().LinksofEng(linksEng);
        KeepLinks.getObject().LinksofDe(linksDe);
        
        //cok kullanilan kelimeler ve trigramlar listesi artik elimizde
        for(String s : linksTr)
        {
            gtfw.Parse(oftusedTr, s);
            gtfw.make3Gram(trigramTr, s);
        }
        
        for(String s : linksEng)
        {
            gtfw.Parse(oftusedEng, s);
            gtfw.make3Gram(trigramEng, s);
        }
        
        for(String s : linksDe)
        {
            gtfw.Parse(oftusedDe, s);
            gtfw.make3Gram(trigramDe, s);
        }
        
        //Kullanicinin metninin listelerini olusturalim
        gtfw.Parse(oftusedUser, str);
        gtfw.make3Gram(trigramUser, str);
        
        //ArrayListleri siraliyalim
        Collections.sort(oftusedTr,word.wnameComparator);
        Collections.sort(oftusedEng,word.wnameComparator);
        Collections.sort(oftusedDe,word.wnameComparator);
        Collections.sort(oftusedUser,word.wnameComparator);
        Collections.sort(trigramTr,word.wnameComparator);
        Collections.sort(trigramEng,word.wnameComparator);
        Collections.sort(trigramDe,word.wnameComparator);
        Collections.sort(trigramUser,word.wnameComparator);
        
        
        //En cok gecen 50 kelime ve trigrami alalim
        
        for(int i = 0 ; i<50; i++)
        {
            oftusedTr50.add(oftusedTr.get(i));
            trigramTr50.add(trigramTr.get(i));
            oftusedEng50.add(oftusedEng.get(i));
            trigramEng50.add(trigramEng.get(i));
            oftusedDe50.add(oftusedDe.get(i));
            trigramDe50.add(trigramDe.get(i));
            oftusedUser50.add(oftusedUser.get(i));
            trigramUser50.add(trigramUser.get(i));
            
        }
        
        
        //Karsilastirmalari yapalim
        resultTr = forJaccard.Jaccard(oftusedUser50, oftusedTr50) + forJaccard.Jaccard(trigramUser50, trigramTr50);
        resultEng = forJaccard.Jaccard(oftusedUser50, oftusedEng50) + forJaccard.Jaccard(trigramUser50, trigramEng50);
        resultDe = forJaccard.Jaccard(oftusedUser50, oftusedDe50) + forJaccard.Jaccard(trigramUser50, trigramDe50);
        
        if(resultTr > resultEng && resultTr > resultDe)
            return "Türkçe";
        else if(resultEng > resultDe && resultEng > resultTr)
            return "English";
        else
            return "Deutch";
       
    }
    
}
