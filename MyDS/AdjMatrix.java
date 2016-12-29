package MyDS;

public class AdjMatrix {
	private int adjmat[][];
	public AdjMatrix(int V) {
		adjmat = new int[V][V];
	}
	public void addUndirectedEdge(int u,int v) {
		adjmat[u][v] = 1;
		adjmat[v][u] = 1;
	}
	public void addWeightedUndirectedEdge(int u,int v,int w) {
		adjmat[u][v] = w;
		adjmat[v][u] = w;
	}
	public void addDirectedEdge(int u,int v) {
		adjmat[u][v] = 1;
	}
	public void addWeightedDirectedEdge(int u,int v,int w) {
		adjmat[u][v] = w;
	}
	public int getEdge(int u,int v) {
		return adjmat[u][v];
	}
	public boolean isEdge(int u,int v) {
		if(adjmat[u][v]!=0) return true;
		return false;
	}
	public int removeUndirectedEdge(int u,int v) {
		int ret = adjmat[u][v];
		adjmat[u][v] = 0;
		adjmat[v][u] = 0;
		return ret;
	}
	public int removeDirectedEdge(int u,int v) {
		int ret = adjmat[u][v];
		adjmat[u][v] = 0;
		return ret;
	}
}
