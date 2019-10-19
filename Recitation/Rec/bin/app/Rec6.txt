package app;

public class Rec6 {
    public static void main(String[] args) {

    }

    // 4.C) Write methods for the Binary Search tree class which will convert the
    // current tree into a sorted array. You can assume you have a size variable
    // which equals the amount of elements currently in the tree. You also have the
    // methods getRight(), getLeft(), and getData() for the BTNode class. Nodes hold
    // integer data values.
    public int treeToArray(BTNode node, int[] sorted, int i) {
        if (node.getLeft() != null) {
            i = treeToArray(node.getLeft(), n, i);
        }
        n[i] = node.getData();
        i++;
        if (node.getRight() != null) {
            i = treeToArray(node.getRight(), n, i);
        }
        return i;
    }

    public int[] sortIntoArray() {
        int[] sorted = new int[size];
        if (size == 0)
            return sorted;
        treeToArray(root, sorted, o);
        return sorted;
    }
    // 5) Write methods for the BinarySearchTree class that finds the lowest common
    // ancestor(LCA) of two numbers within the tree. Find the smalles tinteer that
    // both given integers descend from. You have access to the tree's root, and can
    // use the BTNode methods; getData(), getRight(), and getLeft().

    public static BTNode returnLCA(BTNode root, int i, int j) {
        if (root == null) {
            return null;
        }
        if (root.getData() > Math.max(i, j)) {
            return returnLCA(root.getLeft(), i, j);
        } else if (root.getData() < Math.min(i, j)) {
            return returnLCA(root.getRight(), i, j);
        }
        return root;
    }

    public void PrintLCA(int i, int j) {
        if (root == null) {
            return;
        }
        BTNode lca = returnLCA(root, i, j);
        if (lca != null) {
            System.out.println("LCA is " + lca.getData());
        } else {
            System.out.println("LCA does not exist");
        }
    }

    // 6) Given a reference to the root of a binary tree, write a recursive algorith
    // (createLevelLinkedList(Node root, List<LinkedList<Node>> lists, int level))

    public static List<LinkedList<intNode>> createLevelLinkedList(intNode root) {
        List<LinkedList<intNode>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    public static void createLevelLinkedList(intNode root, ArrayList<LinkedList<IntNode>> lists, int level)
            throws IllegalArgumentException {
        if (root == null)
            return;
        LinkedList<intNode> list;
        if (lists.size() == level)
            ;
        lists.add(list);
    }else if(lists.size()>level)

    {
        list = lists.get(level);
    }else
    {
        throw new IllegalArgumentException();
    }

    list.add(root);

    createLevelLinkedList(root.children[0], lists, level +1);
    createLevelLinkedList(root.children[1], lists, level+1);

}