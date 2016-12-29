import MyDS.SegmentTree;

public class STTester {

	public static void main(String[] args) {
		long arr[] = {1,2,3,4,5};
		SegmentTree obj = new SegmentTree(5);
		obj.create(arr, 0, 4, 0);
//		for(int i=0;i<obj.ST.length;i++) System.out.println(obj.ST[i]);
		obj.updateSTRange(0,4, 1, 0, 4, 0);
		System.out.println(obj.rangeSumQuery(2, 4, 0, 4, 0));
		
	}

}
