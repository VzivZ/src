package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: VzivZ
 * @date: 2020-09-10 14:14
 **/
public class Permutations {
    private List<List<Integer>> results = new ArrayList<>();
    private List<Integer> tmp = new ArrayList<>();

    private List<List<Integer>> permute(int[] nums) {
        int[] visited = new int[nums.length];
        getResult(nums, visited);
        return results;
    }

    private void getResult(int[] nums, int[] visited) {
        if (tmp.size() == nums.length) {
            results.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            getResult(nums, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
//        Permutations permutations = new Permutations();
//        int[] nums = {1, 2, 3};
//        List<List<Integer>> list = permutations.permute(nums);
//        System.out.println(list);
        List<String> businessCodeList = new ArrayList<>();
        businessCodeList.add("root");

        if(businessCodeList.contains("root")){
            System.out.println("businessCodeList.contains(\"root\")");
        }

    }
}
