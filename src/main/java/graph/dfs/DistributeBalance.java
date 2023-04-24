package graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistributeBalance {
        public int minTransfers(int[][] transactions) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] t : transactions) {
                map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
                map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
            }

            map.forEach((k,v)-> System.out.println(k + " " + v));

            List<Integer> list = new ArrayList();
            for (int v : map.values()) {
                if (v != 0) {
                    list.add(v);
                }
            }

            list.forEach(System.out::print);
            System.out.println();

            return dfs(0, list);
        }

        private int dfs(int k, List<Integer> list) {
            if (k == list.size()) return 0;
            int cur = list.get(k);
            if (cur == 0) {
                return dfs(k + 1, list);
            }

            int min = Integer.MAX_VALUE;
            for (int i = k + 1; i < list.size(); i++) {
                int next = list.get(i);
                if (cur * next < 0) {
                    list.set(i, cur + next);
                    min = Math.min(min, 1 + dfs(k + 1, list));
                    list.set(i, next);

                    if (cur + next == 0) break;
                }
            }

            return min;
        }

    public static void main(String[] args) {
        int[][] transactions = {
                {0, 1, 10},
                {2, 0, 5},
                {1, 2, 5},
                {2, 3, 10}
        };

        DistributeBalance solution = new DistributeBalance();
        int minTransfers = solution.minTransfers(transactions);

        System.out.println("Minimum number of transfers required: " + minTransfers);
    }
}
