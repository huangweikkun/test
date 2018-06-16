package com.jacken.test.algorithm.sort;

/**
 * @author jacken
 * @date 2018/02/18
 */
public class BinarySearchTree{

    private Node root;
    private Integer size = 0;

    public Node getRoot() {
        return root;
    }

    class Node{
        private Integer value;
        private Node left;
        private Node right;

        public Node() {}

        public Node(Integer value) {
            this.value = value;
        }
    }

    public void put(Integer value) {
        size ++;
        Node insertNode = new Node(value);

        if(root == null){
            root = insertNode;
        }

        insertNode(root, insertNode);
    }

    public void insertNode(Node node, Node insertNode){
        size ++;

        if(node == null) {
            node = insertNode;
        }

        if(insertNode.value.compareTo(node.value) == 0){
            return;
        }else if(insertNode.value.compareTo(node.value) > 0) {
            if(node.right == null) {
                node.right = insertNode;
            }else {
                insertNode(node.right, insertNode);
            }

        }else {
            if(node.left == null) {
                node.left = insertNode;
            }else {
                insertNode(node.left, insertNode);
            }
        }
    }

    public void printTree(Node node, Integer level){
        System.out.println("level:" + level + "value:" + node.value);
        level ++;
        if(node.left != null) {
            printTree(node.left, level);
        }

        if(node.right != null) {
            printTree(node.right, level);
        }
    }

    public static void main(String[] args) {

    }

}

