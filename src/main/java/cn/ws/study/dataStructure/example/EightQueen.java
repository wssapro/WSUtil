package cn.ws.study.dataStructure.example;

/**
 * 八皇后问题
 *
 * @author : Host-424
 * @date Date : 2022-03-01 10:31
 */
public class EightQueen {
    public static int[][] arr = new int[8][8];

    public static void main(String[] args) {
        findQueen(0);
    }


    public static void findQueen(int row) {
        if(row==8){
            // 获取到一种解
            System.out.println("-------------------------------------");
            for (int[] ints : arr) {
                for (int anInt : ints) {
                    System.out.print(anInt);
                }
                System.out.println();
            }
            System.out.println("-------------------------------------");
            return;
        }
       for (int i = 0; i < 8; i++) {
            if (!is(row, i)) {
                continue;
            }
            arr[row][i] = 1;
            findQueen(row+1);
            arr[row][i] = 0;
        }
    }

    public static boolean is(int row, int col) {
        // 检查行左侧
        for (int i = 0; i < col; i++) {
            if (arr[row][i] == 1) {
                return false;
            }
        }
        // 检查列上面
        for (int i = 0; i < row; i++) {
            if (arr[i][col] == 1) {
                return false;
            }
        }
        // 检查对角左上侧
        for (int i = row-1,j = col-1; i>=0 && j >=0; i--,j--) {
            if (arr[i][j] == 1) {
                return false;
            }
        }
        // 检查对角右上侧
        for (int i = row-1,j = col+1; i>=0 && j <8; i--,j++) {
            if (arr[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
