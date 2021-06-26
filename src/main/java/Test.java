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
}
