/**
 * Created by Administrator on 2018/11/29 0029.
 * 并查集 UnionFind
 * 不考虑添加和删除
 */
public interface UF {
    int getSize();
    boolean isConnected(int p, int q); // 两个元素是否相连
    void unionElements(int p, int q);
}
