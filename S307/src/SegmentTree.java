/**
 * Created by Administrator on 2018/11/22 0022.
 * 线段树（满二叉树）
 */
public class SegmentTree<E> {

    private E[] tree; // 树
    private E[] data;
    private Merger<E> merger; // 融合器

    public SegmentTree(E[] arr, Merger<E> merger) {

        this.merger = merger;

        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[])new Object[4 * arr.length]; // 满二叉树
        buildSegmentTree(0, 0, data.length - 1);
    }

    // 在treeIndex的位置创建表示区间[l, r]的线段树
    // l,r：左右边界
    private void buildSegmentTree(int treeIndex, int l, int r) {
        // 递归结束条件,区间为1
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        // 左右子树
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

//        int mid = (l + r) / 2; // 有可能出现溢出
        int mid = l + (r - l) / 2; // 中间位置

        buildSegmentTree(leftTreeIndex, l, mid); // 左子树的区间
        buildSegmentTree(rightTreeIndex, mid + 1, r); // 右子树的区间

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]); // 融合

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

    // 查询 返回[queryL, queryR]的值
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL > data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Index id illegal.");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    // 在以treeID为根的线段树种[l...r]的范围里，搜索区间[queryL...queryR]的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        int mid = l + (r - l) /2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryL >= mid + 1) { // 全部落在右子树的区间
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) { // 全部落在左子树的区间
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }

        // 一部分在左子树区间，一部分在右子树区间
        E leftResult = query(leftTreeIndex, l , mid, queryL, mid);
        E rigthResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);

        // 融合
        return merger.merge(leftResult, rigthResult);
    }

    // 将index位置的值，更新为e
    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }

        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    // 在以treeIndex为根的线段树中更新index的值为e
    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index >= mid + 1) {
            set(rightTreeIndex, mid + 1, r, index, e);
        } else {
            set(leftTreeIndex, l, mid, index, e);
        }

        // 更新index位置后其关联的祖辈节点会受到影响
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0 ; i < tree.length ; i ++){
            if(tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if(i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
