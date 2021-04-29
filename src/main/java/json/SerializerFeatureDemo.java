package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import common.Student;

import java.util.Date;

/**
 * @program: draft
 * @description:
 * SerializerFeature 枚举 : 使用JSON静态方法 toJSONString()进行序列化时,可以自定义特殊需求
 * 方法的参数:第一个是要序列化的对象
 * 方法的参数:第二个参数SerializerFeature枚举类型的可变参数
 * @author: atong
 * @create: 2021-04-29 20:59
 */
public class SerializerFeatureDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(19);

        Student studenta = new Student();
        studenta.setName("atong");
        studenta.setBirthday(new Date());

        String s = JSON.toJSONString(student);
        System.out.println(s);

        String sa = JSON.toJSONString(studenta);
        System.out.println(sa);

        //添加枚举类型参数 WriteMapNullValue , 序列化的时候,值为null的也会输出 null
        String s1 = JSON.toJSONString(student, SerializerFeature.WriteMapNullValue);
        System.out.println(s1);

        //添加枚举类型参数 WriteNullStringAsEmpty , 序列化的时候,值为null的也会输出为 空字符串
        String s2 = JSON.toJSONString(student, SerializerFeature.WriteNullStringAsEmpty);
        System.out.println(s2);

        //添加枚举类型参数 WriteNullNumberAsZero , 序列化的时候,值为null的也会输出为 0
        String s3 = JSON.toJSONString(studenta, SerializerFeature.WriteNullNumberAsZero);
        System.out.println(s3);

        //添加枚举类型参数 WriteDateUseDateFormat , 序列化的时候,格式化日期
        String s4 = JSON.toJSONString(studenta, SerializerFeature.WriteDateUseDateFormat);
        System.out.println(s4);


        //添加枚举类型参数 WriteDateUseDateFormat , 序列化的时候,格式化日期, 并格式化Json
        String s5 = JSON.toJSONString(studenta, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.PrettyFormat);
        System.out.println(s5);





    }
}
