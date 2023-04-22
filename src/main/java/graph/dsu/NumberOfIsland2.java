package graph.dsu;

import java.util.*;

public class NumberOfIsland2 {

    class DSU
    {

        int [] rank;
        int [] parent;
        int count;


        public DSU(int size){

            rank = new int[size];
            parent = new int[size];
            count=0;
            for(int i=0;i<size;i++){

                rank[i]=0;
                parent[i]=-1;
            }
        }

        public boolean isIsland(int x){
            return parent[x]!=-1;
        }

        public int nuOfIsland(){
            return this.count;
        }

        public void addToIsland(int x)
        {
            if (x >= 0 && x < parent.length && parent[x] == -1) {
                parent[x] = x;
               this.count++;
            }
        }

        public void union(int x,int y)
        {

            int px=find(x);
            int py=find(y);

            int rx = rank[x];
            int ry = rank[y];
            if(px==py){
                return;
            }
            else if(rx<ry){
                parent[x]=py;

            } else if(ry<rx){
                parent[y]=px;
            } else {

                parent[y]=px;

                rank[px]+=1;

            }

            this.count--;


        }

        public int find(int x)
        {

            if(x==parent[x]){
                return x;
            }

            return parent[x]=find(parent[x]);
        }



    }





    public static void main(String[] args) {

        int [][] positions = {{0,1},{1,2},{2,1},{1,0},{0,2},{0,0},{1,1}};
       // int [][] positions = {{0,1},{0,1},{1,2},{2,1}};

        int m =3;
        int n=3;

        NumberOfIsland2 nuOfIsland= new NumberOfIsland2();
        List<Integer> result = nuOfIsland.getNumberOfIslands(m,n,positions);

        result.forEach(r-> System.out.print(r));

    }

    public List<Integer> getNumberOfIslands(int m , int n , int [][] positions ){

        // -1,0 -> top , 1,0 -> down 0,-1 -> left , 0,1 right
        int dirX[] = {-1,1,0,0};
        int dirY[] = {0,0,-1,1};

        List<Integer> result = new ArrayList<>();
        DSU dsu = new DSU(m*n);

        for(int[] pos : positions){

            int x = pos[0];
            int y= pos[1];

            int landPosition = x*n+y;
            dsu.addToIsland(landPosition);

            // check in all 4 directions from current x and y positions
            for(int i =0 ; i< 4;i++)
            {

                int nbrX=x+dirX[i];
                int nbrY=y+dirY[i];

                int nbrLandPosition= nbrX*n+nbrY;

                if(nbrY>=0 && nbrX>=0 && nbrX<m && nbrY<n && dsu.isIsland(nbrLandPosition))
                {

                    dsu.union(landPosition,nbrLandPosition);

                }


            }

            result.add(dsu.nuOfIsland());


        }
        return result;
    }

}