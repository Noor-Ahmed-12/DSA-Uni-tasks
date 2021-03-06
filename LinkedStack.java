import javax.print.attribute.standard.NumberUp;
public class LinkedStack implements Stack{
    private int size;
    private Node top;

    LinkedStack(){
        size=0;
    }

    private class Node{
        private Object data;
        private Node next;
        Node(Object d){
            data=d;
        }
        Node(Object d, Node n){
            data=d;
            next=n;
        }
    }

    @Override
    public void push(Object obj) {
        if (top==null){
            Node newNode = new Node(obj,null);
            top = newNode;
        }
        else{
            Node newNode = new Node(obj,top);
            top=newNode;
        }
        ++size;
    }

    @Override
    public Object pop() {
        if(isEmpty()) return null;
        else{
            Object temp= top.data;
            top = top.next;
            return temp;
        }
    }
    @Override
    public Object peek() {
       if (this.isEmpty()) return null;
       return top.data;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }
//    toString()
    public String toString(){
        String str="";
        str+="[";
        for (Node p=top; p!=null; p=p.next){
            str += p.data + ",";
        }
        return str;
    }
//    equal
    public boolean equals(LinkedStack s){
        boolean isEqual=true;
        if (this.size == s.size){
            for (Node p = top, q=s.top; p!=null; p=p.next,q=q.next ){
                if (p.data != q.data){
                    isEqual=false;
                    break;
                }
            }
            return isEqual;
        }
        else{
            return false;
        }
    }
//    findLast
    public Object findLast(){
        while(top!=null){
            top = top.next;
        }
       return top.data;
    }

//    toLinkedStack
    public ArrayStack toArrayStack(){
        ArrayStack s= new ArrayStack();
        Object[] arr = new Object[size];
        int i=0;
        for (Node p=top; p!=null; p=p.next){
            arr[i] = p.data;
            i++;
        }
        for (i=size-1; i>-1; i--){
            s.push(arr[i]);
        }
        return s;
    }

    //bottomELement
    public Object bottomElement(){
        LinkedStack s2 = new LinkedStack();
        if (this.isEmpty()) throw new NullPointerException();
        while(this.isEmpty()){
            s2.push(this.pop());
        }
        return s2.peek();
    }

    public Object RemoveBottomElement(){
        LinkedStack s2 = new LinkedStack();
        if (this.isEmpty()) throw new NullPointerException();
        while(this.isEmpty()){
            s2.push(this.pop());
        }
        return s2.pop();
    }

    public Object RemoveSecondElement(){
        if (this.isEmpty()) throw new NullPointerException();
        this.pop();
        Object temp = this.pop();
        return temp;
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push("apple");
        stack.push("banana");
        stack.push("orange");
        stack.push("grapes");
    }
}
