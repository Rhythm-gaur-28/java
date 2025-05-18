package operations;

import data_structures.BookingLinkedList;
import models.Booking;

public class BookingSearch {

    // Method to search for a booking by Email
    public static Booking searchByBookingEmail(BookingLinkedList bookingList, String email) {
        BookingLinkedList.Node current = bookingList.head;  

        // Traverse the linked list
        while (current != null) {
            if (current.getBooking().getEmail().equalsIgnoreCase(email)) {
                return current.getBooking();  
            }
            current = current.next; 
        }
        return null;
    }
}
