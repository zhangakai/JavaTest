import joptsimple.internal.Strings;

import java.util.*;
import java.lang.StringBuilder;
import java.util.stream.Collectors;

public class Test {
    static int result;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) {
            sb.append(scanner.next());
        }
        String mtr = sb.toString();
        System.out.println(mtr);
        String[] strings = mtr.split(";");
        int row  = strings.length;
        int col = strings[0].split(",").length;
        boolean[][] flag = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            String[] temp = strings[i].split(",");
            for (int j = 0; j < temp.length; j++) {
                if (temp[j].equals("1")) {
                    flag[i][j]=true;
                }
            }
        }
        if (flag[row - 1][col - 1] == false) {
            System.out.println(0);
            return;
        }
        result=Integer.MAX_VALUE;
        dfs(flag, 0, 0, 1);
        System.out.println(result);
    }


    public static void dfs(boolean[][] flag, int x, int y,int points) {
        if (x >= flag.length || x < 0 || y >= flag[0].length || y < 0||flag[x][y]==false) {
            return;
        }
        if (x == flag.length - 1 && y == flag[0].length - 1) {
            result = Math.min(points, result);
            return;
        }
        points++;
        flag[x][y]=false;
        dfs(flag, x + 1, y, points);
        dfs(flag, x, y + 1, points);
        dfs(flag, x - 1, y, points);
        dfs(flag, x, y - 1, points);
        flag[x][y]=true;
        points--;
    }

    public void work1() {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String[] oldStrings = s1.split(",");
        String[] newStrings = s2.split(",");
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        for (String ss : oldStrings) {
            String[] temp = ss.split("-");
            map1.put(temp[0],temp[1]);
        }
        for (String ss : newStrings) {
            String[] temp = ss.split("-");
            map2.put(temp[0],temp[1]);
        }
        StringBuilder result = new StringBuilder();
        Map<String, String> resultMap = new HashMap<>();
        for (String s : map1.keySet()) {
            if (map2.containsKey(s)) {
                if (!map2.get(s).equals(map1.get(s)) ){
                    resultMap.put(s, "modify-");
                }
            } else {
                resultMap.put(s, "delete-");
            }
        }
        for (String s : map2.keySet()) {
            if (!map1.containsKey(s)) {
                resultMap.put(s, "add-");
            }
        }
        List<String> array = new ArrayList<>();
        for (String s : resultMap.keySet()) {
            array.add(s);
        }
        array.sort(String::compareTo);
        for (String s : array) {
            result.append(resultMap.get(s)).append(s).append(",");
        }
        result.deleteCharAt(result.length() - 1);
        System.out.println(result);
    }

    public void work2() {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        long[][] pay = new long[length][2];
        for (int i = 0; i < length; i++) {
            String temp = scanner.next();
            String[] strings = temp.split(",");
            pay[i][0] = Long.valueOf(strings[0]);
            pay[i][1] = Long.valueOf(strings[1]);
        }
        long payOverTime = pay[0][0]+pay[0][1];
        long result = pay[0][1];
        for (int i = 1; i < length; i++) {
            long[] longs = pay[i];
            if (longs[0] >= payOverTime) {
                result += longs[1];

            } else {
                result += longs[1] + payOverTime - longs[0];

            }
            payOverTime += longs[1];

        }
        System.out.println(result);
    }


    public int trap(int[] height) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int index = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int high = Math.min(height[stack.peek()], height[i]) - height[index];
                int width = i - stack.peek() - 1;
                result += high * width;
            }
            stack.push(i);
        }
        return result;
    }



    List<List<Integer>> premuteResultList;
    public void dfsPremute(int[] nums, boolean[] flags, List<Integer> temp) {
        if (temp.size() == nums.length) {
            premuteResultList.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flags[nums[i]] == true) {
                continue;
            }
            flags[nums[i]]=true;
            temp.add(nums[i]);
            dfsPremute(nums, flags, temp);
            temp.remove(temp.size() - 1);
            flags[nums[i]]=false;
        }
    }

    public void dfsPremuteUnique(int[] nums, boolean[] flags, List<Integer> temp) {
        if (temp.size() == nums.length) {
            premuteResultList.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flags[i] || (i > 0 && nums[i] == nums[i - 1] && !flags[i - 1])) {
                continue;
            }
            flags[i] = true;
            temp.add(nums[i]);
            dfsPremute(nums, flags, temp);
            temp.remove(temp.size() - 1);
            flags[i] = false;
        }
    }

    public int maxSubArray(int[] nums) {
        int result = -1;
        int temp = 0;
        for (int num : nums) {
            if (temp + num <= 0) {
                temp = 0;
                continue;
            }
            temp += num;
            result = Math.max(result, temp);
        }
        return result;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int low = 0;
        int high = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        int n = matrix[0].length*matrix.length;
        int index = 0;
        List<Integer> result = new ArrayList<>();
        while (index < n) {
            for (int j = left; j < right; j++) {
                index++;
                result.add(matrix[low][j]);
            }
            low++;
            for (int i = low; i < high; i++) {
                index++;
                result.add(matrix[i][right]);
            }
            right--;
            for (int j = right; j >= left ; j--) {
                index++;
                result.add(matrix[high][j]);
            }
            high--;
            for (int i = high; i >= low; i--) {
                index++;
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }

    public String getPermutation(int n, int k) {

    }

    int end;
    String resultString;
    public void dfsGetPremutation(int n, int index, StringBuilder stringBuilder, boolean[] isUsed) {
        if (stringBuilder.length() == n) {
            index++;
            if (index == end) {
                resultString = stringBuilder.toString();
            }
        }
        for (int i = 1; i < n; i++) {
            if (isUsed[i]) {
                continue;
            }
            isUsed[i]=true;
            stringBuilder.append(i);
            dfsGetPremutation(n, index, stringBuilder, isUsed);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            isUsed[i]=false;


        }
    }

    public int largestRectangleArea(int[] heights) {
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            int end = i;
            while (start>=0&&heights[start] >= heights[i]) {
                start--;
            }
            while (end < heights.length && heights[end] >= heights[i]) {
                end++;
            }
            result = Math.max(result, (start - end - 1) * heights[i]);
        }
        return result;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 + l2 != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[l1][l2];
        dp[0][0] = true;
        for (int i = 0; i < l1; i++) {
            if (dp[i][0] && (s1.charAt(i) == s3.charAt(i))) {
                dp[i + 1][0] = true;
            }
        }
        for (int i = 0; i < l2; i++) {
            if (dp[0][i] && (s2.charAt(i) == s3.charAt(i))) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 1; i < l1; i++) {
            for (int j = 1; j <l2 ; j++) {
                dp[i][j] = (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i - 1 + j))) || (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }
        return dp[l1-1][l2-1];
    }

}
