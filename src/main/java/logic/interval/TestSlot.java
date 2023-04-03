package logic.interval;

import logic.interval.data.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class TestSlot {
    public static void main(String[] args) {
//        Slot slot = new Slot();
//        List<Interval> input = new ArrayList<>();
//        input.add(new Interval(6, 11));
//        input.add(new Interval(1, 3));
//        input.add(new Interval(4, 7));
//        for (Interval output : slot.getContinuousSlots(input)) {
//            System.out.println(output.startTime + " " + output.endTime);
//        }

        CountIntervals intervals = new CountIntervals();

        intervals.add(6,11);
        intervals.add(1,3);
        intervals.add(4,7);

        TreeMap<Integer, Integer> non_OverLapping_Intervals = intervals.intervals;
        //non_OverLapping_Intervals.forEach((k,v) -> System.out.println("key" +k + "value" + v));

        System.out.println(non_OverLapping_Intervals);
    }

}
