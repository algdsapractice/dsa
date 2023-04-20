package dataStructure.graph;

import java.util.LinkedList;

public class WeightedGraph {

    public  class Edge{
        int source;
        int nbr;
        int weight;


        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.nbr = destination;
            this.weight = weight;
        }
    }


    public  int vertices;
    public  LinkedList<Edge> [] adjancencyList;

    public WeightedGraph(int vertices){
        this.vertices = vertices;
        adjancencyList= new LinkedList[vertices];

        for(int i = 0; i < vertices;i++){
                 adjancencyList[i]= new LinkedList<Edge>();
        }
    }

    public void addEdge(int source, int destination, int weight){
        adjancencyList[source].addLast(new Edge(source, destination, weight));
        adjancencyList[destination].addLast(new Edge(destination, source, weight));

    }

    public  void printGraph(){
        for(int i = 0;i < vertices;i++){
            System.out.print("["+i+"]");
            for(int j = 0; j < adjancencyList[i].size();j++){
                Edge edge = adjancencyList[i].get(j);
                System.out.print("->"+ "[" +edge.source+" "+ edge.nbr + " " + edge.weight+"]");

            }
            System.out.println("-> null");
        }
    }

    public static void main(String[] args) {

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
    }

}
