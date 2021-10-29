package jvm.methodArea;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * @program: draft
 * @description: 方法区OOM
 *
 * jdk8中：
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * @author: atong
 * @create: 2021-10-29 21:46
 */
public class MethodAreaOOM extends ClassLoader{
    public static void main(String[] args) {
        int j = 0;
        try {
            MethodAreaOOM methodAreaOOM = new MethodAreaOOM();
            for (int i = 0; i < 10000; i++) {
                //创建cLasswriter对象，用于生成类的二进制字节码
                ClassWriter classWriter = new ClassWriter(0);
                //指明版本号, 修饰符, 类名, 包名, 父类, 接口
                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                //返回byte[]
                byte[] code = classWriter.toByteArray();
                //类的加载
                methodAreaOOM.defineClass("Class" + i, code, 0, code.length);
                j++;

            }
        } finally {
            System.out.println(j);
        }
    }
}
