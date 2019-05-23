package com.zachx7.linkedlist

import scala.util.control.Breaks.{break, breakable}

/**
  * @author zach - 吸柒
  *         双向链表的实现
  */
object DoubleLinkedListDemo {
  def main(args: Array[String]): Unit = {
    val hero1 = new HeroNode2(1, "吸柒1")
    val hero3 = new HeroNode2(3, "吸柒3")
    val hero4 = new HeroNode2(4, "吸柒4")
    val hero2 = new HeroNode2(2, "吸柒2")
    val hero5 = new HeroNode2(5, "吸柒5")


    val linkedList = new DoubleLinkedList
    linkedList.add(hero1)
    linkedList.add(hero3)
    linkedList.add(hero4)
    linkedList.add(hero2)
    linkedList.add(hero5)
    linkedList.list()

    println("-----------------")

    linkedList.delete(5)

    linkedList.list()

    println("-----------------")

    linkedList.add(hero5)

    linkedList.list()

  }
}

class DoubleLinkedList(){
  //初始化一个头结点，方便找寻链表
  val head = new HeroNode2(0, "")

  /**
    * 向链表尾部添加节点
    *
    * @param heroNode 需要添加到尾部的节点
    */
  def add(heroNode: HeroNode2): Unit = {
    //创建临时变量，方便遍历链表
    var temp = head

    //不断循环判断节点的下一个节点是否为null,如果为null就证明是最后一个节点，退出循环
    breakable {
      while (true) {
        if (temp.next == null) {
          break()
        }
        temp = temp.next
      }
    }
    //将需要添加的节点的内存地址赋值给最后一个节点对应的Next属性上
    temp.next = heroNode
    heroNode.pre = temp
  }

  /**
    * 展示链表
    */
  def list(): Unit = {
    //创建临时变量，方便遍历链表
    var temp = head.next

    breakable {
      while (true) {
        if (temp == null) {
          break()
        }
        printf("当前节点的信息：编号：%d 姓名：%s\n", temp.no, temp.name)
        temp = temp.next
      }
    }
  }

  /**
    * 修改节点信息
    *
    * @param no 节点编号
    */
  def update(no: Int): HeroNode2 = {
    //创建临时变量，方便遍历链表
    var temp = head.next

    //定义一个变量标记
    var flag = false

    breakable {
      while (true) {
        if (temp == null) {
          break()
        }
        if (temp.no == no) {
          flag = true
          break()
        }
        temp = temp.next
      }
    }
    if (flag) {
      return temp
    }
    null
  }

  /**
    * 删除节点
    * 原理将堆内存地址引用覆盖，让CG去回收资源
    *
    * @param no 节点编号
    */
  def delete(no: Int): Unit = {
    //创建临时变量，方便遍历链表
    var temp = head.next
    var flag = false // 定义一个变量来标记是否找到对应节点

    breakable {
      while (true) {
        if (temp == null) {
          break()
        }
        if (temp.no == no) {
          flag = true
          break()
        }
        temp = temp.next
      }
    }

    if (flag) {
      temp.pre.next = temp.next
      if(temp.next != null) {
        temp.next.pre = temp.pre
      }else{
        temp.pre = null
      }
    }
  }
}


class HeroNode2(val no: Int, var name: String) {
  //用于指向上一个节点的内存地址
  var pre:HeroNode2 = null

  //用于指向下一个节点的内存地址
  var next: HeroNode2 = null
}
