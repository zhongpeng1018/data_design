package com.zachx7.linkedlist

import util.control.Breaks._

/**
  * @author zach - 吸柒
  *         有头单向链表的实现
  */
object SingleLinkedListDemo {
  def main(args: Array[String]): Unit = {
    val hero1 = new HeroNode(1, "吸柒1")
    val hero3 = new HeroNode(3, "吸柒3")
    val hero4 = new HeroNode(4, "吸柒4")
    val hero2 = new HeroNode(2, "吸柒2")
    val hero5 = new HeroNode(1, "吸柒5")


    val singleLinkedList = new SingleLinkedList
    singleLinkedList.add2(hero1)
    singleLinkedList.add2(hero3)
    singleLinkedList.add2(hero4)
    singleLinkedList.add2(hero2)
    singleLinkedList.add2(hero5)
    singleLinkedList.list()

    //    val heroNode = singleLinkedList.update(1)
    //    heroNode match {
    //      case null => println("该编号的节点没有找到")
    //      case heroNode: HeroNode => heroNode.name = "我是超人"
    //    }

    val hero6 = new HeroNode(1, "钢铁侠")
    singleLinkedList.update2(hero6)

    println(" ==========================黄金分割线===========================")

    singleLinkedList.list()

    singleLinkedList.delete(4)

    println(" ==========================黄金分割线===========================")

    singleLinkedList.list()

  }
}

/**
  * 自定义链表
  */
class SingleLinkedList() {

  //初始化一个头结点，方便找寻链表
  val head = new HeroNode(0, "")

  /**
    * 修改节点信息
    *
    * @param no 节点编号
    */
  def update(no: Int): HeroNode = {
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
    * 完全修改节点
    *
    * @param newHeroNode 新的节点
    */
  def update2(newHeroNode: HeroNode): Unit = {
    //创建临时变量，方便遍历链表
    delete(newHeroNode.no)
    add2(newHeroNode)
  }

  /**
    * 删除节点
    * 原理将堆内存地址引用覆盖，让CG去回收资源
    *
    * @param no 节点编号
    */
  def delete(no: Int): String = {
    //创建临时变量，方便遍历链表
    var temp = head
    var flag = false // 定义一个变量来标记是否找到对应节点
    breakable {
      while (true) {
        if (temp.next == null) {
          break()
        }
        if (temp.next.no == no) {
          flag = true
          break()
        }
        temp = temp.next
      }
    }
    if (flag) {
      temp.next = temp.next.next
      return "删除成功"
    }
    "没有对应编号的节点"
  }


  /**
    * 向链表尾部添加节点
    *
    * @param heroNode 需要添加到尾部的节点
    */
  def add(heroNode: HeroNode): Unit = {
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
  }

  /**
    * 按照编号插入节点，由小到大排序
    *
    * @param heroNode 需要添加到尾部的节点
    */
  def add2(heroNode: HeroNode): Unit = {
    //创建临时变量，方便遍历链表
    var temp = head
    //定义一个变量，用来记录是否应该插入
    var flag = false

    //定义一个变量，判断链表中是否存在该编号
    var flag2 = false

    //不断循环判断节点的下一个节点是否为null,如果为null就证明是最后一个节点，退出循环
    breakable {
      while (true) {
        if (temp.next == null) {
          break()
        }
        //判断当前节点的下一个节点的编号是否比需要插入的节点编号大
        if (temp.next.no > heroNode.no) {
          flag = true
          break()
        } else if (temp.next.no == heroNode.no) {
          flag2 = true
          break()
        }
        temp = temp.next
      }
    }

    if (flag2) {
      printf("编号 %d 已经存在，无法添加\n", heroNode.no)
      return
    }
    //如果flag为true 进行链表的插入
    if (flag) {
      heroNode.next = temp.next
      temp.next = heroNode
      return
    }
    //将需要添加的节点的内存地址赋值给最后一个节点对应的Next属性上
    temp.next = heroNode
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
}

/**
  * 创建节点对象
  *
  * @param no   英雄编号
  * @param name 英雄名称
  */
class HeroNode(val no: Int, var name: String) {
  //用于指向下一个节点的内存地址
  var next: HeroNode = null
}
