package logic.interval;

import logic.interval.data.Interval;

import java.util.ArrayList;
import java.util.List;

public class Slot  {



    public List<Interval> getContinuousSlots(List<Interval> intervals) {
        boolean[] hours= new boolean[24];
        for(Interval interval:intervals){
            for(int i=interval.startTime;i<interval.endTime;i++){
                hours[i]=true;
            }
        }
        List<Interval> output= new ArrayList<>();
        for(int i=0;i<24;i++){
            if(hours[i]){
                //System.out.println(output.get(output.size()-1));
                if(output.size()>0&&output.get(output.size()-1).endTime==i){
                    output.get(output.size()-1).endTime=i+1;
                }
                else{
                    Interval interval= new Interval(i,i+1); //
                    output.add(interval);
                }
            }
        }
        return output;
    }
}
