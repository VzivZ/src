package leetcode.tencent.stringorarray;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName SpiralOrder1
 * @Description
 * @Author VzivZ
 * @Date 2018/11/1 15:01
 */
public class SpiralOrder1 {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new LinkedList<>();
		if(matrix.length == 0) return res;
		int m = matrix.length, n = matrix[0].length;
		// 计算圈数
		int lvl = (Math.min(m, n) + 1) / 2;
		for(int i = 0; i < lvl; i++){
			// 计算相对应的该圈最后一行
			int lastRow = m - i - 1;
			// 计算相对应的该圈最后一列
			int lastCol = n - i - 1;
			// 如果该圈第一行就是最后一行，说明只剩下一行
			if(i == lastRow){
				for(int j = i; j <= lastCol; j++){
					res.add(matrix[i][j]);
				}
				// 如果该圈第一列就是最后一列，说明只剩下一列
			} else if(i == lastCol){
				for(int j = i; j <= lastRow; j++){
					res.add(matrix[j][i]);
				}
			} else {
				// 第一行
				for(int j = i; j < lastCol; j++){
					res.add(matrix[i][j]);
				}
				// 最后一列
				for(int j = i; j < lastRow; j++){
					res.add(matrix[j][lastCol]);
				}
				// 最后一行
				for(int j = lastCol; j > i; j--){
					res.add(matrix[lastRow][j]);
				}
				// 第一列
				for(int j = lastRow; j > i; j--){
					res.add(matrix[j][i]);
				}
			}
		}
		return res;
	}

	/**
	 * [
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	 ]
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = {
				          {1, 2, 3 },
				          {4, 5, 6 },
				          {7, 8, 9 }
		                 };
		spiralOrder(matrix);
	}
}
