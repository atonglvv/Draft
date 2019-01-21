package basics;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Auther: carver
 * @Date: 2019/1/17 19:14
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class Variable {

    public static String nameClass = "carver";

    public String nameObject = "carverObject";

    public static int age;

    public String nameb;

    public static void main(String[] args){

        Map<String,Object> code = new TreeMap<>();

        System.out.println("类成员变量：" + nameClass);
        System.out.println("类成员变量(未初始化)：" + age);

        //局部变量没有默认值，因此本地变量必须被声明并且在第一次使用前要给它赋值
        //局部变量未初始化:
        // 编译时错误 ：Variable 'agea' might not have been initialized
        int agea;
//        System.out.println("局部变量(未初始化):" + agea);


        Variable variable = new Variable();
        System.out.println("Blessing：" + variable.print("I Love U！") );


    }

    /**
     * 方法描述：输出对中国祝福的内容
     * @param str
     * @return
     */
    public String print(String str){
        //局部变量
        String str1 = "China,";
        return str1 + str;
    }


}
