package exercises.e01;

import java.util.StringTokenizer;

/**
 * @program: draft
 * @description: 学生信息entity
 * @author: atong
 * @create: 2020-11-30 16:00
 */
public class Student {
    public String name;
    public Integer age;
    /** Gender Enum **/
    public Gender gender;
    public Integer height;
    public Integer weight;

    //根据文本中的一行数据, 构造Student对象
    public Student(String line) {
        //根据 逗号空格 拆分(注意中文逗号与英文逗号)
        String[] kvs = line.split("[,，] ");
        for (String kv : kvs) {
            //根据 冒号 分割 key 与 value
            String[] split = kv.split(": *");
            String key = split[0];
            String value = split[1];
            //匹配字段
            switch (key) {
                case "name" :
                    this.name = value;
                    break;
                case "age" :
                    this.age = Integer.valueOf(value.replace("岁", ""));
                    break;
                case "gender":
                    this.gender = Gender.formValue(value);
                    break;
                case "height":
                    this.height = Integer.parseInt(value.replace("cm", ""));
                    break;
                case "weight":
                    this.weight = Integer.parseInt(value.replace("kg", ""));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + key);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
