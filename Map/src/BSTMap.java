/**
 * Created by Administrator on 2018/11/19 0019.
 * 二分搜索树实现map
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // 添加元素(key, value)
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }
    private Node add(Node node, K key, V value) {
        // 1.递归终止条件
        if (node == null) {
            size ++;
            return new Node(key, value);
        }
        // 2.递归
        if ((key.compareTo(node.key) < 0)) { // 左
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0){ // 右
            node.right = add(node.right, key, value);
        } else { // 相等时：用户想要的是修改
            node.value = value;
        }
        return node;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) { // 相等
            return node;
        } else if (key.compareTo(node.key) < 0) { // 指定的数小于参数返回 -1
            return getNode(node.left, key);
        } else { // 指定的数大于参数返回
            return getNode(node.right, key);
        }
    }

    // 查询
    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist");
        }
        node.value = newValue;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node mininum(Node node) {
        if (node.left == null) {
            return node;
        }
        return mininum(node.left);
    }
    // 删除掉以node为根的二分搜索树中的最小节点，返回删除节点后新的二分搜索树
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
    // 删除 - 比较麻烦（删除元素为e的节点）
    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }
    // 递归算法
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return  leftNode;
            }
            // 待删除节点左右子树均不为空的情况

            // 找到吧待删除节点大的最小节点，即待删除及诶单有子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = mininum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }
}
