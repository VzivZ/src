package demo001;

import java.util.regex.Pattern;

/**
 * @description: 数据库反注入校验
 * @author: VzivZ
 * @date: 2019-12-17 09:33
 **/
public class AntiInjectionUtils {

    private static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
            + "(\\b(select|update|union|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|drop|execute)\\b)";
    //\\b  表示 限定单词边界  比如  select 不通过   1select则是可以的
    private static Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);

    public static void injectionCheck(String column){
        if (sqlPattern.matcher(column).find()) {
            try {
                throw new Exception("参数异常,有SQL注入风险");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
