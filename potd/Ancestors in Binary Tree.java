// https://www.geeksforgeeks.org/problems/ancestors-in-binary-tree/1

/*class Node of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
class Solution {

    public ArrayList<Integer> Ancestors(Node root, int target) {
        // add your code here
        ArrayList<Integer> ancestors = new ArrayList<>();

        if (root == null || root.data == target) {
            return ancestors;
        }

        findNode(root, target, ancestors);

        return ancestors;
    }

    private boolean findNode(Node node, int target, ArrayList<Integer> ancestors) {
        if (node == null) {
            return false;
        }
        if (node.data == target) {
            return true;
        }
        if (findNode(node.left, target, ancestors) || findNode(node.right, target, ancestors)) {
            ancestors.add(node.data);
            return true;
        }
        return false;
    }
}
