// https://www.geeksforgeeks.org/problems/populate-inorder-successor-for-all-nodes/1

/*
class Node {
    int data;
    Node left, right,next;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public void populateNext(Node root) {
        // code here

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        Map<Integer, Node> map = new HashMap<>();
        List<Node> inorder = new ArrayList<>();

        populateInorder(root, inorder);

        Node successor = null;
        for (int i=inorder.size()-1; i>=0; i--) {
            map.put(inorder.get(i).data, successor);
            successor = inorder.get(i);
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            
            curr.next = map.get(curr.data);

            if (curr.left != null) {
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }

    }

    private void populateInorder(Node node, List<Node> inorder) {
        if(node == null) {
            return;
        }

        populateInorder(node.left, inorder);
        inorder.add(node);
        populateInorder(node.right, inorder);
    }
}
