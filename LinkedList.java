public class LinkedList {
    private Node start;
    private int size=0;
    private static class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data=data;
        }
        public Node(int data, Node n){
            this.data=data;
            next=n;
        }
    }

    public Node insert(int value){
        Node p=start;
        if(start==null || start.data > value) {
            start = new Node(value, start);
            return start;
        }
        while (p.next!=null){
            if (p.next.data > value) break;
            p=p.next;
        }
        p.next = new Node(value,p.next);
        ++size;
        return start;
    }

    public int size(){
        return size;
    }

    public Node delete(int value){
        if (start == null || start.data > value) return start;

        if (start.data == value){
            start= start.next;
            return start;
        }
        for (Node p=start; p.next!=null; p=p.next){
            if (p.next.data > value) break;
             else if (p.next.data==value){
                p.next = p.next.next;
                break;
            }
        }
        return start;
    }

    public void printList(){
       for (Node p=start; p!=null; p=p.next){
           System.out.print(p.data + ",");
        }
       System.out.println();
    }

    public Object search(int target){
        if (start == null || start.data > target) return "not found";

        if (start.data == target){
            return start;
        }
        for (Node p=start; p!=null; p=p.next){
            if (p.next.data > target) break;
            else if (p.next.data==target){
                return "Found";
            }
        }
        return "not found";
    }

    public int sum(){
        int add=0;
        for (Node p=start; p!=null; p=p.next){
            add += p.data;
        }
        return add;
    }

    public Node deleteLast(){
        if (start == null || start.next==null) throw new IllegalStateException();
        while (start.next.next!=null){
         start = start.next;
        }
        return start.next=null;
    }
    public static Node copy(Node OldList){
        if (OldList == null)  return null;
        Node clone = new Node(OldList.data);
        for (Node p = OldList, q=clone; p.next!=null; p=p.next,q=q.next ){
            q.next = new Node(p.next.data);
        }
        return clone;
    }

//    size
    public int size(Node list){
        int count=0;
        while(list!=null){
            count++;
            list=list.next;
        }
        return count;
    }
//    sublist
    public Node subList(int a, int b){

        if (a==0 && b==0 || a==b) return this.start;
        int start=a;
        int end=b;
        for (Node p =this.start; p!=null;p=p.next){
         if (p.data==start) {
             this.start=null;
             this.start=p;
         }
         else if (p.data==end){
             p.next=null;
             break;
         }
        }
        return this.start;
    }
//    append
    public Node append(Node list1, Node list2){
        if (list1==null) throw new IllegalStateException();
        while(list1.next!=null){
            list1=list1.next;
        }
        return list1.next =list2;
    }

//    concat
    public Node concat(Node list1,Node list2){
        if (list1==null) throw new IllegalStateException();
        Node list3 = new Node(list1.data);
        for (Node p=list1,q=list3; p!=null; p=p.next,q=q.next){
            q.next = new Node(p.data);
        }
        for (Node p=list2,q=list3; p!=null; p=p.next,q=q.next){
            q.next = new Node(p.data);
        }
        return list3.next;
    }
//    swap
    public Node swap(Node list, int value1,int value2){
        if (value1==0 || value1==value2) throw new IllegalStateException();
        Node p=list;
        Node q=list;
           //iterating till value1
        for (int i = 0; i <value1 ; i++) {
            if (p==null) throw new IllegalStateException();
            p=p.next;
        }
        //iterating till value12
        for (int j = 0; j <value2 ; j++) {
            if (q==null) throw new IllegalStateException();
            q=q.next;
        }
        //getting the data of both values after iteration
        int pData = p.data;
        int qData=q.data;
        //swapping
        q.data=pData;
        p.data=qData;
        return list;
    }
//    merge
    public Node merge(Node list1,Node list2){
        if (list1==null) throw new IllegalStateException();
        Node list3 = new Node(0);
        Node p = list1 , q=list2;
        while (p!=null && q!=null){
            if (p.data < q.data){
                list3 = list3.next = new Node(p.data);
                p=p.next;
            }
            else{
                list3=list3.next = new Node(q.data);
                q=q.next;
                }
            }
        while(p!=null){
            list3 = list3.next = new Node(p.data);
            p=p.next;
        }
        while(q!=null){
            list3 = list3.next = new Node(q.data);
            q=q.next;
        }
        return list3.next;
        }

        public void reverse(LinkedList list){
          if (list==null) throw new IllegalStateException();
          Node prev=null;
          Node currentNode=list.start;
          Node nextNode=currentNode;
          while(currentNode!=null){
              nextNode = nextNode.next;
              currentNode.next=prev;
              prev = currentNode;
              currentNode = nextNode;
          }
          start = prev;
        }



    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

//        list.printList();
//        list.delete(10);
//        list.printList();
//        System.out.println(list.search(40));
//
//
//        System.out.println(list.size());
//        System.out.println(list.sum());
//
//        System.out.println(list.deleteLast());
//        list.printList();
        list.reverse(list);
        list.printList();
    }
}