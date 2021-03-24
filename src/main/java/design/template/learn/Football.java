package design.template.learn;

/**
 * @program: draft
 * @description: 实体子类
 * 继承抽象模板类
 * @author: atong
 * @create: 2021-03-24 17:01
 */
public class Football extends Game{

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}
