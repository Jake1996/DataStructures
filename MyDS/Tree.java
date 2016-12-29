package MyDS;
import java.util.ArrayList;

public class Tree<T> {
	private TreeNode<T> root;
	public Tree() {
		
	}
	public boolean add(T data) {
		if(root==null) {
			root = new TreeNode<T>();
			root.setData(data);
			return true;
		}
		else {
			return root.insertChild(data);
		}
	}
	
	public TreeNode<T> getChild(T val) {
		return root.getChild(val);
	}
	public boolean contains(T val) {
		return root.contains(val);
	}

}

class TreeNode<T> {
	private ArrayList<TreeNode<T>> children;
	private T data;
	public TreeNode() {
		children = new ArrayList<>();
	}
	public ArrayList<TreeNode<T>> getChildren() {
		return children;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public boolean contains(T val) {
		for(int i =0;i<children.size();i++) {
			if(children.get(i).data.equals(val))
				return true;
		}
		return false;
	}
	public TreeNode<T> getChild(T val) {
		for(int i =0;i<children.size();i++) {
			if(children.get(i).data.equals(val))
				return children.get(i);
		}
		return null;
	}
	public boolean insertChild(T val) {
		if(!this.contains(val)) {
			TreeNode<T> t = new TreeNode<T>();
			t.data = val;
			children.add(t);
			return true;
		}
		return false;
	}
}


