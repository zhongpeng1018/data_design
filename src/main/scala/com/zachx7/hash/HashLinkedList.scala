package com.zachx7.hash

import scala.collection.mutable.ArrayBuffer
import util.control.Breaks._

/**
  * @author zach - 吸柒
  *         哈希（散列） + 链表 实现哈希表的存储
  */
object HashLinkedList {
  def main(args: Array[String]): Unit = {
    val table = new HashTable(7)
    for (i <- 0 until 7) {
      table.emplLinkedListArray.append(new EmplLinkedList)
    }
    table.add(Empl(1, "zach"))
    table.add(Empl(7, "baba"))

    val empl = table.find(2)

    if (empl != null) {
      println(empl.eName)
    } else {
      println("没有查到该员工")
    }

  }
}


/**
  * Hash表
  *
  * @param size
  */
class HashTable(val size: Int) {
  val emplLinkedListArray = new ArrayBuffer[EmplLinkedList](size)

  def add(empl: Empl): Unit = {
    val EmplLinkedListHashCode = hashNum(empl.eNo)
    emplLinkedListArray(EmplLinkedListHashCode).add(empl)
  }

  def hashNum(id: Int): Int = {
    id % size
  }

  def list(): Unit = {

    for (i <- 0 until size) {
      emplLinkedListArray(i).list()
      println()
    }
  }

  def find(id: Int): Empl = {
    emplLinkedListArray(hashNum(id)).findByEmplId(id)
  }

}


/**
  * 定义一个员工类
  *
  * @param eNo   员工编号
  * @param eName 员工名字
  */
case class Empl(eNo: Int, eName: String) {
  var next: Empl = null
}

/**
  * 定义一个员工链表
  */
class EmplLinkedList() {

  var head: Empl = null

  /**
    * 添加员工
    *
    * @param emp 员工节点
    */
  def add(emp: Empl): Unit = {
    if (head == null) {
      head = emp
      return
    }
    var temp = head
    breakable {
      while (true) {
        if (temp.next == null) {
          break()
        }
        temp = temp.next
      }
    }
    temp.next = emp
  }

  /**
    * 遍历链表
    */
  def list(): Unit = {
    if (head == null) {
      println("该链表为空")
      return
    }
    var temp = head
    breakable {
      while (true) {
        printf("=> 员工id:%d 员工名称：%s", temp.eNo, temp.eName)
        if (temp.next == null) {
          break()
        }
        temp = head.next
      }
    }
  }

  def findByEmplId(id: Int): Empl = {
    if (head == null) {
      println("链表为空")
    }
    var temp = head
    breakable {
      while (true) {
        if (temp == null || temp.eNo == id) {
          break()
        }
        temp = temp.next
      }
    }
    return temp
  }

}


