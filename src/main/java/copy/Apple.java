package copy;

/**
 * @program: draft
 * @description: 苹果Class, 对应Fruit, n->1
 * @author: atong
 * @create: 2020-11-14 16:08
 */
public class Apple {
    private Integer id;
    private String name;
    private Integer fruitId;

    public Apple(Integer id, String name, Integer fruitId) {
        this.id = id;
        this.name = name;
        this.fruitId = fruitId;
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

    public Integer getFruitId() {
        return fruitId;
    }

    public void setFruitId(Integer fruitId) {
        this.fruitId = fruitId;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", name=\"" + name + '\"' +
                ", fruitId=" + fruitId +
                '}';
    }
}
