package com.mianshi;

/**
 * @author zach - 吸柒
 */
public class Count {

    Lock lock = new Lock();

    public void print() throws InterruptedException {
        lock.lock();
        doAdd();
        lock.unlock();
    }
    public void doAdd() throws InterruptedException {
        lock.lock();
        //do something
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        count.print();
    }

}
