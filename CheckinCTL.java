package hotel.checkin;

import hotel.credit.CreditCard;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Hotel;
import hotel.entities.Room;
import hotel.utils.IOUtils;

public class CheckinCTL {
	
	private enum State {CHECKING, CONFIRMING, CANCELLED, COMPLETED };
	
	private Hotel hotel;
	private CheckinUI checkInUI;
	private State state;
	private Booking booking = null;
	private long confirmationNumber;
	

	public CheckinCTL(Hotel hotel) {
		this.hotel = hotel;
		this.state = State.CHECKING;
		this.checkInUI = new CheckinUI(this);
	}

	
	public void run() {
		IOUtils.trace("BookingCTL: run");
		checkInUI.run();
	}

	
	public void confirmationNumberEntered(long confirmationNumber) {
		if (state != State.CHECKING) {
			String mesg = String.format("CheckInCTL: confirmationNumberEntered : bad state : %s", state);
			throw new RuntimeException(mesg);
		}
		this.confirmationNumber = confirmationNumber;
		booking = hotel.findBookingByConfirmationNumber(confirmationNumber);
		
		String message = null;
		if (booking == null) {
			message = String.format("No booking for confirmation number %d found", confirmationNumber);
			checkInUI.displayMessage(message);	
			//cancel();
		}
		else if (!booking.isPending()){
			if (booking.isCheckedIn()) {
				message = String.format("Booking %d has already been checked in", confirmationNumber);
			}
			else {
				message = String.format("Booking %d has already been checked out", confirmationNumber);
			}
			checkInUI.displayMessage(message);	
			//cancel();
		}
		else {
			Room room = booking.getRoom();
			if (!room.isReady()) {
				checkInUI.displayMessage("Room is not ready, sorry");
				//cancel();
			}
			else {
				Guest guest = booking.getGuest();
				CreditCard card = booking.getCreditCard();
				
				checkInUI.displayCheckinMessage(
						room.getDescription(), room.getId(),
						booking.getArrivalDate(), booking.getStayLength(), 
						guest.getName(),
						card.getVendor(), card.getNumber(),
						booking.getConfirmationNumber());	
				
				state = State.CONFIRMING;
				checkInUI.setState(CheckinUI.State.CONFIRMING);
			}
		}
	}

	// Done by SAI
	public void checkInConfirmed(boolean confirmed) {
		
		if (state != State.CONFIRMING) {
			String mesg = String.format("CheckInCTL: Not Confirmed Check again", state);
			throw new RuntimeException(mesg);
		}
		if(confirmed){
			hotel.checkin(confirmationNumber);
			checkInUI.displayMessage("Checking in confirmed");
			state = State.COMPLETED;
			checkInUI.setState(CheckinUI.State.COMPLETED);
		}else{
			checkInUI.displayMessage("Checking in cancelled");
			state = State.CANCELLED;
			checkInUI.setState(CheckinUI.State.CANCELLED);
		}
		
	}//Done by SAI


	public void cancel() {
		checkInUI.displayMessage("Checking in cancelled");
		state = State.CANCELLED;
		checkInUI.setState(CheckinUI.State.CANCELLED);
	}
	
	
	public void completed() {
		checkInUI.displayMessage("Checking in completed");
	}

}
