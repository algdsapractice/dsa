package graph.dsu;

import java.util.Arrays;

public class DisjointSet {

    int[] rank;
    int[] parent;

    public DisjointSet(int n){
        rank = new int[n+1];
        parent = new int[n+1];
        // setting the rank initially to zero
        Arrays.fill(rank,0);
        // setting the parent to the same number initially
        Arrays.setAll(parent, i-> i+1-1);
    }

    public int findRootParent(int x){
        if(x==parent[x])
            return x;
       return parent[x]=findRootParent(parent[x]);

    }


    public void unionByRank(int x, int y){

        // find the topmost parent for u and v
        int px = findRootParent(x);

        int py = findRootParent(y);

        int rx = rank[px];
        int ry = rank[py];
        // whoever has the highest rank will the parent
        if(rx<ry){
            parent[x]=py;
        }else if(rx>ry) {
        parent[y]=px;
        }
        else{
            // if ranks are equal than any  can be parent
            // let u be the parent of v and increment the rank of u by 1
            parent[y]=x;
            rank[px]=rx+1;
        }


    }

    public static void main(String[] args) {

        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findRootParent(3) == ds.findRootParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findRootParent(3) == ds.findRootParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }

}
