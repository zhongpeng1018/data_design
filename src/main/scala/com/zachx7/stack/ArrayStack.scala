package com.zachx7.stack

/**
  * @author zach - 吸柒
  */
class ArrayStack(maxSize: Int) {
  val size = maxSize
  var top = -1
  var stack = new Array[Int](maxSize)

  def isFull(): Boolean = {
    top == size - 1
  }

  def isEmpty(): Boolean = {
    top == -1
  }

  //展示栈
  def show(): Unit = {
    if (isEmpty()) {
      println("空栈...")
      return
    }
    for (i <- 0 to top reverse) {
      printf("stack[%d]=%d\n", i, stack(i))
    }
  }

  //压栈
  def push(value: Int): Unit = {
    if (isFull()) {
      println("栈满")
      return
    }
    top += 1
    stack(top) = value
  }

  //出栈
  def pop(): Any = {
    if (isEmpty()) {
      return new Exception("栈空")
    }
    val result = stack(top)
    top -= 1
    result
  }




}
