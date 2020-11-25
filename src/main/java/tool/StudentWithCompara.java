package tool;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;

/**
 * @Auther: carver
 * @Date: 2019/1/21 12:29
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class StudentWithCompara implements Comparable<StudentWithCompara>{
    private String name;
    private int age;

    public StudentWithCompara(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(StudentWithCompara o) {
        //比较年龄(年龄的升序)
        return this.age - o.age;
    }
}
