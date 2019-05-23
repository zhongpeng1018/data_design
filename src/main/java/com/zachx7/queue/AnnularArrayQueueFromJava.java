package com.zachx7.queue;

import java.util.Scanner;

/**
 * @author zach - 吸柒
 * java版本 - 数组实现环形队列
 */
public class AnnularArrayQueueFromJava {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(4);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1：展示队列  2：添加元素  3：取元素   4:展示首元素    5: 退出");
            int in = scanner.nextInt();
            switch (in) {
                case 1:
                    String show = queue.show();
                    System.out.println(show);
                    break;
                case 2:
                    System.out.println("请输入要加入队列的整数：");
                    int num = scanner.nextInt();
                    String result = queue.add(num);
                    System.out.println(result);
                    break;
                case 3:
                    String str = queue.get();
                    System.out.println(str);
                    break;
                case 4:
                    String head = queue.head();
                    System.out.println(head);
                    break;
                case 5:
                    System.exit(0);
            }
        }

    }

}

class MyQueue {

    private int[] arr; //维护的队列
    private int maxSize; //队列长度
    private int front = 0; // 定义头指针
    private int rear = 0; // 定义尾指针

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 展示队列
     *
     * @return
     */
    public String show() {

        if (isEmpty()) {
            return "队列为空";
        }

        for (int i = front; i < front + size(); i++) {
            System.out.println("arr[" + (i % maxSize) + "]=" + arr[i % maxSize]);
        }
        return "展示完毕";

    }

    /**
     * 展示算法
     *
     * @return
     */
    private int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 添加元素到队列中
     *
     * @param num
     * @return
     */
    public String add(int num) {
        if (isFull()) {
            return "队列已满";
        }
        arr[rear] = num;
        rear = (rear + 1) % maxSize;
        return "添加成功";
    }

    /**
     * 取出元素
     *
     * @return
     */
    public String get() {
        if (isEmpty()) {
            return "队列为空";
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value + "";
    }

    /**
     * 展示头信息
     *
     * @return
     */
    public String head() {
        if (isEmpty()) {
            return "队列为空";
        }
        return arr[front] + "";
    }


}
