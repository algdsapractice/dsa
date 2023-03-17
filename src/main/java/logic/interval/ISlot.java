package logic.interval;

import logic.interval.data.Interval;

import java.util.List;

public interface ISlot {
    List<Interval> getContinuousSlots(List<Interval> intervals);
}
