package leetcode.daily.offer20;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-09-02 14:58
 **/
public class Solution {
    public boolean isNumber(String s) {
        boolean result = true;
        try {
            Double.valueOf(s);
        } catch (Exception e) {
            result = false;
        }

        if (result && (s.contains("f") || s.contains("F") || s.contains("d") || s.contains("D"))) {
            result = false;
        }

        return result;
    }
}
