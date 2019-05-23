package com.zachx7.sort

import scala.util.Random

/**
  * @author zach - 吸柒
  *         选择排序
  */
object SelectSort {
  def main(args: Array[String]): Unit = {
    val arr = new Array[Int](10)

    for (i <- 0 until 10) {
      arr(i) = Random.nextInt(80000)
    }

    /*
    主要思路：
      先找到最小值和最小值的索引并与第i个元素交换
      每交换一次将指针后移一位，最后一个数字不需要进行排序
     */
    for (i <- 0 until arr.length - 1) {
      var min = arr(i)
      var minIndex = i
      for (j <- (i + 1) until arr.length) {
        if (arr(j) < min) {
          min = arr(j)
          minIndex = j
        }
      }
      if (minIndex != i) {
        arr(minIndex) = arr(i)
        arr(i) = min
      }
    }

    println(arr.mkString(" "))

  }
}
