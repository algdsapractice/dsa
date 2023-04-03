package logic.interval;

import java.util.Map;
import java.util.TreeMap;

public class CountIntervals {

    public TreeMap<Integer, Integer> intervals;
    int count;

    public CountIntervals() {
        this.intervals = new TreeMap<>();
        this.count = 0;
    }

    public void add(int left, int right) {
        // start and end to record the merged interval
        int start = left;
        int end = right;
        int toAdd = end - start + 1;

        Map.Entry<Integer, Integer> floor = intervals.floorEntry(left);
        if (floor != null) {
            if (floor.getValue() >= end) {
                // the entire current interval has been covered by the floor, so no new numbers need to add, simply just return.
                return;
            }
            if (floor.getValue() >= start) {
                // the current interval has been partially covered by the floor, so deduct the overlapping numbers.
                toAdd -= floor.getValue() - start + 1;
                intervals.remove(floor.getKey());
                start = floor.getKey();
            }
        }

        Map.Entry<Integer, Integer> ceiling = intervals.ceilingEntry(left);
        // there could be multiple ceilings overlap with the current interval.
        // e.g. current [5, 20], ceilings: [6, 8], [10, 15], [18, 22]
        // we need to deduct the overlapping numbers properly
        while (ceiling != null && ceiling.getKey() <= end) {
            toAdd -= Math.min(end, ceiling.getValue()) - ceiling.getKey() + 1;
            intervals.remove(ceiling.getKey());
            end = Math.max(end, ceiling.getValue());
            ceiling = intervals.ceilingEntry(left);
        }

        // add the new numbers to the count/result.
        count += toAdd;
        // add the merged interval to treemap
        intervals.put(start, end);
    }

    public int count() {
        return count;
    }
}


