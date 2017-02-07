package MyDS;

public class SegmentTreeWithLazyProp {
	public long ST[];
	public long lazy[];
	public SegmentTreeWithLazyProp(int size) {
		int len =largestPower(size);
		if(len==size) len = len<<1;
		else len = len<<2;
		ST = new long[len];
		lazy = new long[len];
	}
	public static void main(String args[]) {
		new SegmentTreeWithLazyProp(10000000);
		long arr[] = new long[33554432];
		long arr1[] = new long[33554432];
		long arr2[] = new long[33554432];
	}
	private static int largestPower(int n){
		n = n|(n>>1);
		n = n|(n>>2);
		n = n|(n>>4);
		n = n|(n>>8);
		return (n+1)>>1;
	}
	public long create(long arr[],int start,int end,int curr) {
		if(start==end) {
			ST[curr] = arr[start];
			return ST[curr];
		}
		int mid = (start+end)/2;
		ST[curr] = create(arr,start,mid,2*curr+1) + create(arr,mid+1,end,2*curr+2);
		return ST[curr];
	}
	public long rangeSumQuery(int qlow,int qhigh,int low,int high,int pos) {
		if(qlow<=low&&qhigh>=high) {
			return ST[pos];
		}
		if(qlow>high||qhigh<low) {
			return 0;
		}
		int mid = (low+high)/2;
		return rangeSumQuery(qlow, qhigh, low, mid, 2*pos+1)+rangeSumQuery(qlow, qhigh, mid+1, high, 2*pos+2);
	}
	public void updateST(int index,int delta,int low,int high,int pos) {
		if(index<low||index>high) return;
		if(low==high) {
			ST[pos] += delta;
			return;
		}
		int mid = (low+high)/2;
		updateST(index, delta, low, mid, pos*2+1);
		updateST(index, delta, mid+1, high, pos*2+2);
		ST[pos] = ST[2*pos+1]+ST[2*pos+2];
	}
	public void updateSTRange(int sRange,int eRange,int delta,int low,int high,int pos) {
		if(low>high||sRange>high||eRange<low) return;
		if(low==high) {
			ST[pos] += delta;
			return;
		}
		int mid = (low+high)/2;
		updateSTRange(sRange,eRange, delta, low, mid, pos*2+1);
		updateSTRange(sRange,eRange, delta, mid+1, high, pos*2+2);
		ST[pos] = ST[2*pos+1]+ST[2*pos+2];
	}

}
