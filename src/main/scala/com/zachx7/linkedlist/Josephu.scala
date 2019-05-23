package com.zachx7.linkedlist

import util.control.Breaks._

/**
  * @author zach - 吸柒
  *         约瑟夫案例实现
  */
object Josephu {

  def main(args: Array[String]): Unit = {
    val game = new Game
    game.addPlayer(100)
    game.start(42,9)

  }

}


class Game(){
  // 初始化第一个小孩
  var first:Player = new Player(-1)

  /**
    * 添加玩家
    * @param nums
    */
  def addPlayer(nums:Int): Unit ={
    var curPlayer:Player = null // 定义一个标识指针
    for (i <- 1 to nums){
      val player = new Player(i)
      if (i == 1){
        first = player
        first.next = first
        curPlayer = first
      }else{
        curPlayer.next = player
        curPlayer = player
        curPlayer.next = first
      }
    }
  }

  /**
    * 展示目前玩家
    */
  def show(): Unit ={
    if(first.next == null){
      println("没有人玩游戏")
      return
    }
    var curPlayer:Player = first
    breakable{
      while(true){
        printf("玩家编号：%d\n",curPlayer.no)
        if (curPlayer.next == first){
          break()
        }
        curPlayer = curPlayer.next
      }
    }
  }

  /**
    * 开始玩游戏
    * @param startNum 开始玩家编号
    * @param countNum 数几次
    *
    */
  def start(startNum:Int,countNum:Int): Unit ={

    var helper = first // 定义一个指针跟随这first前面

    //先指向开始的玩家
    for (_ <- 0 until startNum - 1){
      helper = first
      first = first.next
    }

    breakable {
      while (true) {
        if (helper == first) { // 当剩下最后一个玩家的时候，终止循环
          break()
        }
        //从开始的玩家开始数数，并将指针偏移
        for (_ <- 0 until countNum - 1) {
          helper = first
          first = first.next
        }
        printf("编号：%d 玩家出局\n",first.no)
        first = first.next
        helper.next = first
      }
    }
    println("幸运玩家是：" + first.no)
  }
}


/**
  * 定义玩家类
  * @param pNo 玩家编号
  */
class Player(pNo:Int){
  val no = pNo
  var next:Player = null // 下一个小孩的内存地址指向
}
