package data_structures;

import models.Booking;

public class BookingLinkedList {
    public Node head;

    public static class Node {
        public Booking data;
        public Node next;

        public Node(Booking data) {
            this.data = data;
            this.next = null;
        }

        public Booking getBooking() {
            return data;
        }
    }

    public void loadFromList(BookingLinkedList bookings) {
        Node current = bookings.head;
        while (current != null) {
            addBooking(current.data);
            current = current.next;
        }
    }

    // Constructor
    public BookingLinkedList() {
        this.head = null;
    }

    public void addBooking(Booking booking) {
        Node newNode = new Node(booking);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void displayBookings() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getBooking());
            current = current.next;
        }
    }

    public boolean deleteBookingById(int bookingId) {
        if (head == null)
            return false;

        if (head.data.getBookingId() == bookingId) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.getBookingId() == bookingId) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Booking searchBookingById(int bookingId) {
        Node current = head;
        while (current != null) {
            if (current.data.getBookingId() == bookingId) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

}
