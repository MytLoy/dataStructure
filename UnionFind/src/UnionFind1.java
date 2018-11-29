/**
 * Created by Administrator on 2018/11/29 0029.
 * Quick Find
 */
public class UnionFind1 implements UF {
    private int[] id; // 数据集合的编号

    public UnionFind1(int size) {
        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    // 时间复杂度O(1)
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        return id[p];
    }

    // 查看元素p所对应的集合编号
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合并元素p和元素q所属的集合,时间复杂度哦O（n）
    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}
