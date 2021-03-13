package BinarySearchTree;

public class BinarySearchTree {

   public class Node{
      String value;
      int key;
      Node left, right;

         //Constructor
         public Node(int key, String value){
            this.key = key;
            this.value = value;
         }

   }

   Node root;
   //Constructor for binary tree
   public BinarySearchTree(){
      root = null;
   }

   //FIND
   public String find(int key){
      //First find node
      Node node = find(root, key);

      //Then return the value
      return node == null? "Is not found": node.value;
   } 

   //recursively find the node
   public Node find(Node node, int key) {
      if(node.key == key || node == null) //Base Case: if key match or null
         return node;
      else if(key > node.key)             //if key >, search on the right subtree.
         return find(node.right, key);
      else                                //if key <, search on the left subtree.
         return find(node.left, key);
      // Note: Duplicate keys aren't allowed (so we don't need to check for that)
   }

   //Insert
   public void insert(int key, String value){
      root = insertItem(root, key, value);
   }

   public Node insertItem(Node node, int key, String value) {
      //Create the new node.
      Node newNode = new Node(key, value);

      //If null, set it here. 
      //We are done.
      if(node == null){
         node = newNode;
         return node;
      }

      //Else 
      //Find until you find a node that is null
      //Set it there
      if (key > node.key)
         node.right = insertItem(node.right, key, value);
      else if (key < node.key)
         node.left = insertItem(node.left, key, value);
   
      //We have returned from bottom to our fully constructed tree.
      //We are done!
      return node;
   }

   public static void main(String[] args) {
      BinarySearchTree bst = new BinarySearchTree();
      bst.insert(5, "e");
      bst.insert(3, "c");
      bst.insert(2, "b");
      bst.insert(4, "d");
      bst.insert(7, "g");
      bst.insert(6, "f");
      bst.insert(8, "h");
      
      System.out.println(bst.find(5)); //e
      System.out.println(bst.find(3)); //c
      System.out.println(bst.find(2)); //b
      System.out.println(bst.find(4)); //d
      System.out.println(bst.find(7)); //g
      System.out.println(bst.find(6)); //f
      System.out.println(bst.find(8)); //h
      //System.out.println(bst.find(10000)); //null

   }
}
