package com.zachx7.stack

import scala.io.StdIn

/**
  * @author zach - 吸柒
  *         数组模拟栈
  */
object ArrayStackDemo {
  def main(args: Array[String]): Unit = {

    val stack = new ArrayStack(4)

    while (true) {
      println("show显示栈，push压栈，pop出栈，exit退出程序")
      val line = StdIn.readLine()
      line match {
        case "show" => stack.show()
        case "push" => {
          println("请输入要添加的整数")
          val value = StdIn.readInt()
          stack.push(value)
        }
        case "pop" => {
          val result = stack.pop()
          if (result.isInstanceOf[Exception]) {
            println(result.asInstanceOf[Exception].getMessage)
          } else {
            println(result)
          }
        }
        case "exit" => System.exit(0)
        case _ => println("输入有误，请重新输入")
      }
    }

  }
}



