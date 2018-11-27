// 融合器(两个区间是如何融合的）
public interface Merger<E> {
    E merge(E a, E b);
}
