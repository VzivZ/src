package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: HeZhe
 * @date: 2020-09-10 11:24
 **/
public class CombinationsPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        traceBack("", digits, 0);
        return resList;
    }

    private List<String> resList = new ArrayList<>();
    private String[] letterMap = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void traceBack(String temp, String digits, int index) {
        if (index == digits.length()) {
            resList.add(temp);
            return;
        }
        for (Character c : letterMap[Integer.valueOf(String.valueOf(digits.charAt(index)))].toCharArray()) {
            traceBack(temp + c, digits, index + 1);
        }
    }


    public static void main(String[] args) {
        CombinationsPhoneNumber combinationsPhoneNumber = new CombinationsPhoneNumber();
        List<String> list = combinationsPhoneNumber.letterCombinations("235");
        System.out.println(list);
    }
}
