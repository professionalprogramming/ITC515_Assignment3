/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import hotel.entities.Hotel;
import hotel.entities.ServiceType;
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
public class HotelAddServiceChargeTest {
    
    public HotelAddServiceChargeTest() {
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
     public void testAddServiceCharge() {
       System.out.println("addServiceCharge");
        int roomId = 0;
        ServiceType serviceType = null;
        double cost = 0.0;
        Hotel instance = new Hotel();
        instance.addServiceCharge(roomId, serviceType, cost);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
     }
}
