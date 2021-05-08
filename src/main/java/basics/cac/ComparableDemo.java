package basics.cac;

import common.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        System.out.println("谁的年龄更大呢?");
        int result = person1.compareTo(person2);
        if (result > 0) {
            System.out.println("atong");
        }else if (result == 0){
            System.out.println("same");
        }else {
            System.out.println("yaoyao");
        }

        List<Person> persons = new ArrayList<>();
        persons.add(person2);
        persons.add(person1);
        System.out.println(persons);
        //使用Collections排序 [注意：如果不实现Compareable接口,则不能使用Collections.sort()]
        Collections.sort(persons);
        System.out.println(persons);
    }
}
