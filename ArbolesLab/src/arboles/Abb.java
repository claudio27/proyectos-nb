package arboles;

/**
 *
 * @author claudio
 */
public class Abb {
// Root node pointer. Will be null for an empty tree.
private Node root;
/*
--Node--
The binary tree is built using this nested node class.
Each node stores one data element, and has left and right
sub-tree pointer which may be null.
The node is a "dumb" nested class -- we just use it for
storage; it does not have any methods.
*/
private static class Node {
Node left;
Node right;
String data;
int cantidad;


Node(String newData) {
left = null;
right = null;
data = newData;
cantidad = 1;
}
}

/**
Creates an empty binary tree -- a null root pointer.
*/
public void BinaryTree() {
root = null;
}


/**
Returns true if the given target is in the binary tree.
Uses a recursive helper.
*/
public boolean lookup(String data) {
return(lookup(root, data));
}
/**
Recursive lookup -- given a node, recurp21
down searching for the given data.
*/
private boolean lookup(Node node, String data) {
if (node==null) {
return(false);
}
if (data.equals(node.data) ){
return(true);
}
else if ((data.compareToIgnoreCase(node.data)) > 0) {

    return(lookup(node.right, data));
}
else {
return(lookup(node.left, data));
}
}
/**
Inserts the given data into the binary tree.
Uses a recursive helper.
*/
public void insert(String data) {
root = insert(root, data);
}
/**
Recursive insert -- given a node pointer, recur down and
insert the given data into the tree. Returns the new
node pointer (the standard way to communicate
a changed pointer back to the caller).
*/
private Node insert(Node node, String data) {
 if (node==null) {
      node = new Node(data);
    }
    else {


      if ((data.compareToIgnoreCase(node.data)) > 0)  {
          node.right = insert(node.right, data);
      }
      else if((data.compareToIgnoreCase(node.data)) == 0){
         node.cantidad++;
         }
     else{

          node.left = insert(node.left, data);
      }
    }

    return(node);
}

/**
Prints the node values in the "inorder" order.
Uses a recursive helper to do the traversal.
*/
public void printTree() {
printTree(root);
System.out.println();
}
private void printTree(Node node) {
if (node == null) return;
// left, node itself, right
printTree(node.left);
System.out.print(node.data +" ");
printTree(node.right);

}


}
