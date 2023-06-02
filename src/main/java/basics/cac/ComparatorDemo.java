package basics.cac;

import common.PersonC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: draft
 * @description: Comparator Demo
 * @author: atong
 * @create: 2021-05-08 21:51
 */
public class ComparatorDemo {
    public static void main(String[] args) {
        PersonC person1 = new PersonC("atong", 19);
        PersonC person2 = new PersonC("zz", 20);


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

        System.out.println("============================");
        List<PersonC> collect1 = persons.stream().sorted(Comparator.comparing(PersonC::getAge, (x,y) -> {
            if(x == null && y != null){
                return 1;
            }else if(x !=null && y == null){
                return -1;
            }else if(x == null){
                // x y 都为null
                return 0;
            }else {
                if (x.equals(y)) {
                    return 0;
                } else if (x < y) {
                    return 1;
                } else {
                    return -1;
                }
            }
        })).collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println("===============================");
        persons.add(new PersonC("2",  2));
        persons.add(new PersonC("3",  1));
        persons.add(new PersonC("4",  0));
        persons.add(new PersonC("5",  0));
        persons.add(new PersonC("6",  2));
        persons.add(new PersonC("7",  2));
        persons.add(new PersonC("8",  1));
        persons.add(new PersonC("9",  1));
        persons.add(new PersonC("10",  1));
        persons.add(new PersonC("11",  2));
        List<PersonC> collect2 = persons.stream().sorted(Comparator.comparing(PersonC::getAge, (x,y) -> {
            if(x == null && y != null){
                return 1;
            }else if(x !=null && y == null){
                return -1;
            }else if(x == null){
                // x y 都为null
                return 0;
            }else {
                if (x.equals(y)) {
                    return 0;
                }
                if (x==1) {
                    return -1;
                }
                if (x==2) {
                    return 1;
                }
                if (y==1) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }).thenComparing(PersonC::getName)).collect(Collectors.toList());
        System.out.println(collect2);
    }
}
