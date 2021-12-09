package demo001.de;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-07-10 18:41
 **/
public class Demo002 {
    static Pattern pattern = Pattern.compile("\\!.*businessCode\\!", Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {
        String sql = "select\n" +
                "        t2.business_catalog_id,\n" +
                "        t1.name as businessCatalogName,\n" +
                "        t2.over30dayCount,\n" +
                "        t2.totalAmount,\n" +
                "        t2.maxTimes,\n" +
                "        t2.minTimes,\n" +
                "        t2.avgTimes\n" +
                "        from mds_cf_business_catalog t1  left join (\n" +
                "        select\n" +
                "        t2.business_catalog_id,\n" +
                "        count(   if ( work_times > 2592000, t2.id, null ) ) AS over30dayCount,\n" +
                "        count(   t2.id ) AS totalAmount,\n" +
                "        max( work_times ) AS maxTimes,\n" +
                "        min( work_times ) AS minTimes,\n" +
                "        AVG( work_times ) AS avgTimes,\n" +
                "        business_code\n" +
                "        FROM\n" +
                "        bdl_finish_workflow t2\n" +
                "        where  t2.year = ?\n" +
                "        and !t2.businessCode!\n" +
                "        and t2.is_business = 1\n" +
                "        \n" +
                "        \n" +
                "         \n" +
                "            and locate( 'bb38a482307a359ff06a94821776de86', t2.business_department_path_id ) > 0\n" +
                "         \n" +
                "         \n" +
                "        group by\n" +
                "        t2.business_catalog_id,business_code\n" +
                "        ) t2 on t1.business_code=t2.business_code and t1.id=t2.business_catalog_id\n" +
                "        where t1.is_available=1 and t2.business_catalog_id is not null\n";
        String sql001 = checkBusinessCode(sql,"root/hhhh");
        System.out.println(sql001);
    }


    public static  String checkBusinessCode(String sql,String businessCode){
        Matcher matcher = pattern.matcher(sql);

        while(matcher.find()){

            System.out.println("222222222222222222222222222222222222222222222222222222222 " + businessCode);
            //每一个符合正则的字符串
            String e = matcher.group();
            String reslut_1=e.replaceAll("!","");
            e=e.replace("!","\\!");
            if(reslut_1.indexOf(".")>=0) {
                String reslut = reslut_1.substring(0, reslut_1.indexOf(".") + 1);
                if(businessCode.equalsIgnoreCase("root"))
                    sql = sql.replaceFirst(e,  reslut + "businessCode is not null");
                else if(businessCode.toLowerCase().indexOf("root")==0  )
                    sql = sql.replaceFirst(e,  reslut + "businessCode='"+businessCode+"'");
                else if(businessCode.toLowerCase().indexOf("'root")==0  )
                    sql = sql.replaceFirst(e,  reslut + "businessCode="+businessCode);
            }else{
                if(businessCode.equalsIgnoreCase("root"))
                    sql = sql.replaceFirst(e,    "businessCode is not null");
                else if(businessCode.toLowerCase().indexOf("root")==0  )
                    sql = sql.replaceFirst(e,    "businessCode='"+businessCode+"'");
                else if(businessCode.toLowerCase().indexOf("'root")==0  )
                    sql = sql.replaceFirst(e,   "businessCode="+businessCode);
            }
        }

        return sql;
    }
}
