// --== CS400 Fall 2022 File Header Information ==--
// Name: Amit Diggavi
// Email: diggavi@wisc.edu
// Team: DW
// TA: Surabhi Gupta
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.LinkedList;


/**
 * Red-Black Tree implementation with a Node inner class for representing
 * the nodes of the tree. Currently, this implements a Binary Search Tree that
 * we will turn into a red black tree by modifying the insert functionality.
 * In this activity, we will start with implementing rotations for the binary
 * search tree insert algorithm. You can use this class' insert method to build
 * a regular binary search tree, and its toString method to display a level-order
 * traversal of the tree.
 */
public class RedBlackTree<T extends Comparable<T>> implements SortedCollectionInterface<T> {

    /**
     * This class represents a node holding a single value within a binary tree
     * the parent, left, and right child references are always maintained.
     */
    protected static class Node<T> {
        public T data;
        public Node<T> parent; // null for root node
        public Node<T> leftChild;
        public Node<T> rightChild;

        public int blackHeight = 0;



        public Node(T data) {
            this.data = data;
            blackHeight = 0;
        }

        /**
         * @return true when this node has a parent and is the left child of
         * that parent, otherwise return false
         */
        public boolean isLeftChild() {
            return parent != null && parent.leftChild == this;
        }

    }

    protected Node<T> root; // reference to root node of tree, null when empty
    protected int size = 0; // the number of values in the tree

    /**
     * Performs a naive insertion into a binary search tree: adding the input
     * data value to a new node in a leaf position within the tree. After
     * this insertion, no attempt is made to restructure or balance the tree.
     * This tree will not hold null references, nor duplicate data values.
     *
     * @param data to be added into this binary search tree
     * @return true if the value was inserted, false if not
     * @throws NullPointerException     when the provided data argument is null
     * @throws IllegalArgumentException when the newNode and subtree contain
     *                                  equal data references
     */
    public boolean insert(T data) throws NullPointerException, IllegalArgumentException {
        // null references cannot be stored within this tree
        if (data == null) throw new NullPointerException(
                "This RedBlackTree cannot store null references.");

        Node<T> newNode = new Node<>(data);
        newNode.blackHeight = 0;
        if (root == null) {
            root = newNode;
            size++;
            root.blackHeight = 1;
            return true;
        } // add first node to an empty tree
        else {
            boolean returnValue = insertHelper(newNode, root); // recursively insert into subtree
            if (returnValue) size++;
            else throw new IllegalArgumentException(
                    "This RedBlackTree already contains that value.");
            root.blackHeight = 1;
            return returnValue;
        }
    }

    /**
     * Recursive helper method to find the subtree with a null reference in the
     * position that the newNode should be inserted, and then extend this tree
     * by the newNode in that position.
     *
     * @param newNode is the new node that is being added to this tree
     * @param subtree is the reference to a node within this tree which the
     *                newNode should be inserted as a descenedent beneath
     * @return true is the value was inserted in subtree, false if not
     */
    private boolean insertHelper(Node<T> newNode, Node<T> subtree) {
        int compare = newNode.data.compareTo(subtree.data);
        // do not allow duplicate values to be stored within this tree
        if (compare == 0) return false;

            // store newNode within left subtree of subtree
        else if (compare < 0) {
            if (subtree.leftChild == null) { // left subtree empty, add here
                subtree.leftChild = newNode;
                newNode.parent = subtree;
                enforceRBTreePropertiesAfterInsert(newNode);
                return true;
                // otherwise continue recursive search for location to insert
            } else return insertHelper(newNode, subtree.leftChild);
        }

        // store newNode within the right subtree of subtree
        else {
            if (subtree.rightChild == null) { // right subtree empty, add here
                subtree.rightChild = newNode;
                newNode.parent = subtree;
                enforceRBTreePropertiesAfterInsert(newNode);
                return true;
                // otherwise continue recursive search for location to insert
            } else return insertHelper(newNode, subtree.rightChild);
        }
    }

    protected void enforceRBTreePropertiesAfterInsert(Node<T> child) {
        // if the root of the tree happens to be red, we can switch it to black without violating any other property.
        if (root.blackHeight == 0) {
            root.blackHeight = 1;
        }


        if (child.parent != null) {


            if (child.parent.blackHeight == 0) // if always red
            {

                Node<T> grandparent = child.parent.parent;
                Node<T> parent = child.parent;
                if (grandparent == null) {
                    return;
                }
                int uncleBlackHeight = uncleBlackHeight(child);

                if (uncleBlackHeight == 0 && grandparent.leftChild != null && grandparent.rightChild != null) {  //if the uncle is red and not null we can just recolor.
                    // I couldn't understand why the setColor wasn't working here, so I'm just doing this.
                    grandparent.rightChild.blackHeight = 1;
                    grandparent.leftChild.blackHeight = 1;


                    grandparent.blackHeight = 0;
                    enforceRBTreePropertiesAfterInsert(grandparent);
                } else if (uncleBlackHeight == 1) // This would be for a case where the uncle's color is black. in this case we do a rotate and a color swap.
                {

                    if (child.isLeftChild() != parent.isLeftChild()) {
                        rotate(child, parent);
                        parent = child;
                    }


                    setColor(parent, grandparent);
                    rotate(parent, grandparent);

                }
            }
        }
    }



    // helper to get the black height of the uncle of a child.
    private int uncleBlackHeight(Node<T> child)
    {

        int uncleHeight = 1;
        if(child.parent.parent == null)
        {
            return uncleHeight;
        }
        else if (!child.parent.isLeftChild() && child.parent.parent.leftChild != null ) {

            uncleHeight = child.parent.parent.leftChild.blackHeight;
        }
        else if (!child.parent.isLeftChild() && child.parent.parent.rightChild != null ) {

            uncleHeight = child.parent.parent.rightChild.blackHeight;
        }
        return uncleHeight;
    }


    // This is a helper method to set the correct color, or in other words, swap colors.
    private void setColor(Node<T> node, Node<T> node1)
    {
        int change = node.blackHeight;
        node.blackHeight = node1.blackHeight;
        node1.blackHeight = change;
    }

    /*
    public void remove(Node<T> child)
    {
        Node<T> node = root;

    }

     */




    /**
     * Performs the rotation operation on the provided nodes within this tree.
     * When the provided child is a leftChild of the provided parent, this
     * method will perform a right rotation. When the provided child is a
     * rightChild of the provided parent, this method will perform a left rotation.
     * When the provided nodes are not related in one of these ways, this method
     * will throw an IllegalArgumentException.
     *
     * @param child  is the node being rotated from child to parent position
     *               (between these two node arguments)
     * @param parent is the node being rotated from parent to child position
     *               (between these two node arguments)
     * @throws IllegalArgumentException when the provided child and parent
     *                                  node references are not initially (pre-rotation) related that way
     */
    private void rotate(Node<T> child, Node<T> parent) throws IllegalArgumentException {
        if(parent == null || parent.leftChild != child && parent.rightChild != child)
        {
            throw new IllegalArgumentException("No connection to the parent");
        }
        else if(!child.isLeftChild()) // checks if it is the right child, if so it does left rotation
        {
            parent.rightChild = child.leftChild;
            if(child.leftChild != null)
            {
                child.leftChild.parent = parent;
            }
            child.parent = parent.parent;
            if(parent.parent == null) // checks if there is a grandparent; child node is assigned to the root if it enters.
            {
                this.root = child;
            }
            else if(parent == parent.parent.leftChild)
            {
                parent.parent.leftChild = child;
            }
            else
            {
                parent.parent.rightChild = child;
            }
            child.leftChild = parent;
            parent.parent = child;
        }
        else
        {
            // now we do the right rotation
            parent.leftChild = child.rightChild;
            if(child.rightChild != null)
            {
                child.rightChild.parent = parent;
            }
            child.parent = parent.parent;
            if(parent.parent == null) // checks if there is a grandparent; child node is assigned to the root if it enters.
            {
                this.root = child;
            }
            else if(parent == parent.parent.rightChild)
            {
                parent.parent.rightChild = child;
            }
            else
            {
                parent.parent.leftChild = child;
            }
            child.rightChild = parent;
            parent.parent = child;
        }
    }

    /**
     * Get the size of the tree (its number of nodes).
     * @return the number of nodes in the tree
     */
    public int size() {
        return size;
    }

    /**
     * Method to check if the tree is empty (does not contain any node).
     * @return true of this.size() return 0, false if this.size() > 0
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Checks whether the tree contains the value *data*.
     * @param data the data value to test for
     * @return true if *data* is in the tree, false if it is not in the tree
     */
    public boolean contains(T data) {
        // null references will not be stored within this tree
        if(data == null) throw new NullPointerException(
                "This RedBlackTree cannot store null references.");
        return this.containsHelper(data, root);
    }

    /**
     * Recursive helper method that recurses through the tree and looks
     * for the value *data*.
     * @param data the data value to look for
     * @param subtree the subtree to search through
     * @return true of the value is in the subtree, false if not
     */
    private boolean containsHelper(T data, Node<T> subtree) {
        if (subtree == null) {
            // we are at a null child, value is not in tree
            return false;
        } else {
            int compare = data.compareTo(subtree.data);
            if (compare < 0) {
                // go left in the tree
                return containsHelper(data, subtree.leftChild);
            } else if (compare > 0) {
                // go right in the tree
                return containsHelper(data, subtree.rightChild);
            } else {
                // we found it :)
                return true;
            }
        }
    }


    /**
     * This method performs an inorder traversal of the tree. The string
     * representations of each data value within this tree are assembled into a
     * comma separated string within brackets (similar to many implementations
     * of java.util.Collection, like java.util.ArrayList, LinkedList, etc).
     * Note that this RedBlackTree class implementation of toString generates an
     * inorder traversal. The toString of the Node class class above
     * produces a level order traversal of the nodes / values of the tree.
     * @return string containing the ordered values of this tree (in-order traversal)
     */
    public String toInOrderString() {
        // generate a string of all values of the tree in (ordered) in-order
        // traversal sequence
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");
        sb.append(toInOrderStringHelper("", this.root));
        if (this.root != null) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(" ]");
        return sb.toString();
    }

    private String toInOrderStringHelper(String str, Node<T> node){
        if (node == null) {
            return str;
        }
        str = toInOrderStringHelper(str, node.leftChild);
        str += (node.data.toString() + ", ");
        str = toInOrderStringHelper(str, node.rightChild);
        return str;
    }

    /**
     * This method performs a level order traversal of the tree rooted
     * at the current node. The string representations of each data value
     * within this tree are assembled into a comma separated string within
     * brackets (similar to many implementations of java.util.Collection).
     * Note that the Node's implementation of toString generates a level
     * order traversal. The toString of the RedBlackTree class below
     * produces an inorder traversal of the nodes / values of the tree.
     * This method will be helpful as a helper for the debugging and testing
     * of your rotation implementation.
     * @return string containing the values of this tree in level order
     */
    public String toLevelOrderString() {
        String output = "[ ";
        if (this.root != null) {
            LinkedList<Node<T>> q = new LinkedList<>();
            q.add(this.root);
            while(!q.isEmpty()) {
                Node<T> next = q.removeFirst();
                if(next.leftChild != null) q.add(next.leftChild);
                if(next.rightChild != null) q.add(next.rightChild);
                output += next.data.toString();
                if(!q.isEmpty()) output += ", ";
            }
        }
        return output + " ]";
    }

    public String toString() {
        return "level order: " + this.toLevelOrderString() +
                "\nin order: " + this.toInOrderString();
    }

    /*
    /**
     * tests to see if the inserted node is the inner grandchild, and parent is red, and uncle is black.

    @Test
    public void test1()
    {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(9);
        tree.insert(8);
        tree.insert(10);
        assertEquals(0, tree.root.rightChild.leftChild.blackHeight);
        assertEquals(0, tree.root.rightChild.rightChild.blackHeight);
        assertEquals(1, tree.root.rightChild.blackHeight);
    }

    /**
     *  tests to see if the parent is red and the root is red

    @Test
    public void test2()
    {
        RedBlackTree rbt = new RedBlackTree();
        rbt.insert(17);
        rbt.insert(19); // 17 is root and 19 is inserted

        assertEquals(0, rbt.root.rightChild.blackHeight);
        assertEquals(1, rbt.root.blackHeight);
    }

    /**
     *  tests to see if the parent and uncle nodes are red

    @Test
    public void test3()
    {
        RedBlackTree rbt = new RedBlackTree();

        rbt.insert(45);
        rbt.insert(26);
        rbt.insert(72);
        rbt.insert(32);

        System.out.println(rbt);
        // assertEquals(1, rbt.root.rightChild.leftChild.blackHeight);
        // assertEquals(1, rbt.root.rightChild.rightChild.blackHeight);


    }
    */
}