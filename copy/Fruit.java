package copy;

/**
 * @program: draft
 * @description: 水果Class
 * @author: atong
 * @create: 2020-11-14 16:11
 */
public class Fruit {
    private Integer id;
    private String name;
    private Apple apple;


    public Fruit(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Fruit(Integer id, String name, Apple apple) {
        this.id = id;
        this.name = name;
        this.apple = apple;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name=\"" + name + '\"' +
                ", apple=" + apple +
                '}';
    }
}
