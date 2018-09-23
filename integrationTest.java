
import hotel.credit.CreditCardType;
import java.util.Date;

public class integrationTest {

    public static void main(String[] args) {
        
        //creating rooms
        hotel.entities.Room room1=new hotel.entities.Room(1, hotel.entities.RoomType.SINGLE);
        hotel.entities.Room room2=new hotel.entities.Room(2, hotel.entities.RoomType.DOUBLE);
        hotel.entities.Room room3=new hotel.entities.Room(3, hotel.entities.RoomType.TWIN_SHARE);
        
        //displaying room details
        System.out.println(room1.toString());
        System.out.println(room2.toString());
        System.out.println(room3.toString());
        
        //guest 1 details
        hotel.entities.Guest guest1=new hotel.entities.Guest("Albert","Williams Road,Melbourne",618458755);
        //credit card details
        hotel.credit.CreditCard card1=new hotel.credit.CreditCard(CreditCardType.MASTERCARD,2451361,212);
        
        //setting the date of booking 1
        Date date1=new Date(2018,05,01);
        int year1=date1.getYear()-1900;
        int month1=date1.getMonth()-1;
        int day1=date1.getDate();
        //booking 1
        hotel.entities.Booking b1 = new hotel.entities.Booking(guest1,room1,new Date(year1,month1,day1),5,2,card1);
        
        //guest 2 details
        hotel.entities.Guest guest2=new hotel.entities.Guest("Peter","George Avenue Road,Perth",619874563);
        //credit card details
        hotel.credit.CreditCard card2=new hotel.credit.CreditCard(CreditCardType.VISA,7451200,123);
        
        //setting the date of booking b
        Date date2=new Date(2018,8,06);
        int year2=date2.getYear()-1900;
        int month2=date2.getMonth()-1;
        int day2=date2.getDate();
        //booking2
        hotel.entities.Booking b2 = new hotel.entities.Booking(guest2,room2,new Date(year2,month2,day2),3,2,card2);
        
        //adding rooms to hotel
        hotel.entities.Hotel htl=new hotel.entities.Hotel();
        htl.addRoom(hotel.entities.RoomType.SINGLE, 101);
        htl.addRoom(hotel.entities.RoomType.DOUBLE, 102);
        htl.addRoom(hotel.entities.RoomType.TWIN_SHARE, 103);
        //confirmation number of booking 1 is 1420181
        htl.bookingsByConfirmationNumber.put(b1.getConfirmationNumber(), b1);
        
        //confirmation number of booking 2 is 6720182
        htl.bookingsByConfirmationNumber.put(b2.getConfirmationNumber(), b2);
        
        //calling the run method of checkinCTL class
        new hotel.checkin.CheckinCTL(htl).run();
    }
    
}
