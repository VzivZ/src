package demo001.de;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-04-02 09:42
 **/
public class InputTest {
    public static void main(String[] args) {

        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
        String date = "2019-02-29";
//        String date2 = "01-02";
        try {
            Date aaa = formatter.parse(date);

            String aaaStr = formatter.format(aaa);
            System.out.println(aaaStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        List<Map<String, Object>> dataMaps = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("a", "a");
        dataMaps.add(map);
        System.out.println(formatDate(map.get("")));
        List<String> results = new ArrayList<>();
        dataMaps.forEach(entry -> results.add((String) entry.get("id")));
        System.out.println(results.size());

        List<String> names = new ArrayList<>();
        names.add("James");
//        names.add("Harry");
//        names.add("Roy");
        System.out.println(String.join(",", names));

        //Ҫת����list����
        List<String> testList = new ArrayList<String>() {{
            add("AA");
            add("bb");
            add("cc");
        }};
        for (String s : testList) {
            if (s.toLowerCase().contains("a")) {
                System.out.println(s);
            }
        }

        //ʹ��toArray(T[] a)����
        String[] array2 = testList.toArray(new String[0]);

//��ӡ������
        for (String s : array2) {
            System.out.println(s);
        }
    }

    private static String formatDate(Object date) {
        if (date == null) return "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }
}
