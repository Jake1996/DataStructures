package MyDS;

public class SegmentTreeWithLazyProp {
	public long ST[];
	public long lazy[];
	public int size;
	public SegmentTreeWithLazyProp(int size) {
		this.size = size-1;
		int len =largestPower(size);
		if(len==size) len = len<<1;
		else len = len<<2;
		ST = new long[len];
		lazy = new long[len];
	}
	private static int largestPower(int n){
		n = n|(n>>1);
		n = n|(n>>2);
		n = n|(n>>4);
		n = n|(n>>8);
		return (n+1)>>1;
	}
	public void initialize(long arr[]) {
		initialize(arr, 1, 0, size);
	}
	public void updateRange(int l,int r,long delta) {
		updateRange(1, 0, size, l, r, delta);
	}
	public long queryRange(int l,int r) {
		return queryRange(1, 0, size, l, r);
	}
	public long initialize(long arr[],int node,int start,int end) {
		if(start==end) {
			ST[node] = arr[start];
			return ST[node];
		}
		int mid = (start+end)/2;
		ST[node] = initialize(arr,2*node+1,start,mid) + initialize(arr,2*node+2,mid+1,end);
		return ST[node];
	}
	public void updateRange(int node,int start,int end,int l,int r,long delta) {
		if(lazy[node]!=0) {
			ST[node] += (end-start+1)*lazy[node];
			if(start!=end) {
				lazy[node*2] += lazy[node];
				lazy[node*2+1] += lazy[node];
			}
			lazy[node] = 0;
		}
		if(start>end || start>r || end<l) 
			return;
		if(start >= l && end <=r) {
			ST[node] += (end-start+1)*delta;
			if(start!=end) {
				lazy[node*2] += delta;
				lazy[node*2+1] += delta;
			}
			return;
		}
		int mid = (start+end)/2;
		updateRange(node*2, start, mid, l, r, delta);
		updateRange(node*2+1, mid+1, end, l, r, delta);
		ST[node] = ST[node*2] + ST[node*2+1];
	}
	public long queryRange(int node,int start,int end,int l,int r) {
		if(start>end||start>r||end<l)
			return 0;
		if(lazy[node]!=0) {
			ST[node] +=(end-start+1)*lazy[node];
			if(start!=end) {
				lazy[node*2] += lazy[node];
				lazy[node*2+1] += lazy[node];
			}
			lazy[node] = 0;
		}
		if(start >=l &&end<=r)
			return ST[node];
		int mid = (start+end)/2;
		return queryRange(node*2, start, mid, l, r) + queryRange(node*2+1, mid+1, end, l, r);
	}
	public static void main(String args[]) {
		SegmentTreeWithLazyProp s = new SegmentTreeWithLazyProp(5);
		s.updateRange(0, 5, 5);
		System.out.println(s.queryRange(0, 6));
		s.updateRange(2, 5, 5);
		System.out.println(s.queryRange(0, 6));
		
	}

}
