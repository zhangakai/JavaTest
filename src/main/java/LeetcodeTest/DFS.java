package LeetcodeTest;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 阿凯
 */
public class DFS {
    public static void main(String[] args) {
        DFS dfs = new DFS();
        System.out.println(dfs.generateParenthesis(3));
        System.out.println(Integer.divideUnsigned(10, 3));
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

    public List<String> generateParenthesis(int n) {
        List<String> stringList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(sb, n, 0, stringList);
        System.out.println(stringList);
        return stringList;
    }

    public void dfs(StringBuilder sb, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }
        if (left > 0) {
            dfs(sb.append('('), left-1, right+1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > 0) {
            dfs(sb.append(')'), left, right-1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return null;
    }

    List<List<Integer>> result;
    public void dfsCombinationSum(int[] candidates, int target, int start, List<Integer> temp) {

        if (target == 0) {
            List<Integer> list = new ArrayList<>(temp);
            result.add(list);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] >= target) {
                temp.add(candidates[i]);
                dfsCombinationSum(candidates, target - candidates[i], i, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
