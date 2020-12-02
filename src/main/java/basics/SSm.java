package basics;

/**
 * @Auther: carver
 * @Date: 2019/2/21 14:36
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class SSm {
    public static void main(String[] args) {
        int[] a ={73,88,904,7,9,10,24,35,65};
        System.out.println(fun(55, a));
    }

    static int fun(int x,int [] a){

        if(a.length == 0) {
            return -1;
        }

        int mid = a.length / 2;

        if(x == a[mid]) {
            return mid;
        } else if(a[mid] < a[a.length - 1]) {
            if (x < a[a.length - 1] && x > a[mid]) {
                return fun(x, a);
            } else {
                for (int i = 0; i < mid; i++) {
                    if (x == a[i]) {
                        return i;
                    }
                }
            }
        } else if(a[0] < a[mid]){
            if(x <= a[mid] && x >= a[0]) {
                return fun(x,a);
            } else {
                for (int i = mid+1; i < a.length; i++) {
                    if(x == a[i]){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
