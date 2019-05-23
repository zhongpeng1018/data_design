package com.zachx7.queue

import scala.io.StdIn

/**
  * @author zach - 吸柒
  *
  */
object ArrayQueue {

  def main(args: Array[String]): Unit = {

    val arr = new ArrayQueue(3)

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
}

class ArrayQueue(val maxSize: Int) {

  val arr = new Array[Int](maxSize) //维护的数组
  var front = -1 // 指向头的指针
  var rear = -1 // 指向尾的指针

  def isFull: Boolean = {
    rear == maxSize - 1
  }

  def isEmpty: Boolean = {
    rear == front
  }

  def show: Unit = {
    if (isEmpty) {
      println("队列为空")
      return
    }
    for (i <- front + 1 to rear) {
      printf("arr[%d]=%d\n", i, arr(i))
    }
  }

  def add(n: Int): Any = {
    if (isFull) {
      return new Exception("队列已满")
    } else {
      rear += 1 // 尾部指针偏移1位
      arr(rear) = n
    }
  }

  def get(): Any = {
    if (isEmpty) {
      return new Exception("队列为空")
    } else {
      front += 1
      arr(front)
    }
  }

  def head: Unit = {
    if (isEmpty) {
      println("队列空")
    } else
      println("头元素为=" + arr(front + 1))
  }
}
