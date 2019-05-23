package com.zachx7.linkedlist;

/**
 * @author zach - 吸柒
 * 有头链表对象
 */
public class SingleLinkedListJava {
    //链表头
    private Node head = new Node(0, "");

    /**
     * 有序插入节点
     *
     * @param node
     */
    public void add(Node node) {
        //定义节点标识
        Node temp = head;
        //定义一个标识
        boolean flag = false;
        boolean flag2 = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() > node.getNo()) {
                flag = true;
                break;
            } else if (temp.getNext().getNo().intValue() == node.getNo().intValue()) {
                flag2 = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            node.setNext(temp.getNext());
            temp.setNext(node);
            System.out.println("插入节点成功");
            return;
        } else if (flag2) {
            System.out.println("该节点已存在");
            return;
        }
        temp.setNext(node);
    }

    public void list() {
        //定义节点标识
        Node temp = head.getNext();
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.getNo() + "--" + temp.getName());
            temp = temp.getNext();
        }
    }

    public void delete(int no) {
        //定义节点标识
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.println("找不到该节点");
        }
    }

    public void update(Node node) {
        delete(node.getNo());
        add(node);
    }

}
