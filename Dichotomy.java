package Linear_Search;

/**
 * 试用二分法求fx=x^3-2x+1的极小点。
 * 给定初始区间[0,2]，收敛精度epsilon<0.004
 * 函数的导数f`x=3x^2-2
 */
public class Dichotomy {
    private Double a =new Double(0);
    private Double b =new Double(2);
    private Double x1 =new Double(0);
    private Double abs =new Double(999);
    private Double fx1 = new Double(0);
    private Integer i = new Integer(0);

    public void method_Dichotomy(){
        double epsilon=0.004;
        fx1 = Math.pow(x1, 2)*3 - 2;
        while(abs>epsilon) {
            i++;
            if (fx1<0) {
                a = x1;
                x1=(a+b)/2;
                fx1 = Math.pow(x1, 2)*3 - 2;
                System.out.println(toString());
            }
            else {
                b = x1;
                x1=(a+b)/2;
                fx1 = Math.pow(x1, 2)*3 - 2;
                System.out.println(toString());
            }
            abs = Math.abs(a-b);  //精度要求
        }
        fx1 = Math.pow((a+b)/2, 3) - 2 * x1 + 1;
        System.out.println("x*="+(a+b)/2);
    }

    @Override
    public String toString() {
        return "Dichotomy{" +
                "a=" + a +
                ", b=" + b +
                ", x1=" + x1 +
                ", abs=" + abs +
                ", fx1=" + fx1 +
                ", i=" + i +
                '}';
    }
}
