package ch14Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Problem827MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int islandId = 2;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    int area = getArea(grid,i,j,islandId);
                    map.put(islandId,area);
                    islandId++;
                }
            }
        }

        int maxArea = 0;
        for (Integer area : map.values()) {
            if (area > maxArea) {
                maxArea = area;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0){
                    HashSet<Integer> adjacentIslands = new HashSet<>();
                    if(i > 0) adjacentIslands.add(grid[i - 1][j]);
                    if(j > 0) adjacentIslands.add(grid[i][j - 1]);
                    if(i < n - 1) adjacentIslands.add(grid[i + 1][j]);
                    if(j < n - 1) adjacentIslands.add(grid[i][j + 1]);
                    int newArea = 1;
                    for (int adjIsland : adjacentIslands){//对于 所有与这块水域 相邻的 岛屿  用map找到 它对应的面积
                        newArea += map.getOrDefault(adjIsland,0);
                    }
                    maxArea = Math.max(maxArea,newArea);
                }
            }
        }
        return maxArea;

    }

    private int getArea(int[][] grid, int i, int j, int islandId) {
        if(i < 0 || i >= grid.length || j <0 || j >= grid[0].length){
            return 0;
        }
        if(grid[i][j] != 1){
            return 0;
        }
        grid[i][j] = islandId;
        int area = 1;
        area += getArea(grid,i + 1,j,islandId);
        area += getArea(grid,i - 1,j,islandId);
        area += getArea(grid,i,j + 1,islandId);
        area += getArea(grid,i,j - 1,islandId);
        return area;
    }
}
