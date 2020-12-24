package collections.set;

import tool.StudentWithCompara;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Auther: carver
 * @Date: 2019/1/21 12:28
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class TreeSetForCompare {

    public static void main(String[] args) {
        // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        Set<StudentWithCompara> set = new TreeSet<>();

        set.add(new StudentWithCompara("Carver",18));
        set.add(new StudentWithCompara("mwwfe",19));
        set.add(new StudentWithCompara("ahh",22));
        set.add(new StudentWithCompara("a",16));

        set.forEach(x -> System.out.println(x));

    }
}
