package graph.bfs;

import java.util.*;

public class  BusRoutes {

    public static void main(String[] args) {
        int [][] routes = {{1,2,7},{3,6,7}};
        int source = 1, target = 6;

        numBusesToDestination(routes,source,target);


    }

    public static int numBusesToDestination(int[][] routes, int source, int target) {


        if(source==target){
            return 0;
        }

        // 1. Hashmap -> key ->  stop number -> value hashset of busNumber

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

        for(int busNumber = 0; busNumber < routes.length; busNumber++){

            for (int j=0 ; j<routes[busNumber].length ; j++){
                int busStop = routes[busNumber][j];
                ArrayList<Integer>  busNoList = map.getOrDefault(busNumber,new ArrayList<Integer>());
                busNoList.add(busNumber);
                map.put(busStop,busNoList);

            }
        }


        //2.  BFS making a queue
        HashSet<Integer> visitedBusStop = new HashSet<Integer>();

        HashSet<Integer> visitedBus = new HashSet<Integer>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visitedBusStop.add(source);
        int level =0;


        while(!queue.isEmpty()){
            for(int i=0 ; i<queue.size() ; i++){
                    Integer busStop=queue.poll();
                    if(busStop==target){
                        return level;
                    }

            }

        }


        //3. count how many busses we have to go on

        //4. take our hash map get the hashset for the bus stop

        // 5 . Check if we have been in the bus before (using another hashset)

        // for every stop check if the bus is in target if not add the  stop to the queue

        return 0;
    }
}
