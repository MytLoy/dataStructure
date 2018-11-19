import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by Administrator on 2018/11/19 0019.
 * leetcode 两个数组的交集 II （计重）（映射）
 */
public class S350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num: nums1) {
            if (!map.containsKey(num)) { // 不包含
                map.put(num, 1); // 添加(值，频次) add方法
            } else {
                map.put(num, map.get(num) + 1); // 频次加一  set方法
            }
        }
        // 遍历num2处理交集
        ArrayList<Integer> list = new ArrayList<>();
        for (int num: nums2) {
            if (map.containsKey(num)) { // 找到相同的元素
                list.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) { // 频次为0 = 找完了，就可以删除
                    map.remove(num);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
