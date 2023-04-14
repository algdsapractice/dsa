package dataStructure.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    public static class Pair{

        int value;
        String path;

        public Pair(int value, String path) {
            this.value = value;
            this.path = path;
        }
    }


    int vertices;
    LinkedList<Integer>[] adjacencyList ;

    public Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++){
            adjacencyList[i]= new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination){
        if(source<vertices && destination<vertices){
            // For directed graph single edge would be added
            this.adjacencyList[source].addLast(destination);
            // For un directed graph both  edges will get added
//            this.adjacencyList[destination].add(source);
        }

    }


    public void printGraph(){
        System.out.println("Adjancency List Of Graph");
        for(int i=0; i<vertices ;i++){
            if(adjacencyList[i]!=null)
            {
                int size = adjacencyList[i].size();
                LinkedList<Integer> internalList = adjacencyList[i];
                System.out.print("["+i+"]" +"->");
                for(int j=0; j<size ;j++){
                    System.out.print(+internalList.get(j)+"->");
                }

                System.out.println("null");
            }else{
                System.out.println("["+i+"]" +"->");
            }
        }
    }


    public void bfs(int n){

        boolean[] visited = new boolean[vertices];
        ArrayDeque<Pair> queue = new ArrayDeque<>();

        Pair pair = new Pair(n,n+"");
        queue.offer(pair);
        while(!queue.isEmpty()){
            // rm*wa*
            Pair removed =queue.removeFirst();
            int vertex=removed.value;

            if(visited[vertex]){
                continue;
            }
            visited[vertex]=true;

            System.out.println(removed.value +"  " + removed.path);

            for(int i=0; i< adjacencyList[vertex].size();i++){

                    int nbr = adjacencyList[vertex].get(i);

                    if(!visited[nbr]){
                        queue.offer(new Pair(nbr,removed.path+nbr));
                    }
            }
        }



    }


    public void dfs(int n){

        boolean[] visited = new boolean[vertices];

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(n,n+""));

        while(!stack.isEmpty()){
            Pair removed = stack.pop();
            int vertex = removed.value;

            if(visited[vertex]){
                continue;
            }

            System.out.println(vertex+"  "+removed.path);
            visited[vertex] = true;

            for(int i=0;i<adjacencyList[vertex].size();i++){

                int nbr = adjacencyList[vertex].get(i);

                if(!visited[nbr]){
                    stack.push(new Pair(nbr,removed.path+nbr));
                }
            }


        }
    }


    public static void main(String[] args) {

        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.printGraph();
        System.out.println("--------------BFS------------------");
        graph.bfs(0);
        System.out.println("--------------DFS Traversal------------------");

        graph.dfs(0);

    }
}
