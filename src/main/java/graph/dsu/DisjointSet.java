package graph.dsu;

public class DisjointSet {

    int[] rank;
    int[] parent;

    public DisjointSet(int n){
        rank = new int[n+1];
        parent = new int[n+1];
        // first approach
        for(int i = 0; i <=n; i++)
        {
            rank[i] =1;
            parent[i] =i;
        }
//        // setting the rank initially to zero
//        Arrays.fill(rank,0);
//        // setting the parent to the same number initially
//        Arrays.setAll(parent, i-> i+1-1);


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
            parent[y]=px;
            rank[px]+=1;
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
        isSameParent(ds,3,7);
        ds.unionByRank(3, 7);
        isSameParent(ds,3,7);

    }

    private static void isSameParent(DisjointSet ds, int x, int y) {
        if (ds.findRootParent(x) == ds.findRootParent(y)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }

}
