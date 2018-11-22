/**
 * Created by Administrator on 2018/11/22 0022.
 * leetcode 347. 前K个高频元素 （使用java默认的PriorityQueue:内部是最小堆）
 */
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap; // 统计频次
import java.util.PriorityQueue;

public class Solution347 {
    private class Freq implements Comparable<Freq> {
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        // 频次越低层次越高
        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return -1;
            } else if (this.freq > another.freq) {
                return 1;
            } else {
                return 0;
            }
        }
    }

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
        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int key: map.keySet()) {
            if (pq.size() < k) { // 没有存够k个元素
                pq.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.peek().freq) { // 当前的频次高一些
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove().e);
        }

        return res;
    }
}
