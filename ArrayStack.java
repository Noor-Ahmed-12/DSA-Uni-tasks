public class ArrayStack implements Stack{

    private Object[] data;
    private int size;

    ArrayStack(int capacity){
        size=-1;
        data = new Object[capacity];
    }

    public ArrayStack() {

    }

    @Override
    public void push(Object obj) {
        if (size== data.length) resize();
        data[++size] = obj;
    }

    private void resize() {
        Object[] newData =data;
        newData = new Object[2* data.length];
        System.arraycopy(data,0,newData,0,size);

    }

    @Override
    public Object pop() {
        if (isEmpty()) throw new NullPointerException();
        else{
            Object temp = data[size--];
            data[size] = null;
            return temp;
        }
    }

    @Override
    public Object peek() {
        if(size==0) throw new NullPointerException();
        return data[size-1];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    public void display(){
        for (int i = 0; i < data.length-1 ; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.println();
    }

//    toString
    public String toString(){
        String str ="[";
        for (int i=size ; i>-1; i--) {
            str += data[i] + ",";
        }
        str +="]";
        return str;
    }
//equals
    public boolean equals(ArrayStack s){
        boolean isEqual=true;
        if (this.size == s.size){
          for (int i=size; i>-1; i--){
              if (this.data[i] != s.data[i]){
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

   //linkedStack
    public LinkedStack toLinkedList(){
        LinkedStack s = new LinkedStack();
        for (int i = 0; i <size+1 ; i++) {
            s.push(data[i]);
        }
        return s;
    }
   //findlast
   public Object findLast(){
        if (isEmpty()) return -1;
        return data[0];
   }

    public Object RemoveLast(){
        if (isEmpty()) return -1;
        return data[0]=null;
    }
    public Object secondElement(){
        if (isEmpty()) return -1;
        return data[size-2];
    }

    public Object RemoveSecondElement(){
        if (isEmpty()) return -1;
        return data[size-2]=null;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push("apple");
        stack.push("banana");
        stack.push("orange");
        stack.push("grapes");

        ArrayStack stack2 = new ArrayStack(5);
        stack2.push("apple");
        stack2.push("banana");
        stack2.push("orange");
        stack2.push("grapes");

//        stack.display();
        System.out.println(stack.toString());
        System.out.println(stack.equals(stack2));

        stack.RemoveSecondElement();
        System.out.println(stack.toString());
    }
}
