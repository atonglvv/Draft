package jvm;

/**
 * @program: draft
 * @description: 逃逸分析
 * 如何快速判断是否发生了逃逸, 看new的对象是否有可能在方法外被调用
 * @author: atong
 * @create: 2021-10-25 23:03
 */
public class EscapeAnalysis {

    /** 如果当前的obj引用声明为static的? 仍然会发生逃逸。*/
    public EscapeAnalysis obj;

    /* 方法返回EscapeAnalysis对象，发生逃逸 */
    public EscapeAnalysis getInstance(){
        return obj == null ? new EscapeAnalysis() : obj;
    }

    /* 为成员属性赋值，发生逃逸 */
    public void setobj(){
        this.obj = new EscapeAnalysis();
    }

    /* 对象的作用域仅在当前方法中有效，没有发生逃逸*/
    public void useEscapeAnalysis(){
        EscapeAnalysis e = new EscapeAnalysis();
    }

    /* 引用成员变量的值，发生逃逸 , 因为getInstance 创建了成员变量obj */
    public void useEscapeAnalysis1(){
        EscapeAnalysis e = getInstance();
    }


}
