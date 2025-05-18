package data_structures;

import models.ServiceRequest;

public class ServiceLinkedList {

    public Node head;

    public static class Node {
        public ServiceRequest data;
        public Node next;

        public Node(ServiceRequest data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addServiceRequest(ServiceRequest serviceRequest) {
        Node newNode = new Node(serviceRequest);
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

    public void viewAllServiceRequests() {
        if (head == null) {
            System.out.println("No service requests available.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void loadFromList(ServiceLinkedList serviceRequests) {
        Node current = serviceRequests.head;
        while (current != null) {
            addServiceRequest(current.data);
            current = current.next;
        }
    }
}
