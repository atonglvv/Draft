package basics.innerclass.member;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-04-25 14:00
 */
public class AOuterPrivate {
    private class Inner {
        public void show() {
            System.out.println("密码备份文件");
        }
    }

    /** 获取成员内部类，可以增加校验语句 */
    public Inner getInner() {
        return new Inner();
    }

    public void method(boolean permission) {
        if(permission){
            Inner i = new Inner();
            i.show();
        }else {
            System.out.println("你没有权限访问");
        }
    }

    public static void main(String[] args) {
        AOuterPrivate outer = new AOuterPrivate();
        AOuterPrivate.Inner inner = outer.getInner();
        inner.show();
    }
}
