/**
 * Created by Administrator on 2018/11/12 0012.
 * 二分搜索树, 类型必须有可比较性
 */
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 添加元素
    public void add(E e) {
        // 第一种
//        if (root == null) {
//            root = new Node(e);
//            size ++;
//        } else {
//            add(root, e);
//        }

        // 第二种,因为考虑到node的为空的情况
        root = add(root, e);
    }

    // 向以node为根的二份搜索树中插入元素E，递归算法
    private void add01(Node node, E e) {
        // 1.递归终止条件
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size ++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size ++;
            return;
        }
        // 2.递归
        if ((e.compareTo(node.e) < 0)) { // 左
            add(node.left, e);
        } else { // 右
            add(node.right, e);
        }
    }
    private Node add(Node node, E e) {
        // 1.递归终止条件
        if (node == null) {
            size ++;
            return new Node(e);
        }
        // 2.递归
        if ((e.compareTo(node.e) < 0)) { // 左
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0){ // 右
            node.right = add(node.right, e);
        }
        return node;
    }

    // 查询元素 e
    public boolean contains(E e) {
        return contains(root, e);
    }
    // 看以node为根的二分搜索树是否包含元素e，递归算法
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if(e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }
    // 前序遍历以node为根的二分搜索树，递归算法
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 前序遍历 - 非递归
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop(); // 栈顶
            System.out.println(cur.e);

            if (cur.right != null) { // 栈是先进后出
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    // 二分搜索树的中序遍历
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node){
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 二分搜索树的后序遍历
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }
    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateBSTString(depth) + "null\n");
            return;
        }
        res.append(generateBSTString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }
    private String generateBSTString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
