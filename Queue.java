public interface Queue {
    void add(Object ob);
    Object remove(Object ob);
    int size();
    Object first();
}
