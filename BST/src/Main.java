import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num: nums) {
            bst.add(num);
        }
//        bst.preOrder();
//        System.out.println();
//
//        bst.preOrderNR();

//        bst.inOrder();
//        System.out.println();
//
//        bst.postOrder();
//        System.out.println();

//        bst.levelOrder();

        BST<Integer> bst01 = new BST<>();
        Random random = new Random();

        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst01.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums01 = new ArrayList<>();
        while (!bst01.isEmpty()) {
            nums01.add(bst01.removeMin());
        }
        System.out.println(nums01);
        for (int i = 1; i < nums01.size(); i++) {
            if (nums01.get(i-1) > nums01.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMin test completed");
    }
}
