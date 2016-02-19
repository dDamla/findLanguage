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
public class wordTest {
    
    public wordTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getFrequency method, of class word.
     */
    @Test
    public void testGetFrequency() {
        System.out.println("getFrequency");
        word instance = new word();
        instance.setFrequency();
        int expResult = 1;
        int result = instance.getFrequency();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }



    /**
     * Test of getName method, of class word.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        word instance = new word();
        instance.setName("damla");
        String expResult = "damla";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

   
    
}
