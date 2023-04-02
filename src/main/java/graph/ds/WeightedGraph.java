package graph.ds;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {

    private int noOfVertices;
    private List<ArrayList<Edge>> graph;

    WeightedGraph(int noOfVertices){
        this.noOfVertices = noOfVertices;
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i = 0; i < noOfVertices; i++){
            graph.add(new ArrayList<Edge>());
        }
    }

    private void addEdge(int source , int destination, int wt){
        graph.get(source).add(new Edge(destination,wt));
        graph.get(destination).add(new Edge(source,wt));

    }

    private ArrayList<Edge> getAdjList(int source){
        return graph.get(source);
    }
    private class Edge{
        int nbr;
        int wt;

        public Edge(int nbr, int wt) {
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        WeightedGraph weightedGraph = new WeightedGraph(n);
        weightedGraph.addEdge(0, 1, 2);
        weightedGraph.addEdge(1, 2, 3);
        weightedGraph.addEdge(2, 3, 4);
        weightedGraph.addEdge(3, 4, 5);
        weightedGraph.addEdge(4, 0, 1);

        for(int i=0;i<n;i++){
            System.out.print("\n" +i+ " : ");
            for(Edge edge: weightedGraph.getAdjList(i)){
                System.out.print("(" + edge.nbr + ", " + edge.wt + ") ");
            }
        }
    }

    public static boolean hasPath(List<ArrayList<Edge>> graph,int src,int dest){

        if(src==dest){
            return true;
        }

        return false;
    }

}
