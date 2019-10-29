package Linear_Search;

/**
 * 用一维搜索方法(0.618法)求解函数：f(x)=x^3-2x+1的极小点
 * x*≈0.861
 * 给定初始区间[0,2]，收敛精度ε=0.002
 * 第一次缩短区间过程a=0，b=2
 * 计算两点及对应的函数值：
 * x1=a+0.382(b-a)
 * x2=a+0.618(b-a)
 */

public class Method_Golden_section {
    private Double a =new Double(0);
    private Double b =new Double(2);
    private Double x1 =new Double(0);
    private Double x2 =new Double(0);
    private Double x3 =new Double(999);
    private Double epsilon =new Double(0.002);
    private Double fx1 =new Double(0);
    private Double fx2 =new Double(0);

    public void method0618(){
//        double a=0,b=2,x1,x2,x3=999,epsilon=0.002,fx1,fx2;
        x1=a+0.382*(b-a);
        x2=a+0.618*(b-a);
        fx1 = Math.pow(x1, 3) - 2 * x1 + 1;
        fx2 = Math.pow(x2, 3) - 2 * x2 + 1;
        int i=1;
        while(x3>epsilon) {
            i++;
            fx1 = Math.pow(x1, 3) - 2 * x1 + 1;
            fx2 = Math.pow(x2, 3) - 2 * x2 + 1;
            if (fx1 < fx2) {
            b = x2;
            x2 = x1;
            x1 = a + 0.382 * (b - a);
            }
            else {
            a = x1;
            x1 = x2;
            x2 = a + 0.618 * (b - a);
            }
            x3 = Math.abs(x2 - x1);
            System.out.println(toString());
        }
    }

    @Override
    public String toString() {
        return "Method_Golden_section{" +
                "a=" + a +
                ", b=" + b +
                ", x1=" + x1 +
                ", x2=" + x2 +
                ", |a-b|=" + x3 +
                ", fx1=" + fx1 +
                ", fx2=" + fx2 +
                '}';
    }
}
