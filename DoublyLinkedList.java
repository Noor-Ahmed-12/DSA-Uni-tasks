import java.util.Scanner;

public class DoublyLinkedList {

    private class Node{
        private Object data;
        private Node next;
        private Node prev;
        public Node(Object ob){
            data=ob;
        }
        public Node(Object ob,Node n, Node p){
            data=ob;
            next=n;
            prev=p;
        }
    }
    private Node head, temp;
    public void insert(Object val){
        Node newNode = new Node(val);
        if (head==null){
            head= newNode;
            temp= head;
        }
        else{
            temp.next = newNode;
            newNode.prev = temp;
            temp= newNode;
        }
    }
    public void displayList(){
        Node current=head;
        while(current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }

    public void deleteFromBeg() {
        if (head==null) return;
        else{
            Node temp = head;
            head = head.next;
            head.prev=null;
            temp.next=null;
        }
    }

//    public void deleteLast(){
//        if (tail==0) return;
//        else{
//            tail.prev.next = null;
//            tail = tail.prev;
//        }
//    }


    public void reverse(){
        temp=null;
        Node current = head;
        while (current!=null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp !=null){
            head = temp.prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert("samosa");
        list.insert("Fritters");
        list.insert("sandwich");
        list.displayList();
        list.reverse();
        System.out.println("\nReversing the list:");
        list.displayList();

        list.deleteFromBeg();
        list.displayList();
    }
}