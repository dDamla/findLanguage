/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Damla
 */
public class FindLanguageTest {
    
    public FindLanguageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of findLang method, of class FindLanguage.
     */
    @Test
    public void testFindLang() {
        System.out.println("findLang");
        String str = "https://tr.wikipedia.org/wiki/Vikipedi";
        FindLanguage instance = new FindLanguage();
        String expResult = "Türkçe";
        String result = instance.findLang(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
