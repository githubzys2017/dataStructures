package com.atguigu.sparsearray;

/**
 * @Author: 张永帅
 * @Description:
 * @Date: Create in 20:22 2020/7/28
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11 * 11
        //0: 表示没有棋子， 1：表示黑子，  2：表示蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始的的二维数组
        System.out.println("原始的二维数组··");
        for (int[] row : chessArr1) {
            for (int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
         }
        //将二维数组转稀疏数组的思路
        //1. 先遍历二维数组  得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
        int[][] chessArr2 = new int[sum + 1][3];
        chessArr2[0][0] = 11;
        chessArr2[0][1] = 11;
        chessArr2[0][2] = sum;
        sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    ++sum;
                    chessArr2[sum][0] = i;
                    chessArr2[sum][1] = j;
                    chessArr2[sum][2] = chessArr1[i][j];
                }
            }
        }
        //打印
        for (int[] row : chessArr2) {
            for (int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //恢复成二维数组
        int chessArr3[][] = new int[chessArr2[0][0]][chessArr2[0][1]];

        for (int i = 1; i < chessArr2.length; i++) {
            chessArr3[chessArr2[i][0]][chessArr2[i][1]] = chessArr2[i][2];
        }
        System.out.println("恢复二维数组");
        //打印二维数组
        for (int[] row : chessArr3) {
            for (int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
