/**
 * Created by Administrator on 2018/11/29 0029.
 * Quick Union 数组实现树，是有孩子指向父亲的 基于rank的优化
 */
public class UnionFind4 implements UF {
    private int[] parent;
    private int[] rank; // rank[i]表示根节点为i的树的高度（层树）

    public UnionFind4(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i; // 初始指向自己，没有连接
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    // 查看元素p所对应的集合编号O(h),h：树的高度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合并元素p和元素q所属的集合,时间复杂度哦O（h）,h：树的高度
    // 根据两个元素所在树的rank不同判断合并方向
    // 将rank低的集合合并到rank高的集合上
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}
