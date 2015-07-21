


public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
	
	// shouldn't have any instance variables 
	
	
	/**
	 * Method that returns true/false depending if given item exists in the tree
	 * 
	 * @param key		item that we are looking for 
	 * @return			recursively returns contains on left or right child depending on compare result 
	 */
	public boolean contains(T key) {
		return contains(myRoot, key);
	}
	
    /** 
     * Contains method.
     * @param t 			argument Treenode for which we check its item
     * @param key			item we are searching for 
     * @return				recursively return searches on the children of t as necessary
     */
    private boolean contains (TreeNode t, T key) {
    	if (t == null) {
    		return false;
    	} else if (t.myItem == key) {
    		return true;
    	} else if (key.compareTo(t.myItem) < 0) {
    		return contains(t.myLeft , key);
    	} else {
    		return contains(t.myRight, key);
    	}
    }
	
	/**
	 * Method that takes a comparable object and adds it to the tree if it doesn't exist 
	 * @param key		item that will potentially be added
	 */
	public void add(T key) {
		myRoot = add(myRoot, key);
	}
	
	private TreeNode add(TreeNode t, T key) {
		if (t == null) {
			return new TreeNode(key);
		} else if (key.compareTo(t.myItem) < 0) {
			t.myLeft = add(t.myLeft, key);
			return t;
		} else {
			t.myRight = add(t.myRight, key);
			return t;
		}
	}
}