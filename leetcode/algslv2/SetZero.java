package leetcode.algslv2;

/**
 * @ClassName SetZero
 * @Description 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * 进阶:
 * <p>
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 * @Author HeZhe
 * @Date 2018/11/23 15:07
 */
public class SetZero {
	public static void setZeroes(int[][] matrix) {
		boolean[] m = new boolean[matrix.length];
		boolean[] n = new boolean[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					m[i] = true;
					n[j] = true;
				}
			}
		}
		//填充所有有0的行
		for(int i=0;i<matrix.length;i++){
			if(m[i]==true){
				for(int j = 0;j<matrix[0].length;j++){
					matrix[i][j] = 0;
				}
			}
		}
		//填充所有有0的列
		for(int j=0;j<matrix[0].length;j++){
			if(n[j]==true){
				for(int i=0;i<matrix.length;i++){
					matrix[i][j]=0;
				}
			}
		}
	}

	public static void setZeroes2(int[][] matrix) {

	}
	public static void main(String[] args) {
		int[][] matrix = {
				{0, 1, 2, 0},
				{3, 4, 5, 2},
				{1, 3, 1, 5}
		};
		setZeroes(matrix);
		System.out.println(matrix);
	}
}
