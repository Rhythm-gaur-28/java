package operations;

import data_structures.BookingLinkedList;
import models.Booking;

public class BookingSort {
    // Sort bookings by check-in date using Bubble Sort
    public static void sortBookingsByCheckInDate(BookingLinkedList bookingList) {
    if (bookingList.head == null) return;

    boolean swapped;
    do {
        swapped = false;
        BookingLinkedList.Node current = bookingList.head;
        while (current != null && current.next != null) {
            String currentDate = current.data.getCheckInDate();
            String nextDate = current.next.data.getCheckInDate();

            if (isDateAfter(currentDate, nextDate)) {
                // Swap the bookings
                Booking temp = current.data;
                current.data = current.next.data;
                current.next.data = temp;
                swapped = true;
            }
            current = current.next;
        }
    } while (swapped);
}


// Convert dd-MM-yyyy to integers and compare as proper dates
private static boolean isDateAfter(String date1, String date2) {
    String[] parts1 = date1.split("-");
    String[] parts2 = date2.split("-");

    int day1 = Integer.parseInt(parts1[0]);
    int month1 = Integer.parseInt(parts1[1]);
    int year1 = Integer.parseInt(parts1[2]);

    int day2 = Integer.parseInt(parts2[0]);
    int month2 = Integer.parseInt(parts2[1]);
    int year2 = Integer.parseInt(parts2[2]);

    // Compare by year, then month, then day
    if (year1 != year2) return year1 > year2;
    if (month1 != month2) return month1 > month2;
    return day1 > day2;
}

}
