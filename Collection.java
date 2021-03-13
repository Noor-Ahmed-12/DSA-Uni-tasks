
public interface Collection {
    Object add(Object obj);
    boolean remove(Object obj);
    boolean contains(Object obj);
    void clear();
    int size();
    boolean isEmpty();
    Iterator iterator();
}
