//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        
        ArrayList<Integer> list=new ArrayList<>();
        
        solve(0,0,list,arr,N);
        
        Collections.sort(list);
        
        return list;
    }
    
    public void solve(int sum, int ind, ArrayList<Integer> list,ArrayList<Integer> arr, int n){
        if(ind>=n){
            list.add(sum);
            return;
        }
        
        solve(sum+arr.get(ind),ind+1,list,arr,n);
        solve(sum,ind+1,list,arr,n);
    }
    
    
}