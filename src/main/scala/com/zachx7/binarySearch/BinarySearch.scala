package com.zachx7.binarySearch

import scala.collection.mutable.ArrayBuffer

import util.control.Breaks._

/**
  * @author zach - 吸柒
  *         二分查找算法
  */
object BinarySearch {

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 10, 18, 1000, 1000, 3000)

    val a = binarySearch(arr, 0, arr.length - 1, 1000)
    if (a.isInstanceOf[ArrayBuffer[Int]]) {
      println(a.asInstanceOf[ArrayBuffer[Int]].mkString(" "))
    } else {
      println(a)
    }
  }

  /**
    * 二分查找值
    *
    * @param arr
    * @param left
    * @param right
    * @param findVal
    */
  def binarySearch(arr: Array[Int], left: Int, right: Int, findVal: Int): Any = {
    val midIndex = (left + right) / 2
    val midVal = arr(midIndex)

    if (left > right) {
      return -1
    }
    if (findVal < midVal) {
      binarySearch(arr, left, midIndex - 1, findVal)
    } else if (findVal > midVal) {
      binarySearch(arr, midIndex + 1, right, findVal)
    } else {
      val resArr = ArrayBuffer[Int]()
      var temp = midIndex - 1
      //左边扫描
      breakable {
        while (true) {
          if (temp < 0 || findVal != arr(temp)) {
            break()
          }
          if (findVal == arr(temp)) {
            resArr.append(temp)
          }
          temp -= 1
        }
      }

      resArr.append(midIndex)

      //右边扫描
      temp = midIndex + 1
      breakable {
        while (true) {
          if (temp > arr.length - 1 || findVal != arr(temp)) {
            break()
          }
          if (findVal == arr(temp)) {
            resArr.append(temp)
          }
          temp += 1
        }
      }
      return resArr
    }
  }

}
