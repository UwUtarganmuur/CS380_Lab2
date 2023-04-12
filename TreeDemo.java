package cs380_lab2;

/**
 * Class represents a node in a BST
 */
class Node{
	   int value;
	   Node left, right;
	   
	   /**
	     * Constructor for Node class
	     * @param value The value of the node
	     */
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}
/**
 * BST class
 */
class BinarySearchTree{

	   Node root;
	   
	   
	   /**
	     * Inserting values into the Binary Search Tree using a recursive method
	     * @param root The root of the BST
	     * @param value The value to insert
	     * @return root The root of BST after insertion
	     */
	   public Node insert(Node root, int value){
	      //base case
	      if(root == null){
	         root = new Node(value);
	         return root;
	      }
	      //recursive step
	      if(value < root.value){
	         root.left = insert(root.left, value); 
	      }else{
	         root.right = insert(root.right, value);
	      }
	      
	      return root;
	   }
	   
	   
	   
	   /**
	     * Pre-order traversal of BST
	     * @param root The root of the BST
	     */
	   public void preOrderTraversal(Node root){
	      //implement me
	        if (root != null) {
	            System.out.print(root.value + " ");
	            preOrderTraversal(root.left);
	            preOrderTraversal(root.right);
	        }
	    
	   }

	   
	   /**
	     * Pre-order traversal of BST
	     * @param root The root of the BST
	     */
	   public void inOrderTraversal(Node root){
	      //implement me
		   if (root != null) {
	            inOrderTraversal(root.left);
	            System.out.print(root.value + " ");
	            inOrderTraversal(root.right);
	        }		   
	   }
	   
	   
	   
	   /**
	     * Post-order traversal of BST
	     * @param root The root of the BST
	     */
	   public void postOrderTraversal(Node root){
	      //implement me
	        if (root != null) {
	            postOrderTraversal(root.left);
	            postOrderTraversal(root.right);
	            System.out.print(root.value + " ");
	        }

	   }
	   
	   
	   /**
	     * Find a specific value node in BST
	     * @param root The root of the BST
	     * @param key Search the value
	     * @return true if the value is found
	     */
	   public boolean find(Node root, int key){
		  //implement me
	        if (root == null) {
	            return false;
	        }
	        if (root.value == key) {
	            return true;
	        } else if (key < root.value) {
	            return find(root.left, key);
	        } else {
	            return find(root.right, key);
	        }          
	   }
	   
	   
	   
	   /**
	     * Find the smallest key node in BST
	     * @param root The root of BST
	     * @return The smallest key value 
	     * @throws IllegalArgumentException if BST is empty
	     */
	   public int getMin(Node root){
	      //implement me
		   if (root == null) {
	            throw new IllegalArgumentException("Tree is empty");
	        } else if (root.left == null) {
	            return root.value;
	        } else {
	            return getMin(root.left);
	        }
	   }
	  
	  
	  
	   /**
	     * Find the largest key node BST
	     * @param root The root of BST
	     * @return The largest key value 
	     * @throws IllegalArgumentException if BST is empty
	     */
	   public int getMax(Node root){
		  //implement me
		   if (root == null) {
	            throw new IllegalArgumentException("Tree is empty");
	        } else if (root.right == null) {
	            return root.value;
	        } else {
	            return getMax(root.right);
	        }
	   }

	   /**
	     * Inserts a node with the given value into the tree
	     *
	     * @param value Inserts the value
	     */
    public void insert(int value) {
        // tree is empty
        if (root == null) {
            root = new Node(value);
            return;
        } else {
            Node current = root;
            Node parent = null;

            while (true) {
                parent = current;

                if (value < current.value) {
                    current = current.left;
                    if (current == null) {
                        parent.left = new Node(value);
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = new Node(value);
                        return;
                    }
                }

            }
        }
    }
	   
    /**
     * Deletes a node with the given key
     *
     * @param root The root of the subtree to delete from
     * @param key  Deletes key of the node
     * @return Updates root of the subtree
     */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}


    /**
     * Demo class for testing the BinarySearchTree class
     */
	public class TreeDemo{
		 /**
	     * Shows BST operations
	     * @param args the command line arguments
	     */
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert(24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	           
	      
	   }  
}
