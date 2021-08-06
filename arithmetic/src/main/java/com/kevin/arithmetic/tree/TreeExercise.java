package com.kevin.arithmetic.tree;


public class TreeExercise {

    public static void main(String[] args) {
        TreeNode root = initTree();

        System.out.print("前序遍历： ");
        firstTraversal(root);
        System.out.println();

        System.out.print("中序遍历： ");
        centerTraversal(root);
        System.out.println();

        System.out.print("后序遍历： ");
        endTraversal(root);
        System.out.println();

        // 给定前序 和中序遍历，输出后续遍历
        int[] first = new int[]{10, 7, 4, 1, 5, 9, 8, 18, 14, 22};
        int[] center = new int[]{1, 4, 5, 7, 8, 9, 10, 14, 18, 22};

    }

    private static void end(int[] first, int[] center) {

    }

    private static void firstTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " , ");

        firstTraversal(node.left);

        firstTraversal(node.right);
    }

    private static void centerTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        centerTraversal(node.left);

        System.out.print(node.val + " , ");

        centerTraversal(node.right);
    }

    private static void endTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        endTraversal(node.left);

        endTraversal(node.right);

        System.out.print(node.val + " , ");
    }

    /**
     *
     *                  10
     *             7          18
     *          4     9    14   22
     *        1   5  8
     * @return
     */
    private static TreeNode initTree() {
        TreeNode rootTree = new TreeNode(10);
        TreeNode tree1 = new TreeNode(7);
        TreeNode tree11 = new TreeNode(18);
        rootTree.left = tree1;
        rootTree.right = tree11;

        TreeNode tree2 = new TreeNode(4);
        TreeNode tree22 = new TreeNode(9);
        TreeNode tree222 = new TreeNode(14);
        TreeNode tree2222 = new TreeNode(22);
        tree1.left = tree2;
        tree1.right = tree22;
        tree11.left = tree222;
        tree11.right = tree2222;

        TreeNode tree3 = new TreeNode(1);
        TreeNode tree33 = new TreeNode(5);
        TreeNode tree333 = new TreeNode(8);
        tree2.left = tree3;
        tree2.right = tree33;
        tree22.left = tree333;

        return rootTree;
    }
}
