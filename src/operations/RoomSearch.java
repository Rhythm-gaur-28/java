


package operations;

import data_structures.RoomLinkedList;
import models.Room;

public class RoomSearch {
    // Search for a room by room number
    public static Room searchByRoomNumber(RoomLinkedList roomList, int roomNumber) {
        RoomLinkedList.Node current = roomList.head;
        while (current != null) {
            if (current.data.getRoomNumber() == roomNumber) {
                return current.data;  
            }
            current = current.next;
        }
        return null;  
    }

    // Search for a room by room type
    public static Room searchByRoomType(RoomLinkedList roomList, String roomType) {
        RoomLinkedList.Node current = roomList.head;
        while (current != null) {
            if (current.data.getRoomType().equalsIgnoreCase(roomType)) {
                return current.data; 
            }
            current = current.next;
        }
        return null;  
    }
}
