import MyDS.BinaryIndexedTree;

public class BITTester {

	public static void main(String[] args) {
		long arr[] = {3,8,-2,7,4,1,2,6,4,3,-5,-2};
//		long arr1[] = new long[10000];
		BinaryIndexedTree obj = new BinaryIndexedTree(13);
//		for(int i=0;i<10000;i++) {
//			arr1[i] = (i*34+8)%1000;
//		}
//		BinaryIndexedTree obj1 = new BinaryIndexedTree(10005);
//		long t1 = System.nanoTime();
//		obj.constructBITTree(arr1);
//		long t2 = System.nanoTime();
//		obj1.create(arr1);
//		long t3 = System.nanoTime();
//		System.out.println(t2-t1);
//		System.out.println(t3-t2);
//		boolean flag = true;
//		for(int i=1;i<=10000;i++) {
//			if(obj.BIT[i]!=obj1.BIT[i]) {
//				flag = false; break;
//			}
//		}
//		System.out.println(flag);
		obj.create(arr);
		System.out.println(obj.getRangeSum(8,8));
		System.out.println(obj.getRangeSum(11,11));
		System.out.println(obj.getSum(0));
		obj.update(5, arr[5], 6);
		System.out.println(obj.getSum(5));
		System.out.println(obj.getSum(5));
		System.out.println(obj.getSum(6));
		System.out.println(obj.getSum(7));
		System.out.println(obj.getRangeSum(6,10));
		System.out.println(obj.getSum(4));
		System.out.println(obj.getRangeSum(7,8));
		System.out.println(obj.getRangeSum(0,10));
		System.out.println(obj.getRangeSum(0,8));
		
	}

}
