package com.zachx7.binaryTree

/**
  * @author zach - 吸柒
  *         二叉树的前中后序遍历 和 查找 代码实现
  */
object BinaryTree {

  def main(args: Array[String]): Unit = {

    val zach = new Node(1, "zach")
    val tom = new Node(2, "Tom")
    val marry = new Node(5, "Marry")
    val kitty = new Node(7, "Kitty")
    val kobe = new Node(9, "Kobe")

    zach.left = tom
    zach.right = marry
    marry.left = kitty
    marry.right = kobe

    val tree = new NodeBinaryTree
    tree.root = zach
    //前序遍历
    //tree.preOrder()
    //中序遍历
    //tree.infixOrder()
    //后序遍历
    //tree.postOrder()

    //    val node = tree.preSearch(29)
    //val node = tree.infixSearch(29)
    val node = tree.postSearch(29)
    if (node != null) {
      printf("当前节点信息：no:%d name:%s\n", node.nodeNo, node.nodeName)
    } else {
      println("没有查找到该节点")
    }
  }

}

class Node(no: Int, name: String) {
  val nodeNo = no
  val nodeName = name
  var left: Node = null
  var right: Node = null


  /**
    * 前序查找
    *
    * @param no
    * @return
    */
  def preSearch(no: Int): Node = {

    // 判断与当前节点的no是否一致，如果相等直接返回
    if (this.no == no) {
      return this
    }
    //定义个变量接收结果
    var resNode: Node = null
    //如果左子节点不为空，继续递归
    if (this.left != null) {
      resNode = this.left.preSearch(no)
    }
    //如果当时结果节点不为空，直接返回
    if (resNode != null) {
      return resNode
    }
    //如果右节点不为空，继续递归
    if (this.right != null) {
      resNode = this.right.preSearch(no)
    }

    return resNode
  }

  /**
    * 前序遍历
    */
  def preOrder(): Unit = {
    printf("当前节点信息：no:%d name:%s\n", no, name)
    if (left != null) {
      left.preOrder
    }
    if (right != null) {
      right.preOrder()
    }
  }

  /**
    * 中序查找
    */
  def infixSearch(no: Int): Node = {

    var resNode: Node = null

    if (this.left != null) {
      resNode = this.left.infixSearch(no)
    }

    if (resNode != null) {
      return resNode
    }

    if (this.no == no) {
      return this
    }

    if (this.right != null) {
      resNode = this.right.infixSearch(no)
    }

    return resNode

  }

  /**
    * 中序遍历
    */
  def infixOrder(): Unit = {
    if (left != null) {
      left.infixOrder
    }
    printf("当前节点信息：no:%d name:%s\n", no, name)
    if (right != null) {
      right.infixOrder
    }
  }

  /**
    * 后序遍历
    */
  def postSearch(no: Int): Node = {

    var resNode: Node = null

    if (this.left != null) {
      resNode = this.left.postSearch(no)
    }

    if (resNode != null) {
      return resNode
    }

    if (this.right != null) {
      resNode = this.right.postSearch(no)
    }

    if (resNode != null) {
      return resNode
    }

    if (this.no == no) {
      return this
    }

    return resNode

  }


  /**
    * 后序遍历
    */
  def postOrder(): Unit = {
    if (left != null) {
      left.postOrder
    }
    if (right != null) {
      right.postOrder
    }
    printf("当前节点信息：no:%d name:%s\n", no, name)
  }

}

class NodeBinaryTree {
  var root: Node = null

  def preSearch(no: Int): Node = {
    if (root == null) {
      null
    } else {
      root.preSearch(no)
    }
  }

  def preOrder(): Unit = {
    if (root != null) {
      root.preOrder()
    }
  }

  def infixSearch(no: Int): Node = {

    if (root != null) {
      root.infixSearch(no)
    } else {
      null
    }

  }

  def infixOrder(): Unit = {
    if (root != null) {
      root.infixOrder()
    }
  }

  def postSearch(no: Int): Node = {
    if (root != null) {
      root.postSearch(no)
    } else {
      null
    }
  }

  def postOrder(): Unit = {
    if (root != null) {
      root.postOrder
    }
  }

}

