package com.zachx7.sort

import scala.util.Random

/**
  * @author zach - 吸柒
  *         冒泡排序
  */
object MPSort {

  def main(args: Array[String]): Unit = {

    val arr = new Array[Int](10)

    for (i <- 0 until 10){
      arr(i) =  Random.nextInt(80000)
    }

    for( i <- 0 until arr.length){
      for(j <- 1 until arr.length - i){
        if(arr(j) < arr(j-1)){
          var tmp = arr(j-1)
          arr(j-1) = arr(j)
          arr(j) = tmp
        }
      }
    }

    println(arr.mkString(" "))
  }

}
