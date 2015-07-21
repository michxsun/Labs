import junit.framework.TestCase;


public class BinarySearchTreeTest extends TestCase {
	
	public void testAddandContains() {
		// construct the tree 
		BinarySearchTree t = new BinarySearchTree();
		t.add("C");
		t.add("A");
		t.add("B");
		t.add("E");
		t.add("D");
		
		// print the tree to see it
		System.out.println("Printing in order");
		t.printInorder();
		System.out.println();
		System.out.println("Printing in preorder");
		t.printPreorder();
		
		// check that contains works 
		char[] contents = {'C', 'A', 'B', 'E', 'D'};
		for (int i=0; i<5; i++) {
			System.out.println();
			System.out.println(contents[i]);							// print out the char just to make sure
			boolean print = t.contains(contents[i]);					// print out if the character exists, should be true for each cse
			System.out.println(print);
		}
		
	}
}
