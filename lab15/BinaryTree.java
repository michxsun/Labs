import java.util.ArrayList;

public class BinaryTree {

    private TreeNode myRoot;
    private ArrayList alreadySeen;

    public BinaryTree() {
        myRoot = null;
    }

    public BinaryTree(TreeNode t) {
        myRoot = t;
    }
    
    public int height() {
    	if (myRoot != null) {
    		return myRoot.height();
    	}
    	return 0;
    }
    
    public boolean isCompletelyBalanced() {
    	if (myRoot != null) {
    		return myRoot.isBalanced();
    	}
    	return true;
    }

    // Print the values in the tree in preorder: root value first,
    // then values in the left subtree (in preorder), then values
    // in the right subtree (in preorder).
    public void printPreorder() {
        if (myRoot == null) {
            System.out.println("(empty tree)");
        } else {
            myRoot.printPreorder();
            System.out.println();
        }
    }

    // Print the values in the tree in inorder: values in the left
    // subtree first (in inorder), then the root value, then values
    // in the right subtree (in inorder).
    public void printInorder() {
        if (myRoot == null) {
            System.out.println("(empty tree)");
        } else {
            myRoot.printInorder();
            System.out.println();
        }
    }

    public void fillSampleTree1() {
        myRoot = new TreeNode("a", new TreeNode("b"), new TreeNode("c"));
    }

    public void fillSampleTree2() {
        myRoot = new TreeNode("a", new TreeNode("b", new TreeNode("d",
                new TreeNode("e"), new TreeNode("f")), null), new TreeNode("c"));
    }
    
    public void fillSampleTree3() {
    	myRoot = new TreeNode("a", new TreeNode("b"), new TreeNode("c",
    			new TreeNode("d", new TreeNode("e"), new TreeNode("f")), null));
    }
    
    public void fillSampleTree4() {
    	myRoot = new TreeNode("a", new TreeNode("b",new TreeNode("d", 
    			new TreeNode("e"), new TreeNode("f")), new TreeNode("d", 
    			new TreeNode("e"), new TreeNode("f"))), new TreeNode("c",
    			new TreeNode("d", new TreeNode("e"), new TreeNode("f")), 
    			new TreeNode("d", new TreeNode("e"), new TreeNode("f"))));
    }

    public static void main(String[] args) {
        BinaryTree t;
        t = new BinaryTree();
//        print(t, "the empty tree");
//        t.fillSampleTree1();
//        print(t, "sample tree 1");
//        t.fillSampleTree2();
//        print(t, "sample tree 2");
//        t.fillSampleTree3();
//        print(t, "sample tree 3");
//        
//        t.fillSampleTree1();
//        System.out.println(t.height());
//        System.out.println(t.isCompletelyBalanced());
//        t.fillSampleTree2();
//        System.out.println(t.height());
//        System.out.println(t.isCompletelyBalanced());
//        t.fillSampleTree3();
//        System.out.println(t.height());
//        System.out.println(t.isCompletelyBalanced());
//        t.fillSampleTree4();
//        System.out.println(t.height());
//        System.out.println(t.isCompletelyBalanced());
//        System.out.println();
//        t.fillSampleTree3();
//        t.print();
        t.fillSampleTree4();
        System.out.println(t.check());
        
        
        
    }

    private static void print(BinaryTree t, String description) {
        System.out.println(description + " in preorder");
        t.printPreorder();
        System.out.println(description + " in inorder");
        t.printInorder();
        System.out.println();
    }
    
    public void print() {
        if (myRoot != null) {
            myRoot.print(0);
        }
    }
    
    public boolean check() {
    	alreadySeen = new ArrayList();
    	try {
    		isOK(myRoot);
    		return true;
    	} catch (IllegalStateException e) {
    		return false;
    	}
    }
    
    private void isOK(TreeNode t) throws IllegalStateException {
    	if (alreadySeen.contains(t.myItem)) {
    		throw new IllegalStateException();
    	} else {
    		alreadySeen.add(t.myItem);
    		if (t.myLeft != null) {
    			isOK(t.myLeft);
    		}
    		if(t.myRight != null) {
    			isOK(t.myRight);
    		}
    	}
    }
    
    public static BinaryTree fibTree(int n) {
    	BinaryTree result = new BinaryTree();
    	result.myRoot = result.fibTreeHelper(n);
    	return result;
    }
    
    private TreeNode fibTreeHelper(int n) {
    	if (n == 0) {
    		return new TreeNode(0);
    	} else if (n == 1) {
    		return new TreeNode(1);
    	} else {
    		TreeNode left = fibTreeHelper(n-1);
    		TreeNode right = fibTreeHelper(n-2);
    		return new TreeNode((Integer) left.myItem + (Integer) right.myItem, left, right);
    	}
    }
    
    public static BinaryTree exprTree(String s) {
        BinaryTree result = new BinaryTree();
        result.myRoot = result.exprTreeHelper(s);
        return result;
    }
    
    // Return the tree corresponding to the given arithmetic expression.
    // The expression is legal, fully parenthesized, contains no blanks, 
    // and involves only the operations + and *.
    private TreeNode exprTreeHelper(String expr) {
    	// done initializing operand list 
        if (expr.charAt(0) != '(') {
            return new TreeNode(); // you fill this in
        } else {
            // expr is a parenthesized expression.
            // Strip off the beginning and ending parentheses,
            // find the main operator (an occurrence of + or * not nested
            // in parentheses, and construct the two subtrees.
            int nesting = 0;
            int opPos = 0;
            for (int k = 1; k < expr.length() - 1; k++) {
                // you supply the missing code
            	if (nesting == 0) {										// not nested, look for operands 
            		if (expr.charAt(k) == '+' || expr.charAt(k) == '*') {			// checks if we have an operand 
            			opPos = k;
            		}
            	}
            	if (expr.charAt(k) == "(") {							// entering a nest
            		nesting++;
            	} else if (expr.charAt(k) == ")") {					// exiting a nest 
            		nesting--;
            	}
            }
            String opnd1 = expr.substring(1, opPos);
            String opnd2 = expr.substring(opPos + 1, expr.length() - 1);
            String op = expr.substring(opPos, opPos + 1);
            System.out.println("expression = " + expr);
            System.out.println("operand 1  = " + opnd1);
            System.out.println("operator   = " + op);
            System.out.println("operand 2  = " + opnd2);
            System.out.println();
            return exprTreeHelper(op + opand1 + opand2); // you fill this in
        }
    }

    private static class TreeNode {

        public Object myItem;
        public TreeNode myLeft;
        public TreeNode myRight;
        private static final String indent1 = "    ";

        private void print(int indent) {
            if (myRight != null) {
            	myRight.print(indent+1);
            }
            println (myItem, indent);
            if (myLeft != null) {
            	myLeft.print(indent+1);
            }
        }

        private static void println(Object obj, int indent) {
            for (int k=0; k<indent; k++) {
                System.out.print(indent1);
            }
            System.out.println(obj);
        }

        public TreeNode(Object obj) {
            myItem = obj;
            myLeft = myRight = null;
        }

        public TreeNode(Object obj, TreeNode left, TreeNode right) {
            myItem = obj;
            myLeft = left;
            myRight = right;
        }
        
        public int height() {
        	if (myLeft == null && myRight == null) {
        		return 1;
        	} else {
        		int bestSoFarLeft;
        		int bestSoFarRight;
        		if (myLeft != null) {
            		bestSoFarLeft = 1 + myLeft.height();
        		} else {
        			bestSoFarLeft = 1;
        		}
        		if (myRight != null) {
        			bestSoFarRight = 1 + myRight.height();
        		} else {
        			bestSoFarRight = 1;
        		}
        		int bestSoFar = Math.max(bestSoFarLeft, bestSoFarRight);
            	return bestSoFar;
        	}
        }
        
        public boolean isBalanced() {
        	if (myLeft == null && myRight == null) {
        		return true;
        	} 
        	if (myLeft == null && myRight != null) {
        		return false;
        	}
        	if (myLeft != null && myRight == null) {
        		return false;
        	} else {
        		return (myLeft.height() == myRight.height()) &&(myLeft.isBalanced() && myRight.isBalanced());
        	}
        }

        private void printPreorder() {
            System.out.print(myItem + " ");
            if (myLeft != null) {
                myLeft.printPreorder();
            }
            if (myRight != null) {
                myRight.printPreorder();
            }
        }

        private void printInorder() {
            if (myLeft != null) {
                myLeft.printInorder();
            }
            System.out.print(myItem + " ");
            if (myRight != null) {
                myRight.printInorder();
            }
        }
    }
}
