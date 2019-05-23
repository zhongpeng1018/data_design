package com.zachx7.recursion

/**
  * @author zach - 吸柒
  *         递归练习 - 经典案例之迷宫回溯
  */
object MiGong {

  def main(args: Array[String]): Unit = {

    val map = createMap()

    showMap(map)

    findWay(map, 1, 1)

    println()

    showMap(map)

  }


  /**
    * 构建地图
    *
    * @return
    */
  def createMap(): Array[Array[Int]] = {
    val map = Array.ofDim[Int](8, 7)

    // 填满上下行
    for (i <- 0 until 7) {
      map(0)(i) = 1
      map(7)(i) = 1
    }

    //填满左右
    for (i <- 0 until 8) {
      map(i)(0) = 1
      map(i)(6) = 1
    }

    map(3)(1) = 1
    map(3)(2) = 1
    map(3)(3) = 1
    map
  }

  /**
    * 打印地图
    *
    * @param map 地图
    */
  def showMap(map: Array[Array[Int]]): Unit = {
    for (i <- 0 until 8) {
      for (j <- 0 until 7) {
        print(map(i)(j) + " ")
      }
      println()
    }
  }

  /**
    * 寻找回家的方向
    *
    * 策略一：下 -》 右 -》 上 -》 左
    * 策略二：上 -》 右 -》 下 -》 左
    *
    * @param map
    * @param i 行
    * @param j 列
    * @return
    */
  def findWay(map: Array[Array[Int]], i: Int, j: Int): Boolean = {
    if (map(6)(5) == 2) {
      return true
    } else {
      if (map(i)(j) == 0) { // 证明还没有开始走
        map(i)(j) = 2
        if (findWay(map, i + 1, j)) {
          return true
        } else if (findWay(map, i, j + 1)) {
          return true
        } else if (findWay(map, i - 1, j)) {
          return true
        } else if (findWay(map, i, j - 1)) {
          return true
        } else {
          map(i)(j) = 3
          return false
        }
      } else { // 1 2 3
        return false
      }
    }
  }
}


