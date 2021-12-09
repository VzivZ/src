package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-09-10 16:14
 **/
public class BTDemo001 {
    private List<List<Integer>> results = new ArrayList<>();
    private List<Integer> tmp = new ArrayList<>();

    private List<List<Integer>> permute(int[] nums) {
        getResults(nums);
        return results;
    }

    private void getResults(int[] nums) {
        if (tmp.size() == nums.length) {
            results.add(new ArrayList<>(tmp));
            return;
        }
        for (int num : nums) {
            if (tmp.contains(num)) continue;
            tmp.add(num);
            getResults(nums);
            tmp.remove(tmp.size() -1 );
        }
    }

    public static void main(String[] args) {
        BTDemo001 permutations = new BTDemo001();
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> list = permutations.permute(nums);
        System.out.println(list);
    }

}
