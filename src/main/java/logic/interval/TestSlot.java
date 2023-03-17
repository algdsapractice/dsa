package logic.interval;

import logic.interval.data.Interval;

import java.util.ArrayList;
import java.util.List;

public class TestSlot {
    public static void main(String[] args) {
        Slot slot = new Slot();
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(6, 11));
        input.add(new Interval(1, 3));
        input.add(new Interval(4, 7));
        for (Interval output : slot.getContinuousSlots(input)) {
            System.out.println(output.startTime + " " + output.endTime);
        }
    }

}
