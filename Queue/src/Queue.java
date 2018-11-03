public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e); // 进队
    E dequeue(); // 出队
    E getFront(); // 获取队首元素
}
