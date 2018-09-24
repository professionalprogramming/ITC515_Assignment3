/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import hotel.entities.Hotel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rehman
 */
public class HotelCheckInTest {
    
    public HotelCheckInTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testHotelCheckIn() {
     System.out.println("checkin");
        long confirmationNumber = 0L;
        Hotel instance = new Hotel();
        instance.checkin(confirmationNumber);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
     }
}
