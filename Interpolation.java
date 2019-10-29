package Linear_Search;

import java.util.ArrayList;

/**
 * 二次插值
 * 给定 f 的一个搜索区间，在区间内选择两个试探点，比较
 * 这两点处的函数值，可缩短搜索区间，当区间的长度充分小
 * 时，用区间的中点近似极小点。
 *
 * 可用成功失败法寻找“高-低-高”的三点:x1<x2<x3
 *从而得到搜索区间[x1,x3],
 * 一个试探点即缩短搜索区间。
 *
 * 利用y=fx在区间 x1<x2<x3的函数值fx1>fx2<fx3
 * 作出如下多项式 P(x)=a0+a1x+a2x
 * 它满足条件：
 * averagex = -a1/2a2 = 1/2(x1+x3-c1/c2)
 * c1=(f1-f3)/(x1-x3)
 * c2=((f1-f2)/(x1-x2)-c1)/(x1-x3)
 *
 * 例题：f(x)=3x3-4x+2
 * 给定x0=0，h=1,epsilon=0.2
 * 确定区间[a,b]=[0,3]
 * x1=0, x2=1, x3=3;
 * f1=2, f2=1, f3=71
 * c1=(f1-f3)/(x1-x3)
 * c2=((f1-f2)/(x1-x2)-c1)/(x1-x3)
 * averagex = -a1/2a2 = 1/2(x1+x3-c1/c2)
 * f(averagex)=3x3-4x+2
 * 比较f(averagex)和f(x2),
 * 1)若前者大则比较averagex和x2的大小
 *   若average大则大小大三点为：f1,f2,f(averagex)
 *   否则大小大三点为           f(averagex),f2,f3
 * 2)若后者大则比较averagex和x2的大小
 *   若average大则大小大三点为：f2,f(averagex),f3
 *   否则                     f1,f(averagex),f2
 * 重新计算averagex的值,继续迭代
 *
 */


public class Interpolation {

    /**
     *
     */
    Success_Failure sf = new Success_Failure();
    public void method_Interpolation(){

        /**
         * 用成功失败法找出高低高三点
         */
        ArrayList<Double> ar = sf.method_Suc_Fai();
        double x1= ar.get(ar.size()-3);
        double x2= ar.get(ar.size()-2);
        double x3= ar.get(ar.size()-1);
        double epsilon = 0.2;
        System.out.println("x1="+x1+"   x2="+x2+"   x3="+x3);

        double average=0;
        double e=Math.abs(x2-average);

        while(epsilon<e) {
             double f1=Math.pow(x1,3)*3-4*x1+2;
             double f2=Math.pow(x2,3)*3-4*x2+2;
             double f3=Math.pow(x3,3)*3-4*x3+2;

             double c1=(f1-f3)/(x1-x3);  //23
             double c2=((f1-f2)/(x1-x2)-c1)/(x2-x3);
                    average = 0.5*(x1+x3-c1/c2);

            double fa = Math.pow(average, 3) * 3 - 4 * average + 2;
            System.out.println("average="+average+"     fa="+fa);
            if (fa > f2) {
                if (average > x2) {
                     e=Math.abs(x2-average);
                    x3 = average;
                    f3 = fa;
                } else {
                    e=Math.abs(x2-average);
                    x1 = average;
                    f1 = fa;
                }
            } else {
                if (average > x2) {
                    e=Math.abs(x2-average);
                    x1 = x2;
                    f1 = f2;
                    x2 = average;
                    f2 = fa;
                } else {
                    e=Math.abs(x2-average);
                    x3 = x2;
                    f3 = f2;
                    x2 = average;
                    f2 = fa;
                }
            }
        }
        System.out.println("x*="+average);
    }

}
