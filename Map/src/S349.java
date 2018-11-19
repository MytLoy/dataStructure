import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by Administrator on 2018/11/19 0019.
 * leetcode 349. 两个数组的交集 (集合)
 */


public class S349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        // 将nums1放入集合中，因集合不存在重复元素=去重
        for (int num: nums1) {
            set.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num: nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num); // 如果nums1存在num2中的元素num就把它删掉，避免重复
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
