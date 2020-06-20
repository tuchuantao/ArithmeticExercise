package com.kevin.arithmetic.tree;


public class TreeExercise {

    public static void main(String[] args) {
        Node root = initTree();

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

    private static void firstTraversal(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        System.out.print(rootNode.value + " , ");

        firstTraversal(rootNode.left);

        firstTraversal(rootNode.right);
    }

    private static void centerTraversal(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        centerTraversal(rootNode.left);

        System.out.print(rootNode.value + " , ");

        centerTraversal(rootNode.right);
    }

    private static void endTraversal(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        endTraversal(rootNode.left);

        endTraversal(rootNode.right);

        System.out.print(rootNode.value + " , ");
    }

    /**
     *
     *                  10
     *             7          18
     *          4     9    14   22
     *        1   5  8
     * @return
     */
    private static Node initTree() {
        Node rootTree = new Node(10);
        Node tree1 = new Node(7);
        Node tree11 = new Node(18);
        rootTree.left = tree1;
        rootTree.right = tree11;

        Node tree2 = new Node(4);
        Node tree22 = new Node(9);
        Node tree222 = new Node(14);
        Node tree2222 = new Node(22);
        tree1.left = tree2;
        tree1.right = tree22;
        tree11.left = tree222;
        tree11.right = tree2222;

        Node tree3 = new Node(1);
        Node tree33 = new Node(5);
        Node tree333 = new Node(8);
        tree2.left = tree3;
        tree2.right = tree33;
        tree22.left = tree333;

        return rootTree;
    }
}
