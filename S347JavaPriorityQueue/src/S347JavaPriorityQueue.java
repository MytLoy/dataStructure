/**
 * Created by Administrator on 2018/11/22 0022.
 * leetcode 347. 前K个高频元素 （使用java默认的PriorityQueue:内部是最小堆） - 修改
 */
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap; // 统计频次
import java.util.PriorityQueue;
import java.util.Comparator;

public class S347JavaPriorityQueue {
    public List<Integer> topKFrequent(int[] nums, int k) {

        // 统计频次
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 优先队列
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) { // 使用匿名类修改java内部的比较器
                return map.get(a) - map.get(b);
            }
        });
        for (int key: map.keySet()) {
            if (pq.size() < k) { // 没有存够k个元素
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) { // 当前的频次高一些
                pq.remove();
                pq.add(key);
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }

        return res;
    }
}
