package lanwahle;

//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @description: 运行脚本的工具类
 * @author: HeZhe
 * @date: 2019-08-06 10:53
 **/
//@PropertySource("classpath:config/application-dev.properties")
public class ScriptRunnerUtil {

    private static String url = "jdbc:mysql://202.105.139.181:3306/y_dmp_dev_ss?" +
            "useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false&maxReconnects=10&useSSL=false&allowMultiQueries=true";
    private static String username = "chengsisi";
    private static String password = "chengsisi@1234";
    private static Connection connection = null;
    private static String[] fileArr = new String[]{"mds_cf_dic_holiday.sql",
            "mds_cf_model_rule.sql", "mds_cf_standard_time.sql", "mds_st_dic.sql", "mds_st_dic_mapping.sql", "mds_year_month_dic.sql", "mds_year_week_dic.sql"};

//    public static void main(String[] args) {
//        try {
//            executeSQLScript();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 执行脚本
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static String executeSQLScript() throws ClassNotFoundException, SQLException {
        InputStream inputStream;
        for (String s : fileArr) {
//            connection = DriverManager.getConnection(url, username, password);
//            ScriptRunner scriptRunner = new ScriptRunner(connection);
//            inputStream = ScriptRunnerUtil.class.getResourceAsStream("/script/" + s);
//            String className = "com.mysql.jdbc.Driver";
//            Class.forName(className);
//            Resources.setCharset(Charset.forName("UTF-8"));
//
//            scriptRunner.runScript(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
//
//            scriptRunner.closeConnection();
//            connection.close();
        }
        return "ok";
    }
}
