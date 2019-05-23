package com.zachx7.sort

import scala.util.Random
import util.control.Breaks._

/**
  * @author zach - 吸柒
  */
object QuickSort {


  def main(args: Array[String]): Unit = {

    val arr = new Array[Int](10)

    for (i <- 0 until 10) {
      arr(i) = Random.nextInt(80000)
    }

    quickSort(0, arr.length - 1, arr)

    println(arr.mkString(" "))

  }


  def quickSort(left: Int, right: Int, arr: Array[Int]): Unit = {
    var l = left //  左下标
    var r = right // 右下标
    var pivot = arr((left + right) / 2) // 以中间的值为基准进行分割
    var temp = 0
    breakable {
      // while  语句的作用就是把比 pivot 小的数放到左边,  比 pivot 大的数放到右边
      while (l < r) {
        while (arr(l) < pivot) { //从左边找一个比 pivot 大的值对应下标
          l += 1
        }
        while (arr(r) > pivot) { //从右边找一个比 pivot 小的值对应下标
          r -= 1
        }
        if (l >= r) { // 说明本次交换结束,退出本次 while
          break()
        }
        var temp = arr(l) //交换
        arr(l) = arr(r)
        arr(r) = temp
        //处理后，如果发现 arr(l) == pivot 就 r - =1 ,  提高效率
        if (arr(l) == pivot) {
          r -= 1
        }
        if ((arr(r)) == pivot) {
          l += 1
        }
      }
    }

    if (l == r) { // 提高效率
      l += 1
      r -= 1
    }

    if (left < r) { //向左递归排序
      quickSort(left, r, arr)
    }
    if (right > l) {
      //向右递归排序
      quickSort(l, right, arr)
    }


  }

}
