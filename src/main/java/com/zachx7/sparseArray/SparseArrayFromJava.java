package com.zachx7.sparseArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zach - 吸柒
 * Java版本 数据结构 - 稀疏数组
 */
public class SparseArrayFromJava {

    public static void main(String[] args) {
        int rowSize = 11;
        int colSize = 11;

        //定义一个11行11列的二维数组 类型为Integer
        int[][] chessMap = new int[rowSize][colSize];

        chessMap[1][2] = 1;
        chessMap[2][3] = 2;

        //输出初始棋盘
        for (int[] integers : chessMap) {

            for (int integer : integers) {
                System.out.print(integer + "\t");
            }
            //换行
            System.out.println();
        }
        // 稀疏数组的实现
        List<ChessData> sparseList = new ArrayList<ChessData>();
        //将原始数据写入数组第一行
        sparseList.add(new ChessData(rowSize, colSize, 0));

        //遍历棋盘
        for (int i = 0; i < chessMap.length; i++) {
            for (int j = 0; j < chessMap[i].length; j++) {
                //判断棋盘上是否有子，不为0将数值保存到数组中
                if (chessMap[i][j] != 0) {
                    sparseList.add(new ChessData(i, j, chessMap[i][j]));
                }
            }
        }

        System.out.println("-------------稀疏数组展示--------------");
        for (ChessData chessData : sparseList) {
            System.out.println(chessData);
        }

        //写出数据
        File path = new File("d:/data.txt");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(sparseList);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //读取数据
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            List<ChessData> sparseList2 = (List<ChessData>) ois.readObject();

            //恢复原始数据
            ChessData data = sparseList2.get(0);
            int rowSize2 = data.row;
            int colSize2 = data.col;
            //恢复原始棋盘的大小
            int[][] chessMap2 = new int[rowSize2][colSize2];

            for (int i = 1; i < sparseList2.size(); i++) {
                //获得有值的数据，恢复数据
                ChessData cd = sparseList2.get(i);
                chessMap2[cd.row][cd.col] = cd.value;
            }

            System.out.println("-------------稀疏数组恢复原始数据展示--------------");
            for (int[] integers : chessMap2) {

                for (int integer : integers) {
                    System.out.print(integer + "\t");
                }
                //换行
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

class ChessData implements Serializable {

    int row;
    int col;
    int value;

    public ChessData(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "row=" + row + "\t col=" + col + "\t value=" + value;
    }
}
