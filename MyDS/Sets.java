package MyDS;

import java.util.HashSet;

public class Sets {
    private int arr[];
    private int size[];
    public Sets(int n) {
        arr = new int[n];
        size = new int[n];
    }
    public void initialize(int n) {
        for(int i=0;i<n;i++) {
            arr[i] = i;
            size[i] = 1;
        }
    }
    public int root(int i) {
        while(arr[i]!=i) {
            arr[i] = arr[arr[i]];
            i = arr[i];
        }
        return i;
    }
    public void union(int a,int b) {
        int rootA = root(a);
        int rootB = root(b);
        if(rootA==rootB) return;
        if(size[rootA]<size[rootB]) {
            arr[rootA] = arr[rootB];
            size[rootB] += size[rootA];
        }
        else {
            arr[rootB] = arr[rootA];
            size[rootA] += size[rootB]; 
        }
    }
    public int countSets(int start,int end) {
        HashSet<Integer> hs = new HashSet<>();
        int count = 0;
        int t;
        for(int i=start;i<=end;i++) {
            t = root(i);
            if(!hs.contains(t)) {
                count++;
                hs.add(t);
            }
        }
        return count;
    }

}