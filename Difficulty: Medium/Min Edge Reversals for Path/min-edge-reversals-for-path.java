import java.util.*;

class Solution {

    static class Pair {
        int node, cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {

        ArrayList<Pair>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Original edge -> cost 0
            graph[u].add(new Pair(v, 0));

            // Reverse edge -> cost 1
            graph[v].add(new Pair(u, 1));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<Integer> dq = new ArrayDeque<>();

        dist[src] = 0;
        dq.offerFirst(src);

        while (!dq.isEmpty()) {

            int node = dq.pollFirst();

            for (Pair nbr : graph[node]) {

                int next = nbr.node;
                int wt = nbr.cost;

                if (dist[node] + wt < dist[next]) {

                    dist[next] = dist[node] + wt;

                    if (wt == 0) {
                        dq.offerFirst(next);
                    } else {
                        dq.offerLast(next);
                    }
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}