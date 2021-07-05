package LeetcodeTest;

import java.util.*;

public class BFS {
    public static void main(String[] args) {

    }

    //815 https://leetcode-cn.com/problems/bus-routes/
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> busOfPassStation = new HashMap<>();
        Map<Integer, Integer> disOfStation = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < routes.length; i++) {
            for (int station : routes[i]) {
                if (station == source) {
                    queue.offer(i);
                    disOfStation.put(i, 1);
                }
                Set<Integer> temp = busOfPassStation.getOrDefault(station,new HashSet<>());
                temp.add(i);
                busOfPassStation.put(station, temp);
            }
        }
        while (!queue.isEmpty()) {
            int bus = queue.poll();
            int step = disOfStation.get(bus);
            for (int station : routes[bus]) {
                if (station == target) {
                    return step;
                }
                Set<Integer> nextBus = busOfPassStation.get(station);
                if (nextBus == null) {
                    continue;
                }
                for (Integer b : nextBus) {
                    if (!disOfStation.containsKey(b)) {
                        disOfStation.put(b, step + 1);
                        queue.add(b);
                    }
                }
            }
        }
        return -1;

    }
}
