package data_structures;

import models.Room;

public class RoomLinkedList {
    public Node head;

    public static class Node {
        public Room data;
        public Node next;

        public Node(Room data) {
            this.data = data;
            this.next = null;
        }

    }

    public void loadFromList(RoomLinkedList rooms) {
        Node current = rooms.head;
        while (current != null) {
            addRoom(current.data);
            current = current.next;
        }
    }

    public void addRoom(Room room) {
        Node newNode = new Node(room);
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

    public void displayRooms() {
        if (head == null) {
            System.out.println("No rooms available.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public boolean updateRoom(int roomNumber, Room updatedRoom) {
        Node current = head;
        while (current != null) {
            if (current.data.getRoomNumber() == roomNumber) {
                current.data = updatedRoom;
                System.out.println("Room updated: " + updatedRoom);
                return true;
            }
            current = current.next;
        }
        System.out.println("Room with number " + roomNumber + " not found.");
        return false;
    }

    public boolean deleteRoomByNumber(int roomNumber) {
        if (head == null)
            return false;

        if (head.data.getRoomNumber() == roomNumber) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.getRoomNumber() == roomNumber) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

}
