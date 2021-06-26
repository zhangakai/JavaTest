package LeetcodeTest;

import java.util.*;

public class DynamicProgramming {
    public static void main(String[] args) {

    }

    String source, target;
    Set<String> notPass = new HashSet<>();
    public int openLock(String[] deadened, String target) {
        source = "0000";
        this.target = target;
        if (source == this.target) {
            return 0;
        }
        for (String s : deadened) {
            notPass.add(s);
        }
        if (notPass.contains(this.target)) {
            return -1;
        }

    }

    public int bfs(){
        Queue<String> bfsQueue1 = new ArrayDeque<>();
        Queue<String> bfsQueue2 = new ArrayDeque<>();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        bfsQueue1.offer(source);
        bfsQueue2.offer(target);
        map1.put(source, 0);
        map2.put(target, 0);
        while (!bfsQueue1.isEmpty() && !bfsQueue2.isEmpty()) {
            int t = -1;

        }
        return -1;
    }

    public int update(Queue<String> queue, Map<String, Integer> curMap, Map<String, Integer> otherMap) {
        String curString = queue.poll();
        int step = curMap.get(curString);
        for (int i = 0; i < curString.length(); i++) {
            
        }
    }

}
