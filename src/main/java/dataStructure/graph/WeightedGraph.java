package dataStructure.graph;

import java.util.LinkedList;
import java.util.List;

public class WeightedGraph {

    class Edge{
        int source;
        int destination;
        int weight;


        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    int vertices;
    LinkedList<Edge> [] adjancencyList;

    WeightedGraph(int vertices){
        this.vertices = vertices;
        adjancencyList= new LinkedList[vertices];

        for(int i = 0; i < vertices;i++){
                 adjancencyList[i]= new LinkedList<Edge>();
        }
    }

    public void addEdge(int source, int destination, int weight){
        adjancencyList[source].addLast(new Edge(source, destination, weight));
        //adjancencyList[destination].addLast(new Edge(destination, source, weight));

    }

    public void printGraph(){
        for(int i = 0;i < vertices;i++){
            System.out.print("["+i+"]");
            for(int j = 0; j < adjancencyList[i].size();i++){
                Edge edge = adjancencyList[i].get(j);
                System.out.print("->"+ "[" +edge.source+" "+ edge.destination + " " + edge.weight+"]");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        WeightedGraph graph = new WeightedGraph(4);
        graph.addEdge(0,1,10);
        graph.addEdge(0,2,20);
        graph.addEdge(1,3,30);
        graph.addEdge(2,3,40);
        graph.printGraph();
    }

}
