package basics.cac;

import common.PersonC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-05-08 21:51
 */
public class ComparatorDemo {
    public static void main(String[] args) {
        PersonC person1 = new PersonC("atong", 19);
        PersonC person2 = new PersonC("yaoyao", 20);


        List<PersonC> persons = new ArrayList<>();
        persons.add(person2);
        persons.add(person1);
        System.out.println(persons);
        //使用Collections排序
        Collections.sort(persons, new Comparator<PersonC>() {
            @Override
            public int compare(PersonC o1, PersonC o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        //List内部sort方法
        persons.sort(new Comparator<PersonC>() {
            @Override
            public int compare(PersonC o1, PersonC o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        //stream 排序
        List<PersonC> collect = persons.stream().sorted((x, y) -> x.getAge() - y.getAge()).collect(Collectors.toList());
        List<PersonC> collecta = persons.stream().sorted(Comparator.comparingInt(PersonC::getAge)).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collecta);
        System.out.println(persons);
    }
}
