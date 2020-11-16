package copy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: draft
 * @description: 深拷贝浅拷贝相关
 * @author: atong
 * @create: 2020-11-14 16:07
 */
public class Copy {
    public static void main(String[] args) {
        //返回的结果集 fruits
        List<Fruit> fruits = new ArrayList<>();

        Fruit fruit1 = new Fruit(1, "水果1");
        Fruit fruit2 = new Fruit(2, "水果2");

        Apple apple1 = new Apple(1, "apple1", 1);
        Apple apple2 = new Apple(2, "apple2", 1);
        Apple apple3 = new Apple(3, "apple3", 1);
        Apple apple4 = new Apple(4, "apple4", 2);
        Apple apple5 = new Apple(5, "apple5", 2);

        //将fruit组装为map, key为fruit的id, value为fruit
        Map<Integer, Fruit> fruitMap = new HashMap<>();
        fruitMap.put(fruit1.getId(), fruit1);
        fruitMap.put(fruit2.getId(), fruit2);

        //将apple放到List中
        List<Apple> apples = new ArrayList<>();
        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
        apples.add(apple4);
        apples.add(apple5);

        for (Apple apple : apples) {
            //根据apple的fruitId找到对应的spu
            Fruit fruit = fruitMap.get(apple.getFruitId());
            if (null != fruit) {
                //将apple放到所属的fruit中
                fruit.setApple(apple);
                //将fruit放到list中
                fruits.add(fruit);
            }
        }

        System.out.println(fruits.toString());

    }
}
