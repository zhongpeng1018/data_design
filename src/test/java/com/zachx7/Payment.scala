package com.zachx7

/**
  * @author zach - 吸柒
  */
object Payment {

  def main(args: Array[String]): Unit = {

  }

  def payMoney(money: Int, tenNum: Int, fiveNum: Int, twoNum: Int): Unit = {

    var flag = true
    var needTen = 0
    var needFive = 0
    var needTwo = 0
    var temp = 0

    if(money > tenNum * 10 + fiveNum * 5  + twoNum * 2){
      println("金额不足")
      return
    }

    val length = money + "".length

    if (length >= 2) { // 如果是 10位数以上
      if (tenNum >= money / 10) {
        needTen = money / 10
        temp = money - needTen * 10
        if (temp == 0) {
          flag = true
        } else {
          if (fiveNum > temp / 5) {

          }
        }
      } else {
        needTen = tenNum
        temp = money - needTen * 10
        if(fiveNum > temp / 5){
          needFive = temp / 5
        }else{
          needFive = fiveNum

        }
      }


    } else { // 如果是个位数
      if (money >= 5) { // 如果金额大于5元
        needFive = 1
        temp = money - 5
        if (temp % 2 == 0) {
          needTwo = temp / 2
        } else {
          flag = false
        }
      } else {
        temp = money
        if (temp % 2 == 0) {
          needTwo = temp / 2
        } else {
          flag = false
        }
      }
    }


    if (flag) {
      printf("需要%d张10元，需要%d张5元，需要%d张2元", needTen, needFive, needTwo)
    } else {
      println("不能凑整")
    }

  }


}
