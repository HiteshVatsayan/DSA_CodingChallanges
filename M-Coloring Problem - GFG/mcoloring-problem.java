//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int[] color=new int[n];
        Arrays.fill(color,0);
        if(solve(graph,0,m,n,color)) return true;
        return false;
    }
    
    public boolean solve(boolean graph[][],int i, int m, int n, int[] color){
        
        if(i==n){
            return true;
        }
        
        for(int j=1;j<=m;j++){
            if(isPossible(graph,j,i,color)){
                color[i]=j;
                if(solve(graph,i+1,m,n,color)){
                    return true;
                }
                else{
                    color[i]=0;
                }
            }
        }
        
        return false;
        
    }
    
    public boolean isPossible(boolean graph[][],int c,int node,int[] color){
        
        for(int i=0;i<graph.length;i++){
            if(graph[node][i]){
                if(color[i]==c){
                    return false;
                }
            }
        }
        
        return true;
    }
}