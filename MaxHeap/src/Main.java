import java.util.Random;

public class Main {

    private static double testHeap(Integer[] tesrData, boolean isHeapify) {
        long startTime = System.nanoTime();

        // 往堆添加元素
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(tesrData);
        } else {
            maxHeap = new MaxHeap<>();
            for (int num:tesrData) {
                maxHeap.add(num);
            }
        }

        // 验证堆的正确性
        int[] arr = new int[tesrData.length];
        for (int i = 0; i < tesrData.length; i++) {
            arr[i] = maxHeap.extractMax(); // 从大到小排序
        }
        for (int i = 1; i < tesrData.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("ERROR");
            }
        }
        System.out.println("Test MaxHeap completed");

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");
        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + " s");

    }
}
