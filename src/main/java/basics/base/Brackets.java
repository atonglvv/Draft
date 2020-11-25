package basics.base;

import java.util.Stack;

/**
 * @Auther: carver
 * @Date: 2019/4/11 12:59
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 判断"(())())()"中前后括号是否匹配
 */
public class Brackets {
    public static void main(String[] args) {
        String brackets = "(())())()";
        Brackets b = new Brackets();
        System.out.println(b.isMatch(brackets));
    }

    public boolean isMatch(String barckets) {
        //栈声明
        Stack stack = new Stack();
        int i = 0;
        while (i < barckets.length()) {
            //如果是 ( 则入栈，若是 ) 则出栈并判断是否栈为空，若为空则返回false
            if (barckets.charAt(i) == '(') {
                stack.push('(');
            }if (barckets.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            i++;
        }
        if (stack.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
}
