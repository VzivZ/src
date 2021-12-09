package leetcode.daily.no130;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-08-11 14:49
 **/
public class Test {
    public static void main(String[] args) {
        SurroundedRegions solution = new SurroundedRegions();
        char[][] arr = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solution.solve(arr);
        for (char[] chars : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }
}
