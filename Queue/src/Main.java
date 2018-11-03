import java.util.Random;

public class Main {

    // 测试入队和出队时间
    private static double testQueue(Queue<Integer>q, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 10000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoppQueue<Integer> loppQueue = new LoppQueue<>();
        double time2 = testQueue(loppQueue, opCount);
        System.out.println("LoppQueue, time: " + time2 + " s");
    }
}
