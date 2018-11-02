/**
 * Created by Administrator on 2018/11/2 0002.
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
