/**
 * Created by Administrator on 2018/11/19 0019.
 * 最大堆,必须有可比较性
 * 堆中某个节点的值总是不大于其父子节点的值
 * index从0开始
 * 最大堆实现优先队列
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    // 返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    // 返回一个布尔值，表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 dosen't have parent");
        }
        return (index - 1) / 2;
    }

    // 左孩子的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 右孩子的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // 向堆中添加元素
    // 找到位置，
    // 如果大于其父亲节点-》调整适合堆的性质-》找到父亲节点进行更换
    public void add(E e) {
        data.addLast(e);
        // 维护堆的性质
        siftUp(data.getSize() - 1);
    }
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) { // 与父亲节点进行比较
            data.swap(k, parent(k)); // 把k与其父亲节点更换
            k = parent(k);
        }
    }

    // 向堆中取出元素
    // 只能取出最大元素（优先队列）- 堆顶
    // 删除堆顶元素 - 》将最后一个元素放到堆顶 -》与两个子节点进行比较
    // -》与两个孩子中最大的元素交换位置
}
