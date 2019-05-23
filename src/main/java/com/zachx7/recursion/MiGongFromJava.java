package com.zachx7.recursion;

/**
 * @author zach - 吸柒
 */
public class MiGongFromJava {

    public static void main(String[] args) {

        int[][] map = new int[8][7];

        createWall(map);

        showMap(map);

        findWay(map, 1, 1);

        System.out.println();

        showMap(map);

    }

    /**
     * 寻找回家的路
     * 规则： 0代表没走过 1代表 墙 2代表已走过 3代表无法走
     * 查找策略： 上 -》 右 -》 下 -》 左
     *
     * @param map
     * @param i
     * @param j
     */
    private static boolean findWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (findWay(map, i - 1, j)) {
                    return true;
                } else if (findWay(map, i, j + 1)) {
                    return true;
                } else if (findWay(map, i + 1, j)) {
                    return true;
                } else if (findWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                // 如果不是0，证明已经走过
                return false;
            }
        }
    }

    /**
     * 生成墙壁
     *
     * @param map
     */
    private static void createWall(int[][] map) {
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
    }

    /**
     * 打印迷宫
     *
     * @param map
     */
    private static void showMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length - 1; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
