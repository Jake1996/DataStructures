package MyDS;

/**
 * @author Jatin
 *
 */
public class BinaryIndexedTree {
	public long BIT[] ;
	public BinaryIndexedTree(int size) {
		BIT = new long[size+1];
	}
	/**
	 * does the construction in o(n) does by making a cumilative array
	 * @param arr the array for the construction of the bittree
	 */
	public void create(long arr[]) {
		for(int i=1;i<arr.length;i++) {
			arr[i]+=arr[i-1];
		}
		for(int i=1,start;i<=arr.length;i++) {
			start = i-(i&-i);
			BIT[i] = start==0?arr[i-1]:arr[i-1]-arr[start-1];
		}
		for(int i=arr.length-1;i>0;i--) {
			arr[i]-=arr[i-1];
		}
	}
	/**
	 * does the construction in o(nlogn)
	 * @param arr the array for the construction of the bittree
	 */
	public void constructBITTree(long arr[]) {
		for(int i=0;i<arr.length;i++) {
			update(i, arr[i]);
		}
	}
	/**
	 * 
	 * @param index the position till where to add elements
	 * @return the cumilative sum of the array uptill index
	 */
	public long getSum(int index) {
		long sum = 0;
		index++;
		while(index!=0) {
			sum+=BIT[index];
			index-=index&(-index);
		}
		return sum;
	}
	/**
	 * 
	 * @param index the position at which change occured
	 * @param oldVal the previous value at that position 
	 * @param newVal the new value at that position
	 */
	public void update(int index,long oldVal,long newVal){
		index++;
		long diff = newVal - oldVal;
		while(index<=BIT.length) {
			BIT[index]+=diff;
			index+=index&(-index);
		}
	}
	/**
	 * 
	 * @param index the position at which the change occured
	 * @param val the change in value
	 */
	public void update(int index,long val){
		index++;
		while(index<=BIT.length) {
			BIT[index]+=val;
			index+=index&(-index);
		}
	}
	/**
	 * 
	 * @param start index from 
	 * @param end index to
	 * @return the sum of elements from start to end mentioned param
	 */
	public long getRangeSum(int start,int end) {
		if(start==0) return getSum(end);
		return getSum(end)-getSum(--start);
	}
}

