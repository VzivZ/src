package demo001;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-05-22 17:04
 **/
public class ForInvertion {
    public static void main(String[] args) {
//        String fileName = "F:\\ch.txt";   //定义一个文件的路径
//        File file = new File(fileName); //初始化一个java中的文件对象。
//        try {
//            FileInputStream fis = new FileInputStream(file);     //初始化一个关于文件的输入流对象
//            InputStreamReader ris = new InputStreamReader(fis);    //建立一个字节流和字符流的读写桥梁
//            //按字节读取数据
//            int cc;
//            String str = "";
//            while ((cc = ris.read()) > 0) {
//                char xm = (char) cc;
//                str += xm;
//            }
//            //System.out.println(str);      //检测读取成功的数据，打印到控制台。
//            ris.close();
//            fis.close();   //关闭桥梁和流对象，文件读取中很重要
//            //在内存中调整字符串的位置--->倒序
//            int length = str.length();
//            String Invertion = str;
////            for (int i = length - 1; i >= 0; i--) {
////                Invertion += str.charAt(i);
////            }
////         System.out.println(Invertion);       //检测调整成功之后的数据，打印到控制台。
//            PrintWriter out = new PrintWriter(file);
//            out.print(Invertion);          //建立一个写文件的对象并写到文件中。写之前会默认清空文件
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        String aaa = "gggggg";
        String[] arr = aaa.split(",");
        System.out.println(arr.length);
    }
}
