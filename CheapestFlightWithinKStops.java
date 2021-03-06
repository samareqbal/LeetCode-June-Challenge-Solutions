package LeetCodeJune;
import java.util.*; 
public class CheapestFlightWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        init(n, flights);
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.offer(new int[]{src, 0, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int city = current[0], distance = current[1], cost = current[2];
            if (city == dst)
                return cost;
            if (distance <= K) {
                for (int[] child : graph.get(city)) {
                    queue.offer(new int[]{child[0], distance + 1, cost + child[1]});
                }
            }
        }
        return -1;
    }
    private final List<List<int[]>> graph = new ArrayList<>();

    private void init(int n, int[][] flights) {
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] flight : flights)
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
    }
}
