package LeetcodeTest;

/**
 * @author 阿凯
 */
public class DFS {
    public static void main(String[] args) {

    }
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfsLand(grid, i, j);
                }
            }
        }
        return result;
    }

    public void dfsLand(char[][] grid, int row, int col) {
        if (row > grid.length || row < 0 || col > grid[0].length || col < 0 || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '2';
        dfsLand(grid, row + 1, col);
        dfsLand(grid, row - 1, col);
        dfsLand(grid, row, col + 1);
        dfsLand(grid, row, col - 1);
    }
}
