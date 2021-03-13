public class LinkedQueue implements Queue{
    private int size;
    private Node head = new Node();

    private class Node{
        private Object data;
        private Node next, prev;
        Node(){
            this.next=this.prev=this;
        }
        Node(Object d,Node p, Node n){
            data=d;
            prev=p;
            next=n;
        }
    }

    @Override
    public void add(Object ob) {
        head.prev.next = new Node(ob, head.prev,head);
        head.prev = head.prev.next;
        ++size;
    }

    @Override
    public Object remove(Object ob) {
        if (size==0) throw new NullPointerException();
        Object temp = head.next.data;
        head.next = head.next.next;
        head.next.prev = head;
        --size;
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object first() {
        return head.next.data;
    }
    public void revserse(){
        Node current = head;
        Node temp;
        do {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }while(current!=head);
    }

    public String toString(){
        String str = null;
        for(Node p=head.next; p!=null;p=p.next){
            str+= p.data;
        }
        return "[" + str + "]";
    }

    public ArrayQueue toArrayStack(){
        ArrayQueue st = new ArrayQueue(size);
        Object[] arr = new Object[size];
        int i=0;
        for (Node p=head ; p!=null; p=p.next,i++){
            arr[i] = p.data;
        }
        for (int j = 0; j <size ; j++) {
          st.add(arr[j]);
        }
        return st;
    }

    public void station() {
        if (size==0) throw new NullPointerException();
        String[] data = {"karachi","hyderabad","Tando Adam","Padedan","mahendar pur","rohri","shahdad pur"};
        Object temp = head.next.data;
        for (int i = 0; i <data.length ; i++) {
            if (temp.equals(data[i])) System.out.println( data [i] + " station");
        }
        head.next = head.next.next;
        head.next.prev = head;
    }

    public static void main(String[] args) {
        LinkedQueue lq = new LinkedQueue();
        lq.add("karachi");
        lq.add("hyderabad");
        lq.add("Tando Adam");
        lq.add("Shahda pur");
        lq.add("Padedan");
        lq.add("Mahendar pur");
        lq.add("Rohri");
        lq.station();
        lq.station();
        lq.station();
        lq.station();
        lq.station();
        //lq.revserse();
//        lq.remove("apple");
//        System.out.println(lq.first());
    }
}
