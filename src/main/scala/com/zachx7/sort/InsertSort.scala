package com.zachx7.sort

import scala.util.Random

/**
  * @author zach - 吸柒
  *         插入排序
  */
object InsertSort {

  def main(args: Array[String]): Unit = {

    val arr = new Array[Int](10)

    for (i <- 0 until 10) {
      arr(i) = Random.nextInt(80000)
    }

    for (i <- 1 until arr.length) {
      var insertVal = arr(i)
      var insertIndex = i - 1

      /*
        插入排序思想：
          将数据分成有序与无序
          将第一个数字作为有序数组，之后的数据作为无序数组依次插入有序数组
        （20），3，1，15
        （20，20），1，15
       */
      // 跳出循环的条件，索引小于0，这个时候代表已经到头了，需要插入最前面。
      // 如果插入的值小于有序集合最后的值，则将插入索引前移
      while (insertIndex >= 0 && insertVal < arr(insertIndex)) {
        arr(insertIndex + 1) = arr(insertIndex) //将该值后移
        insertIndex -= 1 // 索引前移
      }
      arr(insertIndex + 1) = insertVal
    }

    println(arr.mkString(" "))
  }

}
