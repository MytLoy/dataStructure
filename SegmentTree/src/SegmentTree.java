/**
 * Created by Administrator on 2018/11/22 0022.
 * 线段树（满二叉树）
 */
public class SegmentTree<E> {

    private E[] tree; // 树
    private E[] data;

    public SegmentTree(E[] arr) {
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[])new Object[4 * arr.length]; // 满二叉树
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    // 左孩子
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // 右孩子
    private int rightChild(int index) {
        return 2 * index + 2;
    }
}
