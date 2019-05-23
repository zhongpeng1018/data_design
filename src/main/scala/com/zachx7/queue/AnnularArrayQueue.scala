package com.zachx7.queue

import scala.io.StdIn

/**
  * @author zach - 吸柒
  *         环形队列
  */
object AnnularArrayQueue extends App {

  val arr = new AnnularArrayQueue(3)

  while (true) {
    println("show显示队列，exit退出程序，add添加，get取出，head取出头元素")
    val line = StdIn.readLine()

    line match {
      case "show" => arr.show
      case "exit" => System.exit(0)
      case "add" => {
        println("请输入要添加的整数")
        val value = StdIn.readInt()
        val res = arr.add(value)
        if (res.isInstanceOf[Exception]) {
          println(res.asInstanceOf[Exception].getMessage)
        }
      }
      case "get" => {
        val res = arr.get()
        if (res.isInstanceOf[Exception]) {
          println(res.asInstanceOf[Exception].getMessage)
        } else {
          println(s"取出的值为 $res")
        }
      }
      case "head" => arr.head
    }
  }
}


class AnnularArrayQueue(val maxSize: Int) {

  val arr = new Array[Int](maxSize) //维护的数组
  var front = 0 // 指向头的指针
  var rear = 0 // 指向尾的指针

  def isFull: Boolean = {
    (rear + 1) % maxSize == front
  }

  def isEmpty: Boolean = {
    rear == front
  }

  def show: Unit = {
    if (isEmpty) {
      println("队列为空")
      return
    }
    for (i <- front until front + size()) {
      printf("arr[%d]=%d\n", i % maxSize, arr(i % maxSize))
    }
  }

  /**
    * front 0 rear 1  maxSize 4 (1+4-0) % 4 = 1
    * front 0 rear 2  maxSize 4 (2+4-0) % 4 = 2
    * front 0 rear 3  maxSize 4 (3+4-0) % 4 = 3
    *
    * front 1 rear 1  maxSize 4 (1+4-1) % 4 = 0
    * front 1 rear 2  maxSize 4 (2+4-1) % 4 = 1
    * front 1 rear 3  maxSize 4 (3+4-1) % 4 = 2
    * @return
    */
  def size(): Int = {
    (rear + maxSize - front) % maxSize
  }

  def add(n: Int): Any = {
    if (isFull) {
      return new Exception("队列已满")
    } else {
      arr(rear) = n
      rear = (rear + 1) % maxSize
    }
  }

  def get(): Any = {
    if (isEmpty) {
      return new Exception("队列为空")
    } else {
      val value = arr(front)
      front = (front + 1) % maxSize
      return value
    }
  }

  def head: Unit = {
    if (isEmpty) {
      println("队列空")
    } else
      println("头元素为=" + arr(front))
  }
}
