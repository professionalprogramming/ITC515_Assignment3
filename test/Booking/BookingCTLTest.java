/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Booking;

import hotel.booking.BookingCTL;
import hotel.booking.BookingCTL.State;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import hotel.credit.CreditCardType;
import hotel.entities.Hotel;
/**
 *
 * @author rehman
 */
public class BookingCTLTest {
    
    Hotel hotel=new Hotel();
    BookingCTL bookingCTL=new BookingCTL(hotel);
    public BookingCTLTest() {
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

     @Test
     public void testCreditDetailsEntered() {
    
      System.out.println("creditDetailsEntered");
      BookingCTL controlBooking = new BookingCTL(new Hotel());
      controlBooking.creditDetailsEntered(CreditCardType.MASTERCARD, 35454333, 235);
     }
}
