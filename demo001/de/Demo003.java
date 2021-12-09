package demo001.de;


import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-07-15 09:25
 **/
public class Demo003 {
    public static void main(String[] args) {
//        String msg = "在模板使用分析中{templateName}模板涉及的流程是最长的，需要关联到{nodeCount}个节点，{personCount}个人；处理最多审批的为{departmentName}部门，有{workflowCount}流程需要经过该部门；需要根据需要进行模板优化";
//        msg = msg.replace("{personCount}",null);


//        String group = ",caixiaofeng,tzzjxm,,caizhengrong,tzzjxm,,cznmw,,dongxuefeng,,dongzhenxia,,gongyuze,tzzjxm,,hanjianhu,tzzjxm,,huangteng2,,taiguard,,tzscgd3,tzzjxm,,tzzjxm,,tzzjxm,xuxiaojie,,tzzjxm,yeyun2,,tzzjxm,zhanglei21,,tzzjxm,zhongchao,,wanghuizhi,,xianguard,,xinpf,,zcbd,,zcbn,,zhangquanbing,,zhouyanfei,";

        String group = ",liufei,,liufei,,gengguoliang,,wuww,,hut,,wangcheng,,zhangyh,,huangrui,,wangwenc,,ljy,,sunfl,,wangjun10,,wangjun10,,wangjun10,,miaojj,,miaojj,,miaojj,";
        //        if (group == null) return model;
        String[] groupIds = group.split(",");
        Set<String> set = new HashSet<>();
        //用set来记录节点涉及的人员
        for (String id : groupIds) {
            if (id == null || "".equals(id)) continue;
            id = id.trim();
            set.add(id);
        }
        System.out.println(set.size());
    }
}
