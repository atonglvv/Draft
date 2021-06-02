package basics.extendss;

import java.io.Serializable;

/**
 * @program: draft
 * @description: father  私有构造函数, 子类不能继承
 * @author: atong
 * @create: 2021-06-02 16:00
 */
public class Father implements Serializable {
    private String name;

    private Father() {
        this.name = "father";
    }
}
