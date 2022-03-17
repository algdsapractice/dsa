package graph;
import java.util.*;
public class NetworkServers {
    private static int TIMER = 1;

    class StateNode {
        public boolean cycleCreated;
        public int parentTime;

        public StateNode() {
            this.parentTime = Integer.MAX_VALUE;
        }
        public void setCyclicParent(int time) {
            if (time < this.parentTime) {
                this.parentTime = time;
                this.cycleCreated = true;
            }
        }
        public String toString() {
            return "{"+ this.cycleCreated + ":" + this.parentTime +"}";
        }
    }
    class ServerNode {

        public int val;
        public int start, end;
        public boolean isVisited;
        public List<Integer> neighbours;

        public ServerNode(int val) {
            this.val = val;
            this.start = Integer.MAX_VALUE;
            this.end = Integer.MAX_VALUE;
            this.neighbours = new LinkedList<>();
        }
        public void startTime() {
            this.start = Math.min(this.start, NetworkServers.TIMER++);
            this.isVisited = true;
            //System.out.printf("start time : %d, node : %d\n", this.start, this.val);
        }
        public void endTime() {
            this.end = Math.min(this.end, NetworkServers.TIMER++);
            //System.out.printf("end time : %d, node : %d\n", this.end, this.val);
        }
    }

    private StateNode algorithmicLogic(
            int source, int parent,
            final ServerNode[] servers,
            List<List<Integer>> result
    ) {

        final StateNode sourceState = new StateNode();
        final ServerNode server = servers[source];

        if (server.isVisited) {
            //System.out.printf("source : %d, time : %d\n", source, server.start);
            sourceState.setCyclicParent(server.start);
            return sourceState;
        }

        server.startTime();

        for(Integer neighbour : server.neighbours) {
            if (neighbour != parent) {
                StateNode nextStateNode = algorithmicLogic(neighbour, source, servers, result);
                //System.out.printf("%d -> %d : %s\n", source, neighbour, nextStateNode);
                if (!nextStateNode.cycleCreated) { // is a regular edge (not inside any cyclic graph)
                    result.add(Arrays.asList(source, neighbour));
                }
                else { // This parent time can be better than current parent time
                    sourceState.setCyclicParent(nextStateNode.parentTime);
                }
            }
        }

        server.endTime();

        return sourceState;
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        final List<List<Integer>> result = new LinkedList<>();

        final ServerNode[] servers = new ServerNode[n];
        for(int i = 0; i < n; ++i) {
            servers[i] = new ServerNode(i);
        }

        for(List<Integer> connection: connections) {
            servers[connection.get(0)].neighbours.add(connection.get(1));
            servers[connection.get(1)].neighbours.add(connection.get(0));
        }

        algorithmicLogic(0, -1, servers, result);

        return result;
    }
}
