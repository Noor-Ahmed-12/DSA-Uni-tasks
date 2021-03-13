public class ArrayQueue implements Queue{
    private Object[] data;
    private int size=0;
    ArrayQueue(int cap){
        data = new Object[cap];
    }

    @Override
    public void add(Object ob) {
        if (size == data.length) resize();
        data[size++] = ob;
    }

    public void resize(){
        Object[] dd = data;
        dd = new Object[2* data.length];
        System.arraycopy(data,0,dd,0,size);
    }

    @Override
    public Object remove(Object ob) {
        if (size != 0) {
            --size;
            Object temp = data[0];
            System.arraycopy(data, 1, data, 0, size);
            return temp;
        }
        throw new NullPointerException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object first() {
        if (size==0) throw new NullPointerException();
        return data[0];
    }
    public String toString(){
        String str ="";
        str +="[";
        for (int i = 0; i <size; i++) {
            str+=data[i] + ",";
        }
        return str;
    }

//    reverse
    public void reverse(){
        if (size==0) throw new NullPointerException();
        else{
            for (int i = size-1; i >=0 ; i--) {
                System.out.print(data[i] + ",");
            }
            System.out.println();
        }

    }
//equals
    public boolean equals(ArrayQueue q){
       boolean isEqual=true;
        if (this.size == q.size){
            for (int i = 0; i < data.length ; i++) {
                if (this.data[i] == q.data[i]) return isEqual;
            }
            return isEqual;
       }
       else{
           return false;
       }
    }

    public LinkedQueue toLinkedQueue(){
        LinkedQueue lq = new LinkedQueue();
        for (int i = 0; i < data.length ; i++) {
            lq.add(data[i]);
        }
        return lq;
    }

    public ArrayQueue clone(ArrayQueue aq){
        ArrayQueue arrQ = new ArrayQueue(aq.size);
        for (int i = 0; i <aq.size() ; i++) {
            arrQ.add(data[i]);
        }
        return arrQ;
    }

    public Object removeBottom(ArrayQueue aq){
        Object temp =  data[size-1];
        data[size] =null;
        return temp;
    }

    public ArrayStack toStack(ArrayQueue aq){
     ArrayStack st = new ArrayStack();
        for (int i = 0; i <aq.size() ; i++) {
            st.push(data[i]);
        }
        return st;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        queue.add("samosa");
        queue.add("fritters");
        queue.add("sandwich");
        System.out.println(queue.first());
        queue.toString();
        queue.reverse();
    }
}