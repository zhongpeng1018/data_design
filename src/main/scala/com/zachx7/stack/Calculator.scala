package com.zachx7.stack

import util.control.Breaks._

/**
  * @author zach - 吸柒
  *         使用栈 实现计算器功能
  *         等待：实现小括号功能
  */
object Calculator {
  def main(args: Array[String]): Unit = {
    val numStack = new ArrayStack(10)
    val operStack = new ArrayStack(10)

    val str = "3+4*2"

    var index = 0
    var num1 = 0
    var num2 = 0
    var oper = 0
    var res = 0
    var char = ' '
    var keepNum = ""
    var flag = false

    //将操作符和需要计算的数字压倒栈中
    breakable {
      while (true) {
        char = str.substring(index, index + 1)(0)
        println(char)

        if (isBracket(char)) {

          flag = true

          if (isEnd(char)) {
            num1 = numStack.pop().toString.toInt
            num2 = numStack.pop().toString.toInt
            oper = operStack.pop().toString.toInt
            res = calculate(num1, num2, oper)
            numStack.push(res)
            flag = false
          }

        } else {
          if (isOperator(char)) { // 如果是操作符
            if (operStack.isEmpty()) { // 如果栈为空 ， 直接压栈
              operStack.push(char)
            } else { // 如果不为空
              //如果优先级小就进行计算

              if (!flag) {

                if (priority(char) <= priority(operStack.stack(operStack.top))) {
                  num1 = numStack.pop().toString.toInt
                  num2 = numStack.pop().toString.toInt
                  oper = operStack.pop().toString.toInt
                  res = calculate(num1, num2, oper)
                  numStack.push(res)
                  operStack.push(char)
                } else {
                  operStack.push(char)
                }
              }else{
                operStack.push(char)
              }


            }
          } else { // 数字
            keepNum += char //判断多位数数字
            if (index == str.length - 1) { // 如果当前的索引是最后一位，直接入数字栈
              numStack.push(keepNum.toInt)
            } else {
              //判断下一个字符是否是数字
              if (isOperator(str.substring(index + 1, index + 2)(0)) || isBracket(str.substring(index + 1, index + 2)(0))) {
                //如果下一位是操作符，直接将当前数字入栈
                numStack.push(keepNum.toInt)
                keepNum = "" //入完栈之后需要清空标记
              }
            }
          }
        }
        index += 1
        if (index == str.length) {
          break()
        }
      }
    }

    //取出数字和操作符记性计算
    breakable {
      while (true) {
        if (operStack.isEmpty()) {
          break()
        }
        num1 = numStack.pop().toString.toInt
        num2 = numStack.pop().toString.toInt
        oper = operStack.pop().toString.toInt
        res = calculate(num1, num2, oper)
        numStack.push(res)
      }
    }


    println(str + "=" + numStack.pop())
  }


  def isEnd(value: Int): Boolean = {
    value == ')'
  }

  /**
    * 判断是否是括号
    *
    * @param value 输入的值
    * @return
    */
  def isBracket(value: Int): Boolean = {
    value == '(' || value == ')'
  }

  /**
    * 判断是否是操作符
    *
    * @param value 值
    * @return
    */
  def isOperator(value: Int): Boolean = {
    value == '+' || value == '-' || value == '*' || value == '/'
  }

  /**
    * 计算优先级
    *
    * @param oper 操作运算符
    * @return
    */
  def priority(oper: Int): Int = {
    if (oper == '+' || oper == '-') {
      0
    } else if (oper == '*' || oper == '/') {
      1
    } else {
      -1
    }
  }

  /**
    * 计算方法
    *
    * @param num1 数字1
    * @param num2 数字2
    * @param oper 操作运算符
    * @return
    */
  def calculate(num1: Int, num2: Int, oper: Int): Int = {
    var res = 0
    oper match {
      case '+' => res = num1 + num2
      case '-' => res = num2 - num1
      case '*' => res = num1 * num2
      case '/' => res = num2 / num1
      case _ =>
    }
    res
  }
}


