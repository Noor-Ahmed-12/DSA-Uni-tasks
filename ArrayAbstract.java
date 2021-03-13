public abstract class ArrayAbstract implements Collection{
    ArrayAbstract(){}

    @Override
    public Object add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean contains(Object obj) {
        if (obj==null) throw new NullPointerException();
        Iterator it = iterator();
        while (it.hasNext()){
            if (obj.equals(it.next())) return true;
        }
        return false;
    }

    @Override
    public abstract int size();

    public abstract Iterator iterator();

    @Override
    public boolean remove(Object obj) {
        Iterator it = iterator();
        if (obj==null)
            while(it.hasNext()){
                if (it.next()==null) {
                    it.remove();
                    return true;
                }
            }
        else
            while(it.hasNext()){
                if (obj.equals(it.next())){
                    it.remove();
                    return true;
                }
            }
            return false;
    }

    @Override
    public void clear() {
        for(Iterator it = iterator(); it.hasNext();){
            it.next();
               it.remove();
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        Iterator it = iterator();
        StringBuilder buff = new StringBuilder("[" + it.hasNext());
        while(it.hasNext())
            buff.append(" ,").append(it.next());
        return (buff + "]");
    }
}
