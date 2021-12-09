package leetcode.daily.no1002;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 1002. 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。 
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 * 提示：
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: HeZhe
 * @date: 2020-10-14 09:55
 **/
public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        // num存储每个字符串中每个字母出现的次数
        int[][] num = new int[A.length][26];
        // minTimes存储在每个字母在所有字符串中出现的最小次数
        int[] minTimes = new int[26];
        for (int i = 0; i < minTimes.length; i++) {
            minTimes[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < A.length; i++) {
            String s = A[i];
            for (int j = 0; j < s.length(); ++j) {
                int pos = s.charAt(j) - 'a';
                num[i][pos]++;
            }
            for (int j = 0; j < 26; ++j) {
                if (num[i][j] < minTimes[j]) minTimes[j] = num[i][j];
            }
        }

        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minTimes[i]; ++j) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String eval = "when 'com.landray.kmss.fssc.purch.model.fsscpurchdemand'then (select  doc_subject from fssc_purch_demand where fd_id = id limit 1)";
        System.out.println(eval.indexOf(" '"));
        System.out.println(eval.indexOf("'"));
        String key = eval.substring(eval.indexOf(" '") + 2, eval.indexOf("' "));
//        System.out.println(key);
    }
}
