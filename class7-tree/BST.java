public class BST {

    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            this.value = value;
        }
    }

    private TreeNode root;

    public void insert(int key) {
        if(root == null) {
            root = new TreeNode(key);
            return;
        }
        TreeNode current = root;
        TreeNode parent = null;
        while(true) {
            parent = current;
            if(key < parent.value) {
                current = parent.left;
                if(current == null) {
                    parent.left = new TreeNode(key);
                    return;
                }
            } else if (key > parent.value){
                current = parent.right;
                if(current == null) {
                    parent.right = new TreeNode(key);
                    return;
                }
            } else {
                return; // BST does not allow nodes with the same value
            }
        }
    }

    public TreeNode get(int key) {
        TreeNode current = root;
        while(current != null && current.value != key) {
            if (key < current.value) {
                current = current.left;
            } else if (key > current.value) {
                current =current.right;
            }
        }
        return current == null ? null : current;
    }

    public boolean delete(int key) {
        TreeNode parent = root;
        TreeNode current = root;
        boolean isLeftChild = false;
        while(current != null && current.value != key) {
            parent = current;
            if(current.value  > key) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
        }
        if(current == null) {
            return false;
        }
        // Case 1: if node to be deleted has no children
        if(current.left == null && current.right == null) {
            if(current == root) {
                root = null;
            } else if(isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        // Case 2: if node to be deleted has only one child
        } else if (current.right == null) {
            if(current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if(current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        // Case 3: current.left != null && current.right != null
        } else {
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode successor = null;
        TreeNode successorParent = null;
        TreeNode current = node.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != node.right) {
            successorParent.left= successor.right;
            successor.right = node.right;
        }
        return successor;
    }
}
