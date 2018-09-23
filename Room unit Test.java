
package hotel.entities;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoomTest {
    
    Room instance = new Room(1, RoomType.SINGLE);
    public RoomTest() {
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

    /**
     * Test of toString method, of class Room.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Room : 1, SINGLE";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Room.done
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Room.done
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        String expResult = "Single room";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class Room.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        RoomType expResult = RoomType.SINGLE;
        RoomType result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAvailable method, of class Room.done
     */
    @Test
    public void testIsAvailable() {
        System.out.println("isAvailable");
        Date arrivalDate = new Date(2018,05,01);
        int stayLength = 3;
        
        Guest guest=new Guest("Albert","Williams Road,Melbourne",618458755);
        Room room=new Room(1,RoomType.DOUBLE);
        hotel.credit.CreditCard card=new hotel.credit.CreditCard(CreditCardType.MASTERCARD,2451361,212);
        Booking b2 = new Booking(guest,room,new Date(2018,05,01),5,2,card);
        
        instance.bookings.add(b2);
        boolean expResult = false;
        boolean result = instance.isAvailable(arrivalDate, stayLength);
        assertEquals(expResult, result);
    }

    /**
     * Test of isReady method, of class Room.
     */
    @Test
    public void testIsReady() {
        System.out.println("isReady");
        boolean expResult = true;
        boolean result = instance.isReady();
        assertEquals(expResult, result);
    }

    /**
     * Test of book method, of class Room.
     */
    @Test
    public void testBook() {
        System.out.println("book");
        Guest guest = null;
        Date arrivalDate = null;
        int stayLength = 0;
        int numberOfOccupants = 0;
        CreditCard creditCard = null;
        Booking expResult = null;
        Booking result = instance.book(guest, arrivalDate, stayLength, numberOfOccupants, creditCard);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkin method, of class Room.
     */
    @Test
    public void testCheckin() {
        System.out.println("checkin");
        instance.checkin();
    }

    /**
     * Test of checkout method, of class Room.
     */
    @Test
    public void testCheckout() {
        System.out.println("checkout");
        Booking booking = null;
        instance.checkout(booking);
    }
    
}
