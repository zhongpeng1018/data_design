package com.zachx7.sparseArray

import java.io._

import scala.collection.mutable.ArrayBuffer

/**
  * @author zach - 吸柒
  *         Scala版本 数据结构 - 稀疏数组
  */
object SparseArray {

  def main(args: Array[String]): Unit = {

    val rowSize = 11
    val colSize = 11

    //定义一个11行11列的二维数组
    val chessMap = Array.ofDim[Int](rowSize, colSize)

    chessMap(1)(2) = 1 // 1表示黑子
    chessMap(2)(3) = 2 // 2表示白子

    for (elem <- chessMap) {
      for (elem2 <- elem) {
        printf("%d\t", elem2)
      }
      println()
    }

    // 稀疏数组的实现
    val sparseArray = ArrayBuffer[Data]()
    //定义第一行 数据为 行列数
    sparseArray.append(new Data(rowSize, colSize, 0))

    //遍历棋盘
    for (i <- 0 until chessMap.length) {
      for (j <- 0 until chessMap(i).length) {
        //判断棋盘上是否有子，不为0将数值保存到数组中
        if (chessMap(i)(j) != 0) {
          sparseArray.append(new Data(i, j, chessMap(i)(j)))
        }
      }
    }

    //展示稀疏后的数组
    println("-------------稀疏数组展示--------------")
    println("行\t列\t值")
    for (elem <- sparseArray) {
      printf("%d\t%d\t%d\n", elem.row, elem.col, elem.value)
    }

    //定义路径
    val path: File = new File("d:/data2.txt")
    //写出
    val oos: ObjectOutputStream = new ObjectOutputStream(new FileOutputStream(path))
    oos.writeObject(sparseArray)
    oos.flush()
    oos.close()

    //读取
    val ois: ObjectInputStream = new ObjectInputStream(new FileInputStream(path))
    //将读取的数据转换成可变Array数组
    val sparseArray2: ArrayBuffer[Data] = ois.readObject().asInstanceOf[ArrayBuffer[Data]]
    ois.close()
    //恢复原始数据
    val newData = sparseArray2(0) // 取出第一条数据
    val rowSize2 = newData.row
    val colSize2 = newData.col
    //创建出原始棋盘的大小
    val chessMap2 = Array.ofDim[Int](rowSize2, colSize2)

    for (i <- 1 until sparseArray2.length) {
      val data = sparseArray2(i)
      //将数据恢复到新的棋盘上
      chessMap2(data.row)(data.col) = data.value
    }
    println("-------------稀疏数组恢复原始数据展示--------------")
    for (elem <- chessMap2) {
      for (elem2 <- elem) {
        printf("%d\t", elem2)
      }
      println()
    }
  }

}

class Data(val row: Int, val col: Int, val value: Int) extends Serializable

