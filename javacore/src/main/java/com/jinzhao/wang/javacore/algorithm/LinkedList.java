package com.jinzhao.wang.javacore.algorithm;

/**
 * Created by WANGJINZHAO on 2018/3/7.
 */
public class LinkedList {

    Node head;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }

    }

    /**
     *插入
     */
    public void insert(int data) {
        Node current = new Node(data);
        Node p = head;
        if (head == null) {
            current.next = head;
            head = current;
        } else {
            while (p.next != null) {
                p = p.next;
            }
            p.next = current;
        }
    }

    /**
     * 翻转链表
     */
    public Node reverse(Node head) {
        if (head == null)
            return head;
        Node pre = head;// 上一结点
        Node current = head.next;//当前指针
        Node temp;//临时结点，用于保存当前结点的指针域（即下一结点）
        while (current != null) {
            temp = current.next;//先记录当前节点的下一个节点,后序为拿到原来链表继续翻转
            current.next = pre;//翻转
            //往前移动指针继续执行
            pre = current;
            current = temp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.next = null;
        return pre;
    }

    /**
     * 查找链表中间节点
     */
    public Node searchMidNode(Node head) {
        if (head == null)
            return null;
        Node fastNode = head.next;
        Node slowNode = head.next;
        while (fastNode.next != null && fastNode.next.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;

        }
        System.out.println(slowNode.data);
        return slowNode;
    }

    /**
     *链表有环
     */
    public boolean circularLinkedList(Node node){
        if (node==null||node.next==null) return false;
        if (node==node.next) return true;
        Node slow=node;
        Node fast=node;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insert(6);
//        linkedList.insert(7);
//        linkedList.insert(8);
//        linkedList.insert(9);

//        Node reverseHead = linkedList.reverse(linkedList.head);
//
//        Node current = reverseHead;
//        while (current != null) {
//            System.out.println(current.data);
//            current = current.next;
//        }
 //       linkedList.searchMidNode(linkedList.head);
        System.out.println(linkedList.circularLinkedList(linkedList.head));
    }

}
