package leetcode.algslv1;

/**
 * @Description:
 * @Author VzivZ
 * @Date 2021/3/2 14:12
 */
public class Demo0302 {

    int[][] matrixVal;

    public void NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        int row = matrix.length;
        int col = matrix[0].length;
        this.matrixVal = new int[row + 1][col + 1];

        // 初始化 二维前缀和数组
        for (int i = 1; i <= row; i++) {
            // tmp[j]存储第i行前j个元素和
            int[] tmp = new int[col + 1];

            for (int j = 1; j <= col; j++) {
                // tmp和matrixVal的起点是1,matrix的起点是0
                tmp[j] = tmp[j - 1] + matrix[i - 1][j - 1];
                matrixVal[i][j] = matrixVal[i - 1][j] + tmp[j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrixVal[row2 + 1][col2 + 1]
                - matrixVal[row2 + 1][col1]
                - matrixVal[row1][col2 + 1]
                + matrixVal[row1][col1];
    }
}
