package common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: draft
 * @description: Person implements Comparable
 * @author: atong
 * @create: 2021-05-08 10:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Comparable<Person>{

    private String name;
    private Integer age;

    /**
     * 重写compareTo方法, 按age排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Person o) {
        if (this.age > o.getAge()) {
            return 1;
        }else if (this.age.equals(o.getAge())) {
            return 0;
        }else {
            return -1;
        }
    }
}
