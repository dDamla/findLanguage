/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
//Bu sinif her dil icin ayri method olustursun burada linkleri tutsun burdan link listler alinsin

import java.util.ArrayList;

public class KeepLinks {
    
    private static KeepLinks links = new KeepLinks();
    private KeepLinks()
    {}
    
    public static KeepLinks getObject()
    {
        return links;
    }
    
    public void LinksofTr(ArrayList<String> list)
    {
        list.add("https://tr.wikipedia.org/wiki/Balkanlar");
        list.add("https://tr.wikipedia.org/wiki/T%C3%BCrk%C3%A7e");
        list.add("https://tr.wikipedia.org/wiki/T%C3%BCrkiye");
        list.add("https://tr.wikipedia.org/wiki/Anadolu");
        list.add("https://tr.wikipedia.org/wiki/Avrupa");
        list.add("https://tr.wikipedia.org/wiki/Kad%C4%B1n");
        list.add("https://tr.wikipedia.org/wiki/Cumhuriyet");
        list.add("https://tr.wikipedia.org/wiki/Mustafa_Kemal_Atat%C3%BCrk");
        list.add("https://tr.wikipedia.org/wiki/Ay");
        list.add("https://tr.wikipedia.org/wiki/Evren");
    }
    
    public void LinksofEng(ArrayList<String> list)
    {
        list.add("https://en.wikipedia.org/wiki/Old_English");
        list.add("https://en.wikipedia.org/wiki/English_language");
        list.add("https://en.wikipedia.org/wiki/Great_Britain");
        list.add("https://en.wikipedia.org/wiki/Europe");
        list.add("https://en.wikipedia.org/wiki/Istanbul");
        list.add("https://en.wikipedia.org/wiki/United_Kingdom");
        list.add("https://en.wikipedia.org/wiki/Woman");
        list.add("https://en.wikipedia.org/wiki/Republic");
        list.add("https://en.wikipedia.org/wiki/Moon");
        list.add("https://en.wikipedia.org/wiki/Universe");
    }
    
    public void LinksofDe(ArrayList<String> list)
    {
        list.add("https://de.wikipedia.org/wiki/Liechtenstein");
        list.add("https://de.wikipedia.org/wiki/Deutsche_Sprache");
        list.add("https://de.wikipedia.org/wiki/Deutschland");
        list.add("https://de.wikipedia.org/wiki/Geographie");
        list.add("https://de.wikipedia.org/wiki/Europa");
        list.add("https://de.wikipedia.org/wiki/Kunst");
        list.add("https://de.wikipedia.org/wiki/Republik");
        list.add("https://de.wikipedia.org/wiki/Kultur");
        list.add("https://de.wikipedia.org/wiki/Mond");
        list.add("https://de.wikipedia.org/wiki/Universum");
    }
    
}
