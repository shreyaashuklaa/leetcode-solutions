class Solution {

    private boolean isSafe(int node, int col,
                           ArrayList<Integer>[] graph,
                           int[] color) {

        for (int neigh : graph[node]) {
            if (color[neigh] == col) {
                return false;
            }
        }

        return true;
    }

    private boolean solve(int node,
                          ArrayList<Integer>[] graph,
                          int[] color,
                          int m,
                          int v) {

        // Base Case
        if (node == v) {
            return true;
        }

        // Try all colors
        for (int col = 1; col <= m; col++) {

            if (isSafe(node, col, graph, color)) {

                color[node] = col;

                // Recursive call
                if (solve(node + 1, graph, color, m, v)) {
                    return true;
                }

                // Backtracking
                color[node] = 0;
            }
        }

        return false;
    }

    boolean graphColoring(int v, int[][] edges, int m) {

        ArrayList<Integer>[] graph = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int w = edge[1];

            graph[u].add(w);
            graph[w].add(u);
        }

        int[] color = new int[v];

        return solve(0, graph, color, m, v);
    }
}