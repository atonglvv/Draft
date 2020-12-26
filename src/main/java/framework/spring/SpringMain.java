package framework.spring;

import framework.spring.bean.BeanTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: draft
 * @description: springSourceReader
 * @author: atong
 * @create: 2020-12-26 14:23
 */
@Configuration
@ComponentScan(basePackages = {"framework.spring"})
public class SpringMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext aac = new AnnotationConfigApplicationContext();
        BeanTest bean = aac.getBean(BeanTest.class);
        System.out.println(bean);
    }
}
