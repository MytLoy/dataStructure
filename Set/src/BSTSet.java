/**
 * Created by Administrator on 2018/11/13 0013.
 * 基于二分搜索树实现的集合
 * Comparable:必须是可以比较的
 * implements：实现某个接口
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }
    

    @Override
    public void remove(E e) {
        bst.remove(e);
    }
}
