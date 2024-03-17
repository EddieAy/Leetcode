package ch14Graph;

public class Problem463IslandPerimeter {

    int res = 0;
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    return dfs(grid,i,j);
                }
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return 1;
        }
        if(grid[i][j] == 0){
            return 1;
        }
        if (grid[i][j] != 1){
            return 0;
        }
        grid[i][j] = 2;
        return dfs(grid,i - 1,j) +dfs(grid,i + 1, j) + dfs(grid,i,j - 1) + dfs(grid,i,j + 1);
    }

    public int islandPerimeter2(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    perimeter+=4;
                    if(i > 0 && grid[i - 1][j] == 1) perimeter-=2;
                    if(j > 0 && grid[i][j - 1] == 1) perimeter-=2;
                }
            }
        }
        return perimeter;
    }
}
