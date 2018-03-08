package com.jinzhao.wang.javacore.algorithm;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Created by WANGJINZHAO on 2018/3/7.
 * http://blog.csdn.net/fengrunche/article/details/52305748
 */
public class BinaryTree {

    private Node root;

    public BinaryTree(Integer data) {
        this.root = new Node(data);
    }

    static class Node {
        Node left;
        Node right;
        Integer data;

        public Node(Integer data) {
            this.data = data;
            left = null;
            right = null;
        }

        public Node() {
        }

        public void display() {
            System.out.println(this.data);
        }
    }

    /**
     * 插入
     */
    private void insert(Integer data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
            root.left = null;
            root.right = null;
        } else {
            Node current = root;
            Node parent = null;
            while (true) {
                if (data == current.data)
                    break;
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        break;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        break;
                    }
                }
            }
        }
    }

    //前序
    private void preOrder(Node node) {
        if (node == null)
            return;
        node.display();
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序
    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        node.display();
        inOrder(node.right);
    }


    //后序遍历
    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        node.display();
    }

    //深度优先遍历,利用栈后进先出。实际上就是前序遍历
    private void depthFirst(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.println(node.data);//出栈
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    //广度优先遍历，利用队列 先进先出。层级遍历
    private void breadthFirst(Node node) {
        ArrayDeque<Node> arrayDeque = new ArrayDeque();
        arrayDeque.add(node);
        while (!arrayDeque.isEmpty()) {
            node = arrayDeque.removeFirst();
            System.out.println(node.data);
            if (node.left != null) {
                arrayDeque.add(node.left);
            }
            if (node.right != null)
                arrayDeque.add(node.right);
        }
    }


    //二叉搜索树 找最近的公共祖先
    //http://blog.csdn.net/beitiandijun/article/details/41970417
    public Node lowestCommonAncestor(Node root, Node a, Node b) {
        if (root == null || root == a || root == b)
            return root;
        Node left = lowestCommonAncestor(root.left, a, b);
        Node right = lowestCommonAncestor(root.right, a, b);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(52);
        binaryTree.insert(580);
        binaryTree.insert(12);
        binaryTree.insert(50);
        binaryTree.insert(58);
        binaryTree.insert(9);
        binaryTree.insert(888);
        binaryTree.insert(248);
        binaryTree.insert(32);
        binaryTree.insert(666);
        binaryTree.insert(455);
        binaryTree.insert(777);
        binaryTree.insert(999);

        //binaryTree.inOrder(binaryTree.root);
        //binaryTree.preOrder(binaryTree.root);
        binaryTree.postOrder(binaryTree.root);
        //binaryTree.depthFirst(binaryTree.root);
        binaryTree.breadthFirst(binaryTree.root);
    }

}
