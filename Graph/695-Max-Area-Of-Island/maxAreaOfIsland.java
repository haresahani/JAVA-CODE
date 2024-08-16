import java.util*;
class Solution {
    public int findArea(int row, int col, int[][] grid){
        grid[row][col] = 0;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        int currArea = 1;

        for(int [] dir : dirs){
            int nRow = row + dir[0];
            int nCol = col + dir[1];

            if(nRow < grid.length && nCol < grid[0].length && nRow >= 0 && nCol >= 0 && grid[nRow][nCol] == 1){
                currArea += findArea(nRow, nCol, grid);
            }
        }
        return currArea;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    int currArea = findArea(i,j,grid); // find current island area, convert 1s to 0s

                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }

        return maxArea;
    }
}