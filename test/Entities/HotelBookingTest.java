/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import hotel.entities.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class HotelBookingTest {
    Hotel hotel;
	Date date;
	int stayLength=3;
	Room room;
	Guest guest;
	CreditCard card;
    public HotelBookingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
   public void setUp() throws Exception {
                hotel = new Hotel();
		hotel.addRoom(RoomType.SINGLE, 101);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		date = format.parse("02-11-2019");
		room = hotel.findAvailableRoom(RoomType.SINGLE, date, stayLength);
        	guest = new Guest("Harry", "kaur", 075673337);
        	card = new CreditCard(CreditCardType.VISA, 2, 123);

    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void testRoomBook() {
	
            System.out.println("roomBook");
		long confirmationNumber = hotel.book(room, guest, date, stayLength, 2, card);

		long expectedConfirmationNumber = 0; //0

		assertEquals(expectedConfirmationNumber, confirmationNumber);

		

		
}
   
}
