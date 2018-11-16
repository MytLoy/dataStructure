/**
 * Created by Administrator on 2018/11/15 0015.
 * 实现集合 - 链表
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return list.contanins(e);
    }

    // 不能添加重复元素
    @Override
    public void add(E e) {
        if (!list.contanins(e)) {
            list.addFirst(e); // 在链表头添加元素为O（1）
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }
}
