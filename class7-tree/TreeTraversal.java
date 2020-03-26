public class TreeTraversal {

public static void inOrderTraversal(BST.TreeNode root) {
    if(root == null) {
        return;
    }
    inOrderTraversal(root.left);
    System.out.println(root.value);
    inOrderTraversal(root.right);
}

public static void preOrderTraversal(BST.TreeNode root) {
    if(root == null) {
        return;
    }
    System.out.println(root.value);
    preOrderTraversal(root.left);
    preOrderTraversal(root.right);
}

public static void postOrderTraversal(BST.TreeNode root) {
    if(root == null) {
        return;
    }
    postOrderTraversal(root.left);
    postOrderTraversal(root.right);
    System.out.println(root.value);
}
}
