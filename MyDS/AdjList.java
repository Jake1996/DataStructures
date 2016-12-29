package MyDS;

import java.util.ArrayList;

public class AdjList {
	public static class node {
		int vertex;
		int value;
		public node(int v,int val) {
			vertex = v;
			value = val;
		}
	}
	private ArrayList<ArrayList<node>> adjlist;
	public AdjList(int V) {
		adjlist = new ArrayList<>(V);
		
	}
	public void addUndirectedEdge(int u,int v) {
		if(adjlist.get(u)==null) {
			adjlist.add(u, new ArrayList<>());
		}
		if(adjlist.get(v)==null) {
			adjlist.add(v, new ArrayList<>());
		}
		adjlist.get(u).add(new node(v,1));
		adjlist.get(v).add(new node(u,1));
	}
	public void addWeightedUndirectedEdge(int u,int v,int w) {
		if(adjlist.get(u)==null) {
			adjlist.add(u, new ArrayList<>());
		}
		if(adjlist.get(v)==null) {
			adjlist.add(v, new ArrayList<>());
		}
		adjlist.get(u).add(new node(v,w));
		adjlist.get(v).add(new node(u,w));
	}
	public void addDirectedEdge(int u,int v) {
		if(adjlist.get(u)==null) {
			adjlist.add(u, new ArrayList<>());
		}
		adjlist.get(u).add(new node(v,1));
	}
	public void addWeightedDirectedEdge(int u,int v,int w) {
		if(adjlist.get(u)==null) {
			adjlist.add(u, new ArrayList<>());
		}
		adjlist.get(u).add(new node(v,w));
	}
	public int getEdge(int u,int v) {
		ArrayList<node> arr = adjlist.get(u);
		if(arr!=null)
		for(node t : arr) {
			if(t.vertex==v) return t.value;
		}
		return 0;
	}
	public boolean isEdge(int u,int v) {
		ArrayList<node> arr = adjlist.get(u);
		if(arr!=null)
		for(node t : arr) {
			if(t.vertex==v) return true;
		}
		return false;
	}
	public int removeUndirectedEdge(int u,int v) {
		int ret = 0;
		ArrayList<node> arr = adjlist.get(u);
		if(arr!=null)
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i).vertex==v) {
				ret =  arr.get(i).value;
				arr.remove(i);
				arr = adjlist.get(v);
				i=0;
				while(arr.get(i).vertex!=v) i++;
				arr.remove(i);
				return ret;
			}
			
		}
		return ret;
	}
	public int removeDirectedEdge(int u,int v) {
		int ret = 0;
		ArrayList<node> arr = adjlist.get(u);
		if(arr!=null)
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i).vertex==v) {
				ret =  arr.get(i).value;
				arr.remove(i);
				return ret;
			}
			
		}
		return ret;
	}
}
