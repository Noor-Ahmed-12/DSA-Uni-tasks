public class ArrayCollection extends ArrayAbstract{
    private int size=0;
    private final int initialLength=11;
    private Object[] data = new Object[initialLength];

    @Override
    public Object add(Object obj) {
        if (size == data.length) resize();
        data[size++] = obj;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize() {
        Object[] dd = data;
        dd = new Object[2* data.length];
        System.arraycopy(data,0,dd,0, size);
    }

    @Override
    public Iterator iterator() {
        return new Iterator(){
            private int index=0;
            private boolean OkToRemove= false;

            @Override
            public boolean hasNext() {
                return (index < size);
            }

            @Override
            public Object next() {
                if (size == index) throw new NullPointerException();
                OkToRemove = true;
                return data[index++];
            }

            @Override
            public void remove() {
                if (!OkToRemove) throw new NullPointerException();
                data[ --index] = data[--size];
                data[size] = null;
                OkToRemove = false;
            }
        };
    }

//    frequency
    public void frequency(){
        Object[] temp = new Object[data.length];
        Object visited =-1;

        for (int i = 0; i < data.length ; i++) {
            int count=0;

            for (int j = i+1; j < data.length ; j++) {
                if (data[i] == data[j]){
                    count++;
                    temp[j] = visited;
                }
            }
            if (temp[i] !=visited){
              temp[i] = count;
            }
        }
        System.out.println(" frequency ELements:");
        for(int i=0; i< temp.length; i++){
            if (temp[i] !=visited){
                System.out.print(" " +  data[i] + " : " + temp[i]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        ArrayCollection arr = new ArrayCollection();
        arr.add("Khi");
        arr.add("Hyd");
        arr.add("Mul");
        arr.add("sawat");
        arr.add("Hyd");
        arr.add("Mul");
        arr.add("sawat");

       System.out.println(arr.toString());
        arr.clear();
//        arr.frequency();
        System.out.println(arr.size());
        System.out.println(arr.remove("Mul"));
        System.out.println(arr.contains("mps"));
        Iterator it = arr.iterator();
        if (it.hasNext()) System.out.println(it.next());
    }

}
