import java.util.Scanner;

import MyDS.Trie;

public class TrieTester {

	public static void main(String[] args) {
		Trie obj = new Trie();
//		obj.add("Jatin");
//		obj.add("Jat");
//		obj.add("Jake");
//		obj.add("apple");
//		System.out.println(obj.contains("Jake"));
//		System.out.println(obj.contains("Ja"));
//		System.out.println(obj.contains("apple"));
//		System.out.println(obj.contains("Jail"));
//		System.out.println(obj.containsPrefix("Ja"));	
//		obj.addSuffix("apple");
//		System.out.println(obj.containsPrefix("pp"));
		Scanner in = new Scanner(System.in);
		String t;
		t = in.next();
		while(in.hasNext()) {
			t= in.next();
			obj.add(t);
			System.out.println(t);
		}
		in.close();
		System.out.print("DONE");
		
	}

}
