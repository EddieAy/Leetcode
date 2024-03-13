package ch14Graph;

import java.util.ArrayList;
import java.util.List;

public class Problem797AllPathsFromSourcetoTarget {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        dfs(graph,0);
        return res;
    }

    private void dfs(int[][] graph, int node) {
        if(node == graph.length - 1){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < graph[node].length; i++) {
            int next = graph[node][i];
            path.add(next);
            dfs(graph,next);
            path.removeLast();
        }
    }
}
