package com.zachx7.recursion

/**
  * @author zach - 吸柒
  *         阶乘递归算法
  */
object demo {
  def main(args: Array[String]): Unit = {
    val res = sum(5)
    println(res)
  }

  def sum(num:Int): Int ={
    if(num > 1){
      num * sum(num - 1)
    }else{
      1
    }
  }
}
