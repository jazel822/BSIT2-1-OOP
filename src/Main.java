import java.util.Scanner;

class LinkedList {

    Node head;

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }


    // Delete a value
    void delete(int value) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == value) {
            head = head.next;
            System.out.println(value + " deleted.");
            return;
        }

        Node current = head;

        while (current.next != null &&
                current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found.");
        } else {
            current.next = current.next.next;
            System.out.println(value + " deleted.");
        }
    }


    // Display
    void display() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }

    // Count nodes
    void count() {

        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        System.out.println("Number of nodes: " + count);
    }


    public class Main {

        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            LinkedList list = new LinkedList();

            int choice;

            do {
                System.out.print("\n========University Clinic=========== ");
                System.out.print("\n1.add student: ");
                System.out.print("\n2.Remove A student: ");
                System.out.print("\n3.Display Student ");
                System.out.print("\n4.Enter choice: ");

                choice = input.nextInt();

                switch (choice) {


                    case 1:
                        System.out.print("Enter Student to delete: ");
                        int deleteValue = input.nextInt();
                        list.delete(deleteValue);
                        break;

                    case 2:
                        list.display();
                        break;

                    case 3:
                        list.count();
                        break;


                    case 4:
                        System.out.println("Program ended.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } while (choice != 4);

            input.close();
        }
    }
}