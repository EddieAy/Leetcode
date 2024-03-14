package ch14Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem417PacificAtlanticWaterFlow {


    private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights == null || heights.length == 0 || heights[0].length == 0){
            return res;
        }
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights,pacific,i,0);
            dfs(heights,atlantic,i,n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights,pacific,0,j);
            dfs(heights,atlantic,m - 1,j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;

    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j) {
        if(visited[i][j]) return;

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nextI = i + position[k][0];
            int nextJ = j + position[k][1];

            if(nextI < 0 || nextI >= heights.length || nextJ < 0 || nextJ >= heights[0].length){
                continue;
            }
            if(visited[nextI][nextJ] || heights[i][j] > heights[nextI][nextJ]){
                continue;
            }
            dfs(heights,visited,nextI,nextJ);
        }
    }
}
