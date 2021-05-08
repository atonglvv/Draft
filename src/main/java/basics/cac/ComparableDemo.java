package basics.cac;

import common.Person;

/**
 * @program: draft
 * @description: Comparable Demo
 * @author: atong
 * @create: 2021-05-08 10:32
 */
public class ComparableDemo {
    public static void main(String[] args) {
        Person person1 = new Person("atong", 19);
        Person person2 = new Person("yaoyao", 20);

        int result = person1.compareTo(person2);
        if (result > 0) {
            System.out.println("atong");
        }else if (result == 0){
            System.out.println("same");
        }else {
            System.out.println("yaoyao");
        }
    }
}
