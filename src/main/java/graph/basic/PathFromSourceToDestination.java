package graph.basic;

import dataStructure.graph.WeightedGraph;

import java.util.LinkedList;

public class PathFromSourceToDestination {

    public static void main(String[] args) {
        //
        WeightedGraph graph = new WeightedGraph(8);
        graph.addEdge(0,1,10);
        graph.addEdge(1,2,10);
        graph.addEdge(2,3,10);
        graph.addEdge(0,3,10);
        graph.addEdge(3,4,10);
        graph.addEdge(4,5,10);
        graph.addEdge(5,6,10);
        graph.addEdge(4,6,10);
        graph.printGraph();
        LinkedList<WeightedGraph.Edge>[] adjancencyList = graph.adjancencyList;
    }
}
