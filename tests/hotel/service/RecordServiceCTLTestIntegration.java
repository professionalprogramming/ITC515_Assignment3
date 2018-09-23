package hotel;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hotel.booking.BookingUI.State;
import hotel.entities.Booking;
import hotel.entities.Hotel;
import hotel.service.RecordServiceCTL;
import hotel.service.RecordServiceUI;

public class RecordServiceCTLTestIntegration {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	static Hotel hotel;
	static RecordServiceUI recordServiceUI;
	static Booking booking;
	static int roomNumber = 1234;
	static RecordServiceCTL expected;
	static RecordServiceCTL actual;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hotel = new Hotel();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		expected = null;
	}

	@Before
	public void setUp() throws Exception {
		expected = new RecordServiceCTL(hotel);
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(originalOut);
	}

	@Test
	public final void testRecordServiceCTL() {
		assertTrue(expected instanceof RecordServiceCTL);
	}

	
	@Test
	public final void testRoomNumberEntered() {
		expected.roomNumberEntered(roomNumber);
		String expectedStr = String.format("No active booking for room id: %d", roomNumber);
		String actualStr = outContent.toString();
		actualStr = actualStr.replace("\n", "").replace("\r", "");
		assertEquals(expectedStr, actualStr);
	}

	@Test
	public final void testServiceDetailsEntered() {
		
	}

	@Test
	public final void testCancelOutput() {
		expected.cancel();
		String expectedStr = "Pay for service cancelled";
		String actualStr = outContent.toString();
		actualStr = actualStr.replace("\n", "").replace("\r", "");
		assertEquals(expectedStr, actualStr);
	}
	

	@Test
	public final void testCompleted() {
		expected.completed();
		String expectedStr = "Pay for service completed";
		String actualStr = outContent.toString();
		actualStr = actualStr.replace("\n", "").replace("\r", "");
		assertEquals(expectedStr, actualStr);
	}

}
