package com.zachx7.linkedlist;

/**
 * @author zach - 吸柒
 *      节点对象
 */
public class Node {

    private Integer no; // 编号
    private String name; // 名称
    private Node next = null;

    public Node(Integer no, String name) {
        this.no = no;
        this.name = name;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
