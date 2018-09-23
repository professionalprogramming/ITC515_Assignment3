package hotel;
import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Room;
import hotel.entities.RoomType;
import hotel.entities.ServiceCharge;
import hotel.entities.ServiceType;

public class BookingUnitTesting {
	static Booking bookingTest;
	static Guest guest;
	static Room room;
	static Date bookedArrival; 
	static int stayLength;
	static int numberOfOccupants;
	static long confirmationNumber;
	static CreditCard testCreditCard;
	static CreditCardType type;
	static int creditcardNumber = 555555555;
	static int ccv;
	static int roomId;
	static List <ServiceCharge> actualCharge;
	
	
	@BeforeClass
	public static void beforeClass() {
		bookedArrival = new Date(); 
		stayLength = 10;
		numberOfOccupants=2;
		roomId = 1234;
		type = type.VISA;
		ccv = 786;
		testCreditCard = new CreditCard(type, creditcardNumber, ccv);
		guest = new Guest("Adrian", "Melburn", 123456);
		room = new Room(roomId, RoomType.SINGLE);
		
		//charges = List.add(new ServiceCharge(ServiceType.ROOM_SERVICE, 45.6));
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		
	}
	
	@Before
	public void setUp(){
		bookingTest = new Booking (guest, room, bookedArrival, stayLength, numberOfOccupants, testCreditCard);
	}
	
	@After
	public void tearDown(){
		bookingTest = null;
	}
		

	@Test
	public void testBooking() {
		assertTrue(bookingTest instanceof Booking);
	}
	
	@Test
	public void testGetConfirmationNumber(){
		long Actual = bookingTest.generateConfirmationNumber(roomId, bookedArrival);
		assertEquals(bookingTest.getConfirmationNumber(), Actual);
	}
	
	@Test
	public void testGetRoomID(){
		assertEquals(bookingTest.getRoomId(), roomId);
	}
	
	@Test
	public void testGetRoom(){
		assertEquals(bookingTest.getRoom(), room);
	}
	
	@Test
	public void testGetArrivalDate(){
		assertEquals(bookingTest.getArrivalDate(), bookedArrival);
	}
	
	@Test
	public void testGetStayLength(){
		assertEquals(bookingTest.getStayLength(), stayLength);
	}
	
	@Test
	public void testGetGuest(){
		assertEquals(bookingTest.getGuest(), guest);
	}
	
	@Test
	public void testGetCreditCard(){
		assertEquals(bookingTest.getCreditCard(), testCreditCard);
	}
	
	@Test
	public void testIsPending(){
		assertTrue(bookingTest.isPending());
	}
	
	@Test
	public void testIsCheckedIn(){
		assertFalse(bookingTest.isCheckedIn());
	}
	
	@Test
	public void testIsCheckedOut(){
		assertFalse(bookingTest.isCheckedOut());
	}
	
	@Test(expected = RuntimeException.class)
	public void testCheckIn(){
		bookingTest.checkIn();
		assertTrue(bookingTest.isPending());
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddServiceCharge(){
		ServiceCharge actualServiceCharge = new ServiceCharge(ServiceType.ROOM_SERVICE, 45.6);
		actualCharge.add(actualServiceCharge);
		bookingTest.addServiceCharge(ServiceType.ROOM_SERVICE, 45.6);
		assertEquals(bookingTest.getCharges().get(0), actualCharge.get(0));
	}
	
	@Test(expected = RuntimeException.class)
	public void testCheckOut(){
		bookingTest.checkOut(bookingTest);
		assertTrue(bookingTest.isCheckedOut());
	}
	

}
