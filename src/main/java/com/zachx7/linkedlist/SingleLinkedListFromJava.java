package com.zachx7.linkedlist;

/**
 * @author zach - 吸柒
 */
public class SingleLinkedListFromJava {

    public static void main(String[] args) {
        Node node1 = new Node(1, "节点一");
        Node node3 = new Node(3, "节点三");
        Node node4 = new Node(4, "节点四");
        Node node2 = new Node(2, "节点二");

        SingleLinkedListJava singleLinkedListJava = new SingleLinkedListJava();
        singleLinkedListJava.add(node1);
        singleLinkedListJava.add(node3);
        singleLinkedListJava.add(node4);
        singleLinkedListJava.add(node2);

        singleLinkedListJava.list();

        singleLinkedListJava.delete(2);

        singleLinkedListJava.list();

    }

}

