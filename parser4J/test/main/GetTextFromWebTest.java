/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Damla
 */
public class GetTextFromWebTest {
    
    public GetTextFromWebTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of GetTextFW method, of class GetTextFromWeb.
     */
    @Test
    public void testGetTextFW() {
        System.out.println("GetTextFW");
        String str = "Damla Damla Damla Damla Damla Damla Damla Damla Damla Damla Damla Damla Damla Damla Damla Damla";
        GetTextFromWeb instance = new GetTextFromWeb();
        String expResult = "Damla Damla Damla Damla Damla Damla Damla Damla Damla Damla Damla Damla Damla Damla Damla Damla";
        String result = instance.GetTextFW(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }




   
    
}
